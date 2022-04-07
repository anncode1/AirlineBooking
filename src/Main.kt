
import domain.usecases.GetFlights
import presentation.flight.FlightConsoleFormat
import presentation.flight.FlightHTMLFormat

fun main() {
    val getFlights = GetFlights(FlightConsoleFormat())
    val flightsFormat = getFlights.invoke()
    println(flightsFormat)

    val getHTMLFlights = GetFlights(FlightHTMLFormat())
    val flightsHTMLFormat = getHTMLFlights.invoke()
    println(flightsHTMLFormat)
}
