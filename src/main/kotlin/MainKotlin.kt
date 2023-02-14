import classes.TypeResponse
import classes.UserController
import classes.UserResponseActions
import interfaces.UserListener
import models.User

fun main(){

    val controller = UserController(object : UserListener{
        override fun returnAction(action: UserResponseActions) {
            validateResponse(action)
        }
    })

    val user1 = User(1, "Jose", 25, 2000.0)
    val user2 = User(2, "Ana", 32, 2000.0)
    val user3 = User(3, "Pedro", 31, 3000.0)
    val user4 = User(4, "Alejandro", 25, 2000.0)
    val user5 = User(5, "Luis", 32, 2000.0)
    val user6 = User(6, "Karen", 20, 3000.0)

    controller.add(user1)
    controller.add(user2)
    controller.add(user3)
    controller.remove(user3)
    controller.getUserById(2)
    controller.getAllUser()
}

fun validateResponse(action: UserResponseActions) {
    when(action) {
        is UserResponseActions.SendMessage -> {
            val message = action.message
            println(message)
        }
        is UserResponseActions.UserResponse -> {
            val user = action.user
            val message = action.message

            println("$message $user")
        }
        is UserResponseActions.UserList -> {
            action.users.forEach {
                println("Usuario: $it")
            }
        }
        UserResponseActions.UnknownError -> {
            println("Ocurrio un error desconocido")
        }
    }
}