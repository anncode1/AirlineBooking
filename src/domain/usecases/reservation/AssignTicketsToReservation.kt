package domain.usecases.reservation

import domain.datasource.reservartion.ReservationDataSource
import domain.model.Reservation
import domain.usecases.ticket.GetTickets

private const val CODE_SIZE = 5
class AssignTicketsToReservation(
    private val reservationDataSource: ReservationDataSource,
    private val getTickets: GetTickets
) {

    operator fun invoke(): Reservation {
        return reservationDataSource.reservation.apply {
            this.code = generateCode()
            this.departureTickets = getTickets()
            this.returnTickets = getTickets()
        }
    }

    private fun generateCode() : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..CODE_SIZE)
            .map { allowedChars.random() }
            .joinToString("")
    }
}