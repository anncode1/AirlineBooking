package data.ticket

import domain.datasource.ticket.TicketDataSource
import domain.model.Ticket

class TicketSingleton : TicketDataSource {

    companion object {
        private val ticket = Ticket()
    }

    override val ticket: Ticket = TicketSingleton.ticket
}