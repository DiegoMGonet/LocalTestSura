package classes

import models.User

sealed class UserResponseActions {
    data class SendMessage(val message: String): UserResponseActions()
    data class UserResponse(val message: String, val user: User): UserResponseActions()
    data class UserList(val users: List<User>): UserResponseActions()
    object UnknownError: UserResponseActions()
}
