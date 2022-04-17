package domain.usecases.baggage

import domain.datasource.ticket.TicketsDataSource
import domain.model.baggage.pack.BaggagePackage

class GetBaggageSaved(
    private val ticketsDataSource: TicketsDataSource
) {
    operator fun invoke(): BaggagePackage {
        return ticketsDataSource.tickets.first().baggagePackage
    }
}