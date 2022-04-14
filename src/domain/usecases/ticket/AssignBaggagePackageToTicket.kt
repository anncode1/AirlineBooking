package domain.usecases.ticket

import domain.datasource.ticket.TicketDataSource
import domain.model.Ticket
import domain.model.baggage.pack.BaggagePackage

/**
 * 4. Seleccionar un equipaje
 * */
class AssignBaggagePackageToTicket(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(baggagePackage: BaggagePackage): Ticket {
        return ticketDataSource.ticket.apply {
            this.baggagePackage = baggagePackage
        }
    }
}