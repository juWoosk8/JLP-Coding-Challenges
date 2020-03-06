package jlpCodingChallenges

import java.text.DecimalFormat

interface LaptopProducer {
    var price: Double
    val name: String
    fun description(): String
}

class LaptopImpl(override var price: Double, override val name: String) : LaptopProducer{
    override fun description(): String {
        return "$name costs £$price"
    }
}

class LaptopUpgrade(val delegate: LaptopProducer, upgrades: List<Upgrade>) : LaptopProducer by delegate {
   val upgrades = upgrades

    override fun description(): String {
        val df = DecimalFormat("#.00")
        var description = delegate.description()
        for (upgrade in upgrades) {
            delegate.price = delegate.price + upgrade.upgradePrice
            description = "$description + ${upgrade.upgradeName} ${upgrade.upgradeDescr} £${df.format(upgrade.upgradePrice)}"
        }
        return description
    }
}

data class Upgrade(
    val upgradeName: String,
    val upgradeDescr: String,
    val upgradePrice: Double
)
