package presentation.extfunction

fun String.isNotBlankOrEmpty(): Boolean {
    return this.isNotBlank() || this.isNotEmpty()
}

fun <T> String.isMenuOptionValid(objectsMap: Map<Int, T>): Boolean {
    return if (isNotBlankOrEmpty()) {
        val isValidOption = isNumberValid() && objectsMap.containsKey(this.toInt())
        return isValidOption
    } else false
}

fun String.isNumberValid(): Boolean {
    return if (isNotBlankOrEmpty()) {
        this.all { it.isDigit() }
    } else false
}