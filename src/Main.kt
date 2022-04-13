
import data.airbooking.AirBookingLocalSource
import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.flight.FlightLocalSource
import domain.usecases.flight.GetFlights
import presentation.flight.formats.FlightConsoleFormat
import java.time.Month

fun main() {
    val airportDataSource = AirportLocalSource()
    val airportBookingLocalSource = AirBookingLocalSource(airportDataSource)
    val airCraftLocalSource = AirCraftLocalSource()

    // Empezar aquí y luego ir para atrás
    val flightLocal = FlightLocalSource(airCraftLocalSource, airportBookingLocalSource)
    val getFlights = GetFlights(flightLocal).invoke(Month.JANUARY)
    getFlights.forEach { (t, u) ->
        print("$t. ")
        println(FlightConsoleFormat().format(u))
    }

}
