
import domain.model.Flight
import domain.usecases.GetFlights
import domain.utils.Formatter
import presentation.PresentationFormat
import presentation.flight.FlightPresentationFactory
import presentation.flight.formats.FlightConsoleFormat
import presentation.flight.formats.FlightHTMLFormat

fun main() {
    val getFlights = GetFlights(FlightConsoleFormat())
    val flightsFormat = getFlights.invoke()
//    println(flightsFormat)

    val getHTMLFlights = GetFlights(FlightHTMLFormat())
    val flightsHTMLFormat = getHTMLFlights.invoke()
//    println(flightsHTMLFormat)

    val presentationFormat = PresentationFormat.CONSOLE
    val flightFormat: Formatter<Flight> =
        FlightPresentationFactory().getPresentationFormat(presentationFormat)
    val flights = GetFlights(flightFormat).invoke()
    println(flights)
}
