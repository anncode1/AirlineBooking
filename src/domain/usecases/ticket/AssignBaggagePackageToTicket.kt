package domain.usecases.ticket

import domain.datasource.ticket.TicketsDataSource
import domain.model.Ticket
import domain.model.baggage.pack.BaggagePackage

/**
 * 4. Seleccionar un equipaje
 * */
class AssignBaggagePackageToTicket(
    private val ticketsDataSource: TicketsDataSource
) {
    operator fun invoke(baggagePackage: BaggagePackage?): Ticket? {
        return baggagePackage?.let {
            ticketsDataSource.tickets.first().apply {
                this.baggagePackage = it
            }
        }
    }
}