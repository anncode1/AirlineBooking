package domain.model.baggage.pack.regular

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

abstract class Regular(
    override var price: BigDecimal
) : BaggagePackage() {
    abstract override val name: String
    abstract override val boardingTurn: BoardingTurn
}