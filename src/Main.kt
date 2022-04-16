
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.flight.GetFlights
import domain.usecases.ticket.AssignFlightToTicket
import domain.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.extfunction.isMenuOptionValid
import presentation.flight.FlightPresentationFactory
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE

    val getFlights = GetFlights(
        FlightDataDI().providesFlights()
    ).invoke(Month.JANUARY)
    val flightsPresentation = FlightPresentationFactory().getPresentationFormat(format)

    var flightOption = ""

    do {
        getFlights.forEach { (t, u) ->
            print("$t. ")
            println(flightsPresentation.format(u))
        }
        println("*** Select Number Option ***")
        flightOption = readLine().orEmpty()
//        val isValidOption = flightOption.all { it.isDigit() } && getFlights.containsKey(flightOption.toInt())
//    } while (flightOption.isBlank() || flightOption.isEmpty() || !isValidOption)
    } while (!flightOption.isMenuOptionValid(getFlights))

    println()
    println("Option Selected $flightOption")

    val flight = getFlights[flightOption.toInt()]
    AssignFlightToTicket(
        TicketDataDI().providesTicket()
    ).invoke(flight)

    val flightSaved = GetFlightSaved(
        TicketDataDI().providesTicket()
    ).invoke()

    println("Flight Saved")
    println(flightsPresentation.format(flightSaved))
}