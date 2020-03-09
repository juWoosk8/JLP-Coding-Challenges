package BakeSale

fun checkout(veganCakes: Int, nonVeganCakes: Int): Double {

    val remainderOf15 = nonVeganCakes % 15
    val groupsOf15 = nonVeganCakes / 15
    val remainderOf5 = remainderOf15 % 5
    val groupsOf5 = remainderOf15 / 5
    var remainderOf3 = remainderOf5 % 3
    val groupsOf3 = remainderOf5 / 3

    val remainderOfVegan15 = veganCakes % 15
    val groupsOfVegan15 = veganCakes / 15
    val remainderOfVegan5 = remainderOfVegan15 % 5
    val groupsOfVegan5 = remainderOfVegan15 / 5
    var remainderOfVegan3 = remainderOfVegan5 % 3
    val groupsOfVegan3 = remainderOfVegan5 / 3

    val mixedGroupsOf3 = (remainderOf3 + remainderOfVegan3) / 3

    if (mixedGroupsOf3 > 0) {
        remainderOfVegan3 = (remainderOf3 + remainderOfVegan3) % 3
        remainderOf3 = 0
    }

    return (groupsOf15 * 5) + (groupsOf5 * 3) + (groupsOf3 * 2) +
            (groupsOfVegan15 * 6) + (groupsOfVegan5 * 4) + (groupsOfVegan3 * 3) +
            (mixedGroupsOf3 * 2.4) +
            remainderOf3 + (remainderOfVegan3 * 1.5)

}