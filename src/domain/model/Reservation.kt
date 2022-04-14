package domain.model

import java.math.BigDecimal

class Reservation {
    lateinit var code: String
    val departureTickets: MutableList<Ticket> = mutableListOf()
    val returnTickets: MutableList<Ticket> = mutableListOf()
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
