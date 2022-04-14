package presentation.baggage

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.type.BaggageType
import presentation.utils.Formatter
import presentation.baggage.types.BaggageTypesConsole
// 4. Mostrar
class BaggagePackageConsole(
    private val baggageType: Formatter<BaggageType>
) : Formatter<BaggagePackage> {
    override fun format(t: BaggagePackage): String {
        return """
${t.name}
${baggageType.format(t.baggageTypes).trim()}
Boarding Turn: ${t.boardingTurn.name}
Price: $${t.price}

        """.trimIndent()
    }
}