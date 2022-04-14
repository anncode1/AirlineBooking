package domain.usecases.ticket

import domain.datasource.ticket.TicketDataSource
import domain.model.Flight
import domain.model.Ticket

/**
 * 2. Seleccionar un vuelo disponible
 * */
class AssignFlightToTicket(
    private val  ticketDataSource: TicketDataSource
) {
    operator fun invoke(flight: Flight?): Ticket? {
        return flight?.let {
            ticketDataSource.ticket.apply {
                this.flight = flight
            }
        }
    }

}