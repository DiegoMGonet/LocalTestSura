package classes

enum class TypeResponse(val message: String) {
    OK_RESPONSE("La acción se ha realizado correctamente"),
    ERROR_RESPONSE("Hubo un error al realizar la acción")
}