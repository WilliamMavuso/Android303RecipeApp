class Deck {

    // creates an array of cards from the Card class (which has the rank and suit property)
    val cards = mutableListOf<Card>()

    // This is the 'main' class method which will be executed first when this Deck class is instantiated.
    // This method only/strictly operates on the data/attributes of the class (or a class) before any other function can
    // perform any action on them.

    init {
        // this is a for-loop which essentially declares an iterative variable, and uses it to loop through
        // our array to determine the range of elements within that array that it needs to loop through,
        // and then once its done iterating, it should add (push) each value of the objects' properties onto the array as a list.
        for (rank in 1..13){
            for (suit in 1..4){
                cards.add(Card(rank, suit))
            }
        }
    }

    fun show(){

        // Loop through the cards array and convert the values to a string output.
        for(card in cards){
            println(card.toString())
        }
    }

    fun shuffle(){
        cards.shuffle()
    }
}