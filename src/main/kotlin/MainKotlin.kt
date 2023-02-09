import classes.UserDelegate
import classes.greet
import classes.myUrl
import extensions.orEmpty
import extensions.orZero
import extensions.toCurrency
import models.User
import utils.sumTwoValues

fun main(){  //public static void man(String[] args)
    val delegate = UserDelegate()
    val user1 = User(1, "Jose", 25, 2000.0)
    val user2 = User(2, "Ana", 32, 2000.0)
    val user3 = User(3, "Pedro", 31, 3000.0)
    val user4 = User(4, "Alejandro", 25, 2000.0)
    val user5 = User(5, "Luis", 32, 2000.0)
    val user6 = User(6, "Karen", 20, 3000.0)

    delegate.addUser(user1)
    delegate.addUser(user2)
    delegate.addUser(user3)
    delegate.addUser(user4)
    delegate.addUser(user5)
    delegate.addUser(user6)

    val user = delegate.getUserById(5)
    val name = user?.name.orEmpty()
    val age = user?.age.orZero()
    val balance = user?.balance

    /*balance?.let {
        val myFormat = it.toCurrency()
        println("El saldo es: $myFormat")
    }*/

    val myFormat = balance.orZero
    println("El saldo es: $myFormat")

    println("El nombre del usuario es: $name")
    println("La edad del usuario es: $age")

    val list = delegate.getAllUsers()

    list.forEach {
        println("El usuario es: $it")
    }

    val listNames = list.map {
        it.name
    }

    listNames.forEach {
        println("El nombre es: $it")
    }

    //Tarea
    //val sumAllBalance = ?
}