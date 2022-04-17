package domain.usecases.ticket

import domain.datasource.ticket.TicketDataSource
import domain.model.Ticket
import domain.model.seat.Seat

/**
 * 6. Seleccionar un asiento
 * */
class AssignSeatToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(seat: Seat?): Ticket? {
        return seat?.let {
            ticketDataSource.ticket.apply {
                this.seat = it
            }
        }
    }
}