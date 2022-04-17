package domain.usecases.seat

import domain.model.seat.Seat
import domain.model.seat.SeatSection
import domain.model.seat.SeatStatus

class GetSeatsBy {
    operator fun invoke(seatsSection: SeatSection?): Map<Int, Seat> {
        return seatsSection?.seats
            ?.filter {
                it.status == SeatStatus.AVAILABLE
            }
            ?.mapIndexed { index, seat ->
                index + 1 to seat
            }
            ?.toMap() ?: mapOf()
    }
}