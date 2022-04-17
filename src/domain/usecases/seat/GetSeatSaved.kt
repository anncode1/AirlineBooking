package domain.usecases.seat

import domain.datasource.ticket.TicketDataSource
import domain.model.seat.Seat

class GetSeatSaved(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(): Seat {
        return ticketDataSource.ticket.seat
    }
}