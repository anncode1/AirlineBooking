package presentation.ticket.formats

import domain.model.Ticket
import domain.model.baggage.pack.BaggagePackage
import presentation.utils.Formatter

class TicketConsoleFormat(
    private val baggagePackage: Formatter<BaggagePackage>
) : Formatter<Ticket> {
    override fun format(t: Ticket): String {
        return """
Passenger: ${t.passenger.name}
Flight Number: ${t.flight.number}
Departure: ${t.flight.departureArrivalBooking.first.airport.name}
Arrival: ${t.flight.departureArrivalBooking.second.airport.name}
Flight Price $${t.flight.price}
Seat: ${t.seat.number}
BaggagePlan: ${baggagePackage.format(t.baggagePackage)}
Total: $${t.totalPrice}

        """.trimIndent()
    }
}