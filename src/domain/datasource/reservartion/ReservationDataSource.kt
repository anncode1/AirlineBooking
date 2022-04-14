package domain.datasource.reservartion

import domain.model.Reservation

interface ReservationDataSource {
    val reservation: Reservation
}