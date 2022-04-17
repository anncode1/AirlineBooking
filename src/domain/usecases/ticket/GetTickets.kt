package domain.usecases.ticket

import domain.datasource.ticket.TicketsDataSource
import domain.model.Ticket

class GetTickets(
    private val ticketsDataSource: TicketsDataSource
) {
    operator fun invoke(): List<Ticket> {
        return ticketsDataSource.tickets
    }
}