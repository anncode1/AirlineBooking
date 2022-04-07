import domain.model.*
import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.regular.RegularBasic
import domain.model.seat.Seat
import domain.model.seat.SeatStatus
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

fun main() {

    val flight = Flight(
        number = "Y4 708",
        airCraft = AirCraft("Airbus", "A320"),
        price = BigDecimal(100.0),
        departureArrivalBooking = getAirportPair()
    )
    val flightFormatted = flight.format()
    println(flightFormatted)

    val ticket = Ticket(
        flight = flight,
        passenger = Passenger(
            name = "Ann",
            email = "ann@a.com",
            phone = "55554444"
        ),
        baggage = RegularBasic(BigDecimal(50)),
        Seat("2", BigDecimal(15), SeatStatus.RESERVED)
    )

    val ticketFormatted = ticket.format()
    println(ticketFormatted)

    /*val flights = listOf(
        flight,
        flight,
        flight
    )

    flightPrinter.print(flights)*/
}

fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
    return Pair(
        AirportBooking(
            airport = Airport("BOG", "Bogotá"),
            dateTime = LocalDateTime.of(
                2023, Month.JANUARY, 10, 13, 0, 0
            )
        ),
        AirportBooking(
            airport = Airport("CUN", "Cancún"),
            dateTime = LocalDateTime.of(
                2023, Month.JANUARY, 10, 17, 30, 0
            )
        )
    )
}