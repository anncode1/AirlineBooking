package domain.model.baggage.pack.regular

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Basic(
    price: BigDecimal,
    name: String = "Basic"
) : Regular(name, price) {

    override val boardingTurn: BoardingTurn = BoardingTurn.END

}
