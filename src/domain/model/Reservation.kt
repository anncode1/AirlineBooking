package domain.model

data class Reservation(
    val code: String,
    val departureTickets: List<Ticket>,
    val returnTickets: List<Ticket>
)
