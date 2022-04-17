package data.reservation

import domain.datasource.reservartion.ReservationDataSource
import domain.model.Reservation

class ReservationSingleton : ReservationDataSource {

    companion object {
        private val reservation = Reservation()
    }

    override val reservation: Reservation = ReservationSingleton.reservation
}