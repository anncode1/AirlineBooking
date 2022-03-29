package domain.model.baggage.pack

import domain.model.baggage.type.BaggageType
import domain.model.baggage.type.BigHand
import domain.model.baggage.type.Checked
import domain.model.baggage.type.Hand
import java.math.BigDecimal

// no puede ser data class marca un error
open class BaggagePackage(
    open val name: String = "Baggage Plan",
    open var price: BigDecimal = BigDecimal(0.0)
) {

    open val boardingTurn: BoardingTurn = BoardingTurn.FIRST
    open val baggageTypes: List<BaggageType> = listOf(
        Hand(),
        BigHand(),
        Checked()
    )

}