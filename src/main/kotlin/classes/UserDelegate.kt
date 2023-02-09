package classes

import models.User

const val myUrl = "www.site.com"

fun greet() {
    println("Hola a todos")
}

val className = "UserDelegate"

class UserDelegate(listInit: MutableList<User> = mutableListOf()) {

    private var list = mutableListOf<User>()

    fun setList(newList: List<User>){
        list.addAll(newList)
    }

    fun resetList(newList: MutableList<User>) {
        list = newList
    }

    fun addUser(user: User) {
        list.add(user)
    }

    fun removeUser(user: User) {
        list.remove(user)
    }

    fun getUserById(idUser: Int) =
        list.firstOrNull {
            it.id == idUser
        }


    fun getAllUsers() = list

    companion object {
        private const val myUrl2 = "www.site.com"
    }
}