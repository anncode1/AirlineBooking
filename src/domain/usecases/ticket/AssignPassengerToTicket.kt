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
    operator fun invoke(passengers: List<Passenger>): List<Ticket> {
        val firstTicket = ticketsDataSource.tickets.first().apply {
            this.passenger = passengers.first()
        }

        val tickets = passengers.drop(1).map {
            val ticket = Ticket().apply {
                this.passenger = it
                this.flight = firstTicket.flight
                this.baggagePackage = firstTicket.baggagePackage
                this.seat = firstTicket.seat
                this.totalPrice = firstTicket.totalPrice
            }
            ticket
        }

        ticketsDataSource.tickets += tickets

        return ticketsDataSource.tickets
    }
}