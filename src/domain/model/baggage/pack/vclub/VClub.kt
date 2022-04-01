package domain.model.baggage.pack.vclub

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.BoardingTurn
import domain.model.baggage.type.BaggageType
import domain.model.baggage.type.BoxPacked
import java.math.BigDecimal

const val DISCOUNT = 30
abstract class VClub(
    final override var price: BigDecimal
) : BaggagePackage() {

    init {
        price = (price * BigDecimal(DISCOUNT)) / BigDecimal(100)
    }

    abstract override val name: String
    abstract override val boardingTurn: BoardingTurn

    override val baggageTypes: List<BaggageType>
        get() = super.baggageTypes + listOf(
            BoxPacked()
        )

}