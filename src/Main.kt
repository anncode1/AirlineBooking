
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.ticket.di.TicketDataDI
import domain.usecases.flight.GetFlights
import domain.usecases.ticket.AssignFlightToTicket
import presentation.PresentationFormat
import presentation.flight.FlightPresentationFactory
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    // 1. Crear las dependencias
    /*val airportData = AirportLocalSource()
    val airBookingData = AirBookingLocalSource(airportData)
    val airCraftData = AirCraftLocalSource()
    val flightData = FlightLocalSource(
        airCraftData, airBookingData
    )*/


    val getFlights = GetFlights(
        FlightDataDI().providesFlights()
    ).invoke(Month.JANUARY)
    val flightsPresentation = FlightPresentationFactory().getPresentationFormat(format)
    getFlights.forEach { (t, u) ->
        print("$t. ")
        println(flightsPresentation.format(u))
    }

    TicketDataDI()
    val flight = getFlights[1]
    AssignFlightToTicket(
        TicketDataDI().providesTicketsData()
    ).invoke(flight)

    val flightSaved = GetFlightSaved(
        TicketDataDI().providesTicketsData()
    ).invoke()

    println("Flight Saved")
    println(flightsPresentation.format(flightSaved))
}