package extensions

import java.text.DecimalFormat

fun String?.orEmpty() = this ?: ""
fun Int?.orZero() = this ?: 0

val Double?.orZero
    get() = this ?: 0

fun Double.toCurrency(): String {
    val format = DecimalFormat("$###,###,##0.00")
    return format.format(this)
}