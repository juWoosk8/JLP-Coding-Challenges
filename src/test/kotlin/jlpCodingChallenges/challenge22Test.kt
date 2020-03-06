package jlpCodingChallenges


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class describeLaptopTest {
    val processorUpgrade = Upgrade("Processer", "super fast", 10.00)
    val memoryUpgrade = Upgrade("Memory", "16GB", 49.99)
    val hardDriveUpgrade = Upgrade("Hard drive", "4TB", 8.00)
    val graphicsUpgrade = Upgrade("Graphic card", "Gaming", 200.00)
    val batteryUpgrade = Upgrade("Battery", "Lasts more than 20 mins", 50.00)
    val caseUpgrade = Upgrade("Case", "Shiny", 3.00)

    @Test

    fun `should return Dell costs 49999`() {
        val laptop = LaptopImpl(499.99, "Dell")
        assertThat(laptop.description()).isEqualTo(
            ("Dell costs £499.99")
        )
        assertThat(laptop.price).isEqualTo(499.99)
    }

    @Test
    fun `Dell costs 49999 + Memory 16GB 4999`() {
        val laptop = LaptopUpgrade(LaptopImpl(499.99, "Dell"), listOf(memoryUpgrade))
        assertThat(laptop.description()).isEqualTo(
            ("Dell costs £499.99 + Memory 16GB £49.99")
        )
        assertThat(laptop.price).isEqualTo(549.98)
    }

    @Test
    fun `Dell costs 49999 + Memory 16GB 4999 + Case Shiny 300`() {
        val laptop = LaptopUpgrade(LaptopImpl(499.99, "Dell"), listOf(memoryUpgrade, caseUpgrade))
        assertThat(laptop.description()).isEqualTo(
            ("Dell costs £499.99 + Memory 16GB £49.99 + Case Shiny £3.00")
        )
        assertThat(laptop.price).isEqualTo(552.98)
    }

    @Test
    fun `Dell with all the bells and whistles`() {
        val laptop = LaptopUpgrade(LaptopImpl(499.99, "Dell"), listOf(processorUpgrade, memoryUpgrade, hardDriveUpgrade, graphicsUpgrade, batteryUpgrade, caseUpgrade))
        assertThat(laptop.description()).isEqualTo(
            ("Dell costs £499.99 + Processer super fast £10.00 + Memory 16GB £49.99 + Hard drive 4TB £8.00 + Graphic card Gaming £200.00 + Battery Lasts more than 20 mins £50.00 + Case Shiny £3.00")
        )
        assertThat(laptop.price).isEqualTo(820.98)
    }
}