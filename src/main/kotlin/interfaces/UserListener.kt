package interfaces

import classes.UserResponseActions

interface UserListener {
    fun returnAction(action: UserResponseActions)
}