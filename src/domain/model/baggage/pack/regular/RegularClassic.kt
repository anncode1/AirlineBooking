package domain.model.baggage.pack.regular

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class RegularClassic(price: BigDecimal) : Regular(price) {
    override val name: String = "Classic"
    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND
}