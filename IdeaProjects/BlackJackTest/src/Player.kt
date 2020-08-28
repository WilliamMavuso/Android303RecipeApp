class Player (val name: String ){
    var hand = mutableListOf<Card>()
    var cash = 100000f
    var firstBet = 0f
    var totalBet = 0f

    fun addCardToHand(card: Card): List<Card>{
        hand.add(card)
        return hand
    }
}