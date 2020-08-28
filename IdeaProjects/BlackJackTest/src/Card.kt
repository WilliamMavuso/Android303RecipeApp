data class Card (val rank: Int, val suite: Int  ) {
    override fun toString(): String {
        val rankName = when(rank){
            1 -> "Ace"
            11 -> "Jack"
            12 -> "Queen"
            13 -> "King"
            else -> rank.toString()
        }

        val suitName = when(suite){
            1 -> "Hearts"
            2 -> "Diamonds"
            3 -> "Spades"
            4 -> "Clubs"
            else -> ""
        }

        return  "$rankName of $suitName"
    }
}