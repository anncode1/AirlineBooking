package presentation.reservation.format

import domain.model.Reservation
import domain.model.Ticket
import presentation.utils.Formatter

class ReservationConsoleFormat(
    private val ticketPresentation: Formatter<Ticket>
) : Formatter<Reservation> {
    override fun format(t: Reservation): String {
        return """
Reservation Code: ${t.code}

Departure Tickets ${t.departureTickets.size}
${ticketPresentation.format(t.departureTickets)}
                
Return Tickets ${t.returnTickets.size}
${ticketPresentation.format(t.departureTickets)}
                            
GRAN TOTAL: $${t.total}
        """.trimIndent()
    }

}

