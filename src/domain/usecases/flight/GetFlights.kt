package domain.usecases.flight

import domain.model.*
import domain.model.seat.Seat
import domain.model.seat.SeatClass
import domain.model.seat.SeatSection
import domain.model.seat.SeatStatus
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month
/**
 * 1. Mostrar los vuelos disponibles de un mes
 * */
class GetFlights() {

    operator fun invoke(month: Month): Map<Int, Flight> {
        val flight = getFlight()

        val flightsMap = mapOf(
            1 to flight,
            2 to flight,
            3 to flight,
        )

        flightsMap.filter { flightEntry ->
            flightEntry.value.departureArrivalBooking.first.dateTime.month == month
        }

        return flightsMap

    }

    private fun getFlight() = Flight(
        number = "Y4 708",
        airCraft = AirCraft("Airbus", "A320", getSeatSections()),
        price = BigDecimal(100.0),
        departureArrivalBooking = getAirportPair()
    )
}

fun getSeatSections(): List<SeatSection> {
    return listOf(
        SeatSection(
            seatClass = SeatClass.BUSINESS,
            seats = arrayOf(
                Seat("1", BigDecimal(30), SeatStatus.AVAILABLE),
                Seat("2", BigDecimal(30), SeatStatus.AVAILABLE),
                Seat("3", BigDecimal(30), SeatStatus.AVAILABLE),
            ),
            BigDecimal(30)
        ),
        SeatSection(
            seatClass = SeatClass.PLUS,
            seats = arrayOf(
                Seat("4", BigDecimal(20)),
                Seat("5", BigDecimal(20)),
                Seat("6", BigDecimal(20)),
            ),
            BigDecimal(20)
        ),
        SeatSection(
            seatClass = SeatClass.ECONOMY,
            seats = arrayOf(
                Seat("7", BigDecimal(10)),
                Seat("8", BigDecimal(10)),
                Seat("9", BigDecimal(10)),
            ),
            BigDecimal(10)
        )
    )
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