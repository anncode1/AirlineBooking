package presentation

import domain.model.Ticket
import domain.utils.Formatter

class TicketConsoleFormat : Formatter<Ticket> {
    override fun format(t: Ticket): String {
        return """
            Passenger: ${t.passenger.name}
            Flight Number: ${t.flight.number}
            Departure: ${t.flight.departureArrivalBooking.first.airport.name}
            Arrival: ${t.flight.departureArrivalBooking.second.airport.name}
            Flight Price $${t.flight.price}
            BaggagePlan: $//{baggage.format()}
            Seat: ${t.seat.number}
            Total: $${t.totalPrice}
        """.trimIndent()
    }
}