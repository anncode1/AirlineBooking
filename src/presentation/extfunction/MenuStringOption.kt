package presentation.extfunction

fun String.isNotBlankOrEmpty(): Boolean {
    return this.isNotBlank() || this.isNotEmpty()
}

fun <T> String.isMenuOptionValid(objectsMap: Map<Int, T>): Boolean {
    return if (isNotBlankOrEmpty()) {
        val isValidOption = this.all { it.isDigit() } && objectsMap.containsKey(this.toInt())
        return isValidOption
    } else false
}