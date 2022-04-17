package domain.usecases.flight

import domain.datasource.ticket.TicketsDataSource
import domain.model.Flight

/**
 * 5 Mostrar los asientos disponibles
 * */
class GetFlightSaved(
    private val ticketsDataSource: TicketsDataSource
) {
    operator fun invoke(): Flight {
        return ticketsDataSource.tickets.first().flight
    }
}