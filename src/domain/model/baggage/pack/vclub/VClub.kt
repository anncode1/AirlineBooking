package domain.model.baggage.pack.vclub

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.type.BaggageType
import domain.model.baggage.type.BoxPacked
import java.math.BigDecimal

const val DISCOUNT = 30
open class VClub(
    override val name: String,
    final override var price: BigDecimal
) : BaggagePackage() {

    init {
        price = (price * BigDecimal(DISCOUNT)) / BigDecimal(100)
    }

    override val baggageTypes: List<BaggageType>
        get() = super.baggageTypes + listOf(
            BoxPacked()
        )

}