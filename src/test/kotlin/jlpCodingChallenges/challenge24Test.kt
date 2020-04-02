package jlpCodingChallenges

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GameTest {
    @Test
    fun `should return single player winning by highest value rule`() {
        val tableCards = listOf(
            Card(7,'H'),
            Card(8,'C'),
            Card(6,'S'),
            Card(4,'D'),
            Card(10,'H')
        )
        val player1 = Player("Bob", listOf(Card(14,'D'),Card(3,'H')), 24.0)
        val player2 = Player("Angela", listOf(Card(5,'H'),Card(3,'C')), 24.0)
        val thisGame = Game(tableCards, listOf(player1, player2))
        val winner = "Bob"
        assertThat(thisGame.findWinners()).isEqualTo(winner)
    }
}