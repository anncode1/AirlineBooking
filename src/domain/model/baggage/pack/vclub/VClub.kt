package domain.model.baggage.pack.vclub

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.BoardingTurn
import domain.model.baggage.type.BaggageType
import domain.model.baggage.type.BoxPacked
import java.math.BigDecimal
// 6 Mostrar
const val DISCOUNT = 30
abstract class VClub(
    price: BigDecimal
) : BaggagePackage() {

    override var price: BigDecimal = price
        get() {
            return (field * BigDecimal(DISCOUNT)) / BigDecimal(100)
        }

    abstract override val name: String
    abstract override val boardingTurn: BoardingTurn

    override val baggageTypes: List<BaggageType>
        get() = super.baggageTypes + listOf(
            BoxPacked()
        )

}