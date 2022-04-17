package domain.usecases.seat

import domain.datasource.ticket.TicketsDataSource
import domain.model.seat.Seat

class GetSeatSaved(
    private val ticketsDataSource: TicketsDataSource
) {
    operator fun invoke(): Seat {
        return ticketsDataSource.tickets.first().seat
    }
}