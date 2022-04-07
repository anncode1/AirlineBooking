package presentation.flight

import domain.model.Flight
import domain.utils.Formatter
import java.time.format.DateTimeFormatter

class FlightConsoleFormat : Formatter<Flight> {

    override fun format(flight: Flight): String {
        val departure = flight.departureArrivalBooking.first
        val arrival = flight.departureArrivalBooking.second
        return """
            ${flight.number}
            Origin: ${departure.airport.name}
            Destination: ${arrival.airport.name}
            Departure: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Arrival Date: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Duration: ${flight.duration}
            Price: $${flight.price}
            
        """.trimIndent()
    }

}