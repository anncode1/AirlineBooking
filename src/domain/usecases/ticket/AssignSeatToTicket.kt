package domain.usecases.ticket

import domain.datasource.ticket.TicketsDataSource
import domain.model.Ticket
import domain.model.seat.Seat

/**
 * 6. Seleccionar un asiento
 * */
class AssignSeatToTicket(
    private val ticketsDataSource: TicketsDataSource
) {
    operator fun invoke(seat: Seat?): Ticket? {
        return seat?.let {
            ticketsDataSource.tickets.first().apply {
                this.seat = it
            }
        }
    }
}