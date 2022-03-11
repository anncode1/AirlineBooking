package domain.model

data class Ticket(
    val flight: Flight,
    val passenger: Passenger,
    val baggage: Baggage,
    val seat: Seat
)
