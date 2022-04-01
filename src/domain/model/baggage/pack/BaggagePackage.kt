package domain.model.baggage.pack

import domain.model.baggage.type.BaggageType
import domain.model.baggage.type.BigHand
import domain.model.baggage.type.Checked
import domain.model.baggage.type.Hand
import java.math.BigDecimal

// no puede ser open y abstract
// o es obligatorio de implementar - abstract
// o es opcional - open
abstract class BaggagePackage {

    abstract val name: String
    abstract val price: BigDecimal
    abstract val boardingTurn: BoardingTurn

    open val baggageTypes: List<BaggageType> = listOf(
        Hand(),
        BigHand(),
        Checked()
    )

}