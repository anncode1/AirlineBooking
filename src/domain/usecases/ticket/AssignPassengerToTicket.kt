package domain.usecases.ticket

import domain.datasource.ticket.TicketsDataSource
import domain.model.Passenger
import domain.model.Ticket

/**
 * 7. Introducir Información del Pasajero
 * */
class AssignPassengerToTicket(
    private val ticketsDataSource: TicketsDataSource
) {
    operator fun invoke(passenger: Passenger): Ticket {
        return ticketsDataSource.tickets.first().apply {
            this.passenger = passenger
        }
    }
}