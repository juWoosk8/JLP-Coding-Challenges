package BakeSale

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NonVeganBakeSaleTest {

    @Test

    fun `should return £1 for 1 cake`() {
        assertThat(checkout(0,1)).isEqualTo(1.0)
    }
    @Test
    fun `should return £2 for 2 cakes`() {
        assertThat(checkout(0,2)).isEqualTo(2.0)
    }
    @Test
    fun `should return £2 for 3 cakes`() {
        assertThat(checkout(0,3)).isEqualTo(2.0)
    }
    @Test
    fun `should return 3 for 2 offer prices`() {
        assertThat(checkout(0,4)).isEqualTo(3.0)
        assertThat(checkout(0,6)).isEqualTo(4.0)
        assertThat(checkout(0,7)).isEqualTo(5.0)
    }
    @Test
    fun `should return 3 for box of 5 cakes` () {
        assertThat(checkout(0,5)).isEqualTo(3.0)
        assertThat(checkout(0,10)).isEqualTo(6.0)
    }
    @Test
    fun `should return box offer plus trio offer plus 1 per cake for mixtures` () {
        assertThat(checkout(0,8)).isEqualTo(5.0)
        assertThat(checkout(0,11)).isEqualTo(7.0)
        assertThat(checkout(0,12)).isEqualTo(8.0)
        assertThat(checkout(0,13)).isEqualTo(8.0)
    }
    @Test
    fun `should return 5 per 3 boxes of 5 cakes` () {
        assertThat(checkout(0,15)).isEqualTo(5.0)
        assertThat(checkout(0,30)).isEqualTo(10.0)
    }
    @Test
    fun `should return trio box offer plus box offer plus trio offer plus 1 per cake for mixtures` () {
        assertThat(checkout(0,16)).isEqualTo(6.0)
        assertThat(checkout(0,21)).isEqualTo(9.0)
        assertThat(checkout(0,23)).isEqualTo(10.0)
        assertThat(checkout(0,24)).isEqualTo(11.0)
    }

}
internal class VeganBakeSaleTest {

    @Test

    fun `should return £1,50 for 1 vegan cake`() {
        assertThat(checkout(1,0)).isEqualTo(1.50)
    }
    @Test
    fun `should return £3 for 2 vegan cakes`() {
        assertThat(checkout(2,0)).isEqualTo(3.0)
    }
    @Test
    fun `should return £3 for 3 vegan cakes`() {
        assertThat(checkout(3,0)).isEqualTo(3.0)
    }
    @Test
    fun `should return 3 for 2 offer prices`() {
        assertThat(checkout(4,0)).isEqualTo(4.5)

    }
    @Test
    fun `should return 4,0 per box of 5 vegan cakes` () {
        assertThat(checkout(5,0)).isEqualTo(4.0)
        assertThat(checkout(10,0)).isEqualTo(8.0)
        assertThat(checkout(6,0)).isEqualTo(5.5)
        assertThat(checkout(7,0)).isEqualTo(7.0)
    }
    @Test
    fun `should return box offer plus trio offer plus 1 per cake for mixtures` () {
        assertThat(checkout(8,0)).isEqualTo(7.0)
        assertThat(checkout(11,0)).isEqualTo(9.5)
        assertThat(checkout(12,0)).isEqualTo(11.0)
        assertThat(checkout(13,0)).isEqualTo(11.0)
    }
    @Test
    fun `should return 5 per 3 boxes of 5 cakes` () {
        assertThat(checkout(15,0)).isEqualTo(6.0)
        assertThat(checkout(30,0)).isEqualTo(12.0)
    }
    @Test
    fun `should return trio box offer plus box offer plus trio offer plus 1 per vegan cake for mixtures` () {
        assertThat(checkout(16,0)).isEqualTo(7.5)
        assertThat(checkout(21,0)).isEqualTo(11.5)
        assertThat(checkout(23,0)).isEqualTo(13.0)
        assertThat(checkout(24,0)).isEqualTo(14.5)
    }

}
internal class MixBakeSaleTest {

    @Test

    fun `should return £2,50 for 1 non and 1 vegan cake`() {
        assertThat(checkout(1,1)).isEqualTo(2.50)
    }
    @Test

    fun `should return £2,40 for 2 non and 1 vegan cake`() {
        assertThat(checkout(1,2)).isEqualTo(2.40)
    }
    @Test

    fun `should return £2,40 for 1 non and 2 vegan cake`() {
        assertThat(checkout(2,1)).isEqualTo(2.40)
    }
    @Test
    fun `should return £3,9 for 2 non and 2 vegan cakes`() {
        assertThat(checkout(2,2)).isEqualTo(3.9)
    }
    @Test
    fun `should return £4,5 for 4 non and 1 vegan cakes`() {
        assertThat(checkout(1,4)).isEqualTo(4.5)
    }
    @Test
    fun `should return £5,5 for 1 non and 4 vegan cakes`() {
        assertThat(checkout(4,1)).isEqualTo(5.5)
    }
    @Test
    fun `should return £15,50 for 8 non and 19 vegan cakes`() {
        assertThat(checkout(19,8)).isEqualTo(15.5)
    }
}