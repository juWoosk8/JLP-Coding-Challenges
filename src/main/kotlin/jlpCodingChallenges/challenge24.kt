package jlpCodingChallenges

data class Card(
    val rank: Int,
    val suit: Char
)

data class Player(
    val name: String,
    val cards: List<Card>,
    val bet: Double
)

data class Hand(
    val rule: Int,
    val cards: List<Card>
)
interface IGame {
    val cards: List<Card>
    val players: List<Player>
    fun findWinners(): String
}

class Game(
    override val cards: List<Card>,
    override val players: List<Player>
) : IGame {

    override fun findWinners(): String {
        // for each player find highest winning hand
        var bestHands = mutableMapOf< String, Hand>()
        for (player in players) {
            val allCards = cards + player.cards
            bestHands.putIfAbsent(player.name, rule9(allCards))
        }
        return rule9Winners(bestHands).joinToString(", ")
    }
    fun rule9(allCards: List<Card>):Hand {
        return Hand( 9,allCards.sortedByDescending { card -> card.rank }.subList(0,5))
    }
    fun rule9Winners(playersHands: Map< String, Hand>): List<String>{
        // find highest 0th card
        var winningCards :List<Card> = listOf(
            Card(1,'H'),
            Card(1,'H'),
            Card(1,'H'),
            Card(1,'H'),
            Card(1,'H'))
        playersHands.forEach { player, hand ->
            if (hand.cards[0].rank> winningCards[0].rank) winningCards = hand.cards
        }
        return playersHands.filter { playerHand -> playerHand.value.cards == winningCards}.keys.toList()
    }


}