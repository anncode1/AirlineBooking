package domain.usecases.reservation

import domain.datasource.reservartion.ReservationDataSource
import domain.model.Reservation
import domain.model.Ticket

private const val CODE_SIZE = 5
class AssignTicketToReservation(
    private val reservationDataSource: ReservationDataSource
) {

    operator fun invoke(ticket: Ticket): Reservation {
        return reservationDataSource.reservation.apply {
            this.code = generateCode()
            this.departureTickets.add(ticket)
            this.returnTickets.add(ticket)
        }
    }

    private fun generateCode() : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..CODE_SIZE)
            .map { allowedChars.random() }
            .joinToString("")
    }
}