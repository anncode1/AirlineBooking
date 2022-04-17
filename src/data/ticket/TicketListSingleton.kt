package data.ticket

import domain.datasource.ticket.TicketsDataSource
import domain.model.Ticket

class TicketListSingleton : TicketsDataSource {

    companion object {
        private val tickets = mutableListOf(
            Ticket()
        )
    }

    override val tickets: MutableList<Ticket> = TicketListSingleton.tickets
}