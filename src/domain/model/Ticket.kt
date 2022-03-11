package domain.model

import domain.model.seat.Seat

data class Ticket(
    val flight: Flight,
    val passenger: Passenger,
    val baggage: Baggage,
    val seat: Seat
)
