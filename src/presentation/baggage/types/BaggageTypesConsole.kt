package presentation.baggage.types

import domain.model.baggage.type.BaggageType
import presentation.utils.Formatter
// 4 Mostrar
class BaggageTypesConsole : Formatter<BaggageType> {
    override fun format(t: BaggageType): String {
        return """
            ${t.emoji} ${t.quantity} ${t.title}
        """.trimIndent()
    }
}