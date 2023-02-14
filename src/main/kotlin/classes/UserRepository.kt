package classes

import models.User

class UserRepository(listInit: MutableList<User> = mutableListOf()) {

    private var list = listInit

    fun setList(newList: List<User>){
        list.addAll(newList)
    }

    fun resetList(newList: MutableList<User>) {
        list = newList
    }

    fun addUser(user: User) = list.add(user)
    fun removeUser(user: User) = list.remove(user)

    fun getUserById(idUser: Int) =
        list.firstOrNull {
            it.id == idUser
        }


    fun getAllUsers() = list
}