package BakeSale

data class Charges(
    val chargeForGroups: Double = 0.0,
    var remainderOf3: Int = 0
)

fun chargeForCakes(cakes: Int, groupOf15Charge: Double, groupOf5Charge: Double, groupOf3Charge: Double): Charges {
    val remainderOf15 = cakes % 15
    val groupsOf15 = cakes / 15
    val remainderOf5 = remainderOf15 % 5
    val groupsOf5 = remainderOf15 / 5
    val remainderOf3 = remainderOf5 % 3
    val groupsOf3 = remainderOf5 / 3
    val chargeForGroups = (groupsOf15 * groupOf15Charge) + (groupsOf5 * groupOf5Charge) + (groupsOf3 * groupOf3Charge)
    return Charges(chargeForGroups, remainderOf3)
}

fun checkout(veganCakes: Int, nonVeganCakes: Int): Double {
    val chargesForNonVeganCake = chargeForCakes(nonVeganCakes, 5.0, 3.0, 2.0)
    val chargesForVeganCakes = chargeForCakes(veganCakes, 6.0, 4.0, 3.0)

    val mixedGroupsOf3 = (chargesForNonVeganCake.remainderOf3 + chargesForVeganCakes.remainderOf3) / 3

    if (mixedGroupsOf3 > 0) {
        chargesForVeganCakes.remainderOf3 =
            (chargesForNonVeganCake.remainderOf3 + chargesForVeganCakes.remainderOf3) % 3
        chargesForNonVeganCake.remainderOf3 = 0
    }

    return chargesForNonVeganCake.chargeForGroups + chargesForVeganCakes.chargeForGroups + (mixedGroupsOf3 * 2.4) +
            chargesForNonVeganCake.remainderOf3 + (chargesForVeganCakes.remainderOf3 * 1.5)
}