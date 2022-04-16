package domain.usecases.flight

import domain.datasource.ticket.TicketDataSource
import domain.model.Flight

/**
 * 5 Mostrar los asientos disponibles
 * */
class GetFlightSaved(
    private val ticketDataSource: TicketDataSource
) {
    operator fun invoke(): Flight {
        return ticketDataSource.ticket.flight
    }
}