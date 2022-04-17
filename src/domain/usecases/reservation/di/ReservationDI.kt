package domain.usecases.reservation.di

import data.reservation.ReservationSingleton
import domain.usecases.reservation.AssignTicketsToReservation
import domain.usecases.ticket.GetTickets
import domain.usecases.ticket.di.TicketDataDI

class ReservationDI {
    fun providesAssignTicketsToReservationUseCase(): AssignTicketsToReservation {
        return AssignTicketsToReservation(
            ReservationSingleton(),
            GetTickets(
                TicketDataDI().providesTicketData()
            )
        )
    }
}