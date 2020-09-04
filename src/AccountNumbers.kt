import Account as Account

class AccountNumbers(){
    var number:Int = 0
    var collect = mutableListOf<Int>()

    fun addtoCollection(number:Int){
        this.number = number
        val add = collect.add(number)
    }

    fun getCollection(){
        for (collect in collect){
            println(collect)
        }
    }

}


