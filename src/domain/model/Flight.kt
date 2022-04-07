package domain.model

import java.math.BigDecimal
import java.time.Duration
import java.time.format.DateTimeFormatter

class Flight(
    val number: String,
    val airCraft: AirCraft,
    val price: BigDecimal,
    val departureArrivalBooking: Pair<AirportBooking, AirportBooking>,
    val duration: Duration = Duration.between(
        departureArrivalBooking.second.dateTime,
        departureArrivalBooking.first.dateTime
    )
) : Formatter {
    override fun format(): String {
        val departure = departureArrivalBooking.first
        val arrival = departureArrivalBooking.second
        return """
            $number
            Origin: ${departure.airport.name}
            Destination: ${arrival.airport.name}
            Departure: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Arrival Date: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Duration: $duration
            Price: $${price}
            
        """.trimIndent()
    }
}
