package domain.model

import java.math.BigDecimal

class Reservation {
    lateinit var code: String
    var departureTickets: List<Ticket> = mutableListOf()
    var returnTickets: List<Ticket> = mutableListOf()
    val total: BigDecimal
        get() {
            return departureTickets.sumOf {
                it.totalPrice
            }.plus(
                returnTickets.sumOf {
                    it.totalPrice
                }
            )
        }
}
