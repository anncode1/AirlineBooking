package domain.model.baggage.pack.regular

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal
// 5 Mostrar
class RegularPlus(price: BigDecimal) : Regular(price) {
    override val name: String = "Plus"
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST
    override var price: BigDecimal = price + BigDecimal(20)
}