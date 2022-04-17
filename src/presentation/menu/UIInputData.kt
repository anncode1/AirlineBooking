package presentation.menu

import presentation.extfunction.isNotBlankOrEmpty

interface UIInputData {
    fun requestField(fieldName: String): String {
        var field = ""
        do {
            println("Introduce your $fieldName")
            field = readLine().orEmpty()
        } while (!field.isNotBlankOrEmpty())
        return field
    }
}