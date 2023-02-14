package classes

import interfaces.UserListener
import models.User

class UserController(val listener: UserListener) {
    private val repository = UserRepository()

    fun add(user: User) {
        val isOk = repository.addUser(user)

        val action = if(isOk) {
            UserResponseActions.SendMessage("Se ha agregado correctamente el usuario")
        } else {
            UserResponseActions.SendMessage("No se ha podido agregar el usuario el usuario")
        }

        listener.returnAction(action)
    }

    fun remove(user: User) {
        val isOk = repository.removeUser(user)
        val action = if(isOk) {
            UserResponseActions.SendMessage("Se ha eliminado correctamente el usuario")
        } else {
            UserResponseActions.SendMessage("No se ha podido eliminar el usuario")
        }

        listener.returnAction(action)
    }

    fun getUserById(id: Int) {
        val user = repository.getUserById(id)

        val action = if(user == null) {
            UserResponseActions.SendMessage("El usuario con el id: $id no existe")
        } else{
            UserResponseActions.UserResponse("Si existe el usuario", user)
        }

        listener.returnAction(action)
    }

    fun getAllUser() {
        val action = UserResponseActions.UserList(repository.getAllUsers())
        listener.returnAction(action)
    }
}