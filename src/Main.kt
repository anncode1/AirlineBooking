
import domain.model.Flight
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.GetFlights
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.ticket.AssignFlightToTicket
import domain.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.flight.FlightPresentationFactory
import presentation.menu.UIMenu
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightsPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val ticketData = TicketDataDI().providesTicketData()

    /** 1. Showing Flight List */
    val uiMenuFlight = object : UIMenu<Flight> {}
    val flightData = FlightDataDI().providesFlights()
    val flightsMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(
        flightsMap, flightsPresentation
    )

    /** 2. Saving Flight in Ticket */
    AssignFlightToTicket(ticketData).invoke(flightSelected)

    val flightSaved = GetFlightSaved(ticketData).invoke()

    println("Flight Saved")
    println(
        flightsPresentation.format(flightSaved)
    )

}
