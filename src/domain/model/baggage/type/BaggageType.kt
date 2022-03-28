package domain.model.baggage.type

// 1. Es muy complejo para ser un Enum, tiene mucha lógica
// como para poner all there
// 2. Hacemos herencia en lugar de crear multiples objetos con datos
// porque lalógica quedaría por fuera, aplicamos tell don't ask
// que cada método con ayuda del polimorfismo dé su propio comportamiento

// no puede ser Data class
open class BaggageType {
    open val emoji: String = "🎒"
    open val quantity: Int = 1
    open val title: String = ""
    open val description: String = ""
}