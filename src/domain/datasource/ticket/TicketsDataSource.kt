package domain.datasource.ticket

import domain.model.Ticket

interface TicketsDataSource {
    val tickets: List<Ticket>
}