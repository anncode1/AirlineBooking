package domain.model.baggage.pack.regular

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Clasic(
    price: BigDecimal,
    name: String = "Clasic"
) : Regular(name, price) {

    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND
}