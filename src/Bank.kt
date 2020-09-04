import AccountTypes.EasySavings as EasySavings

fun main(){
    var account = Account(10, 5000f).apply {
        deposit(500)
    }

    var account1 = Account(10, 5000f).apply {
        deposit(500)
    }
    var account2 = Account(10, 5000f).apply {
        deposit(500)
    }


    var easyAccount = EasySavings(1,500f)
        easyAccount.deposit(700)

    var accountNumber = account.accountID
//    var balance = account.getBalance()
//    account.deposit(1000)

//    println(accountNumber())

    var dope = AccountNumbers().addtoCollection(accountNumber())

    println(AccountNumbers().getCollection().toString())
//    println(account.id())
//    println(account.balance())
//
//    account.deposit(900)
//
//    println(account.balance())
//
//
//    account.deposit(900)
//
//    println(account.balance())
//
//
//    account.deposit(900)

//    println(easyAccount.balance())
}