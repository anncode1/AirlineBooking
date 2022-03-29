package domain.model.baggage.pack

enum class BoardingTurn(val message: String) {
    FIRST("Aborda primero"),
    SECOND("Aborda segundo"),
    THIRD("Aborda tercero"),
    END("Aborda al final")
}