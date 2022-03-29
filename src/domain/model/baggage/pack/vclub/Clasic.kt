package domain.model.baggage.pack.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Clasic(
    price: BigDecimal,
    name: String = "Clasic VClub"
) : VClub(name, price) {

    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND
}