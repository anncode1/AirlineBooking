package domain.model.baggage.pack.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal
// 6 Mostrar
class ClubBasic(price: BigDecimal) : VClub(price) {
    override val name: String = "Basic"
    override val boardingTurn: BoardingTurn = BoardingTurn.THIRD
    override var price: BigDecimal = price
        get() {
            return super.price
        }
}