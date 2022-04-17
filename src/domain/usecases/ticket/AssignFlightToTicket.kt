package domain.usecases.ticket

import domain.datasource.ticket.TicketsDataSource
import domain.model.Flight
import domain.model.Ticket

/**
 * 2. Seleccionar un vuelo disponible
 * */
class AssignFlightToTicket(
    private val  ticketsDataSource: TicketsDataSource
) {
    operator fun invoke(flight: Flight?): Ticket? {
        return flight?.let {
            ticketsDataSource.tickets.first().apply {
                this.flight = flight
            }
        }
    }

}