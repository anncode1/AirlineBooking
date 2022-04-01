package domain.model.baggage.pack.regular

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class RegularPlus(price: BigDecimal) : Regular(price) {
    override val name: String = "Regular"
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST
}