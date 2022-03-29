package domain.model.baggage.pack.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Basic(
    price: BigDecimal,
    name: String = "Basic VClub"
) : VClub(name, price) {

    override val boardingTurn: BoardingTurn = BoardingTurn.THIRD

}
