package domain.model.baggage.pack.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal
// 6 Mostrar
class ClubPlus(price: BigDecimal) : VClub(price) {
    override val name: String = "Plus"
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST
    override var price: BigDecimal = price
        get() {
            return super.price + BigDecimal(20)
        }
}