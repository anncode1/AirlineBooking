
import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import domain.model.Flight
import domain.model.baggage.pack.BaggagePackage
import domain.usecases.baggage.GetBaggagePackages
import domain.usecases.baggage.GetBaggageSaved
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.GetFlights
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.ticket.AssignBaggagePackageToTicket
import domain.usecases.ticket.AssignFlightToTicket
import domain.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.baggage.BaggagePackPresentationFactory
import presentation.baggage.BaggagePackageEnum
import presentation.flight.FlightPresentationFactory
import presentation.menu.UIMenu
import presentation.utils.Formatter
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val ticketData = TicketDataDI().providesTicketData()
    val flightsPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val baggagePackPresentation = BaggagePackPresentationFactory().getPresentationFormat(format)

    /** 1. Showing Flight List */
    val uiMenuFlight = object : UIMenu<Flight> {}
    val flightData = FlightDataDI().providesFlights()
    val flightsMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(
        flightsMap, flightsPresentation
    )

    /** 2. Saving Flight in Ticket */
    AssignFlightToTicket(
        TicketDataDI().providesTicket()
    ).invoke(flightSelected)

    val flightSaved = GetFlightSaved(ticketData).invoke()

    println("Flight Saved")
    println(
        flightsPresentation.format(flightSaved)
    )

    /** 3. Showing Baggage Packages */

    /*val baggageRegularPackData = BaggageRegularLocalSource()
    val baggageRegularMap = GetBaggagePackages(baggageRegularPackData).invoke()
    val baggageVClubPackData = BaggageVClubLocalSource()
    val baggageVClubMap = GetBaggagePackages(baggageVClubPackData).invoke()*/

    val baggagePackOptions = mapOf(
        1 to BaggagePackageEnum.Regular,
        2 to BaggagePackageEnum.VClub
    )

    val uiMenuBaggagePackOpt = object : UIMenu<BaggagePackageEnum> { }
    val baggagePackageOption = uiMenuBaggagePackOpt.showMenu(baggagePackOptions, object : Formatter<BaggagePackageEnum> {
        override fun format(t: BaggagePackageEnum): String {
            return t.name
        }
    })

    val baggagePackData = when (baggagePackageOption) {
        BaggagePackageEnum.Regular -> BaggageRegularLocalSource()
        BaggagePackageEnum.VClub -> BaggageVClubLocalSource()
        else -> BaggageRegularLocalSource()
    }

    val baggagePacksMap = GetBaggagePackages(baggagePackData).invoke()
    val uiMenuBaggagePack = object : UIMenu<BaggagePackage> { }
    val baggagePackageSelected = uiMenuBaggagePack.showMenu(
        baggagePacksMap, baggagePackPresentation
    )


    /** 4. Saving Baggage in Ticket */
    AssignBaggagePackageToTicket(ticketData).invoke(baggagePackageSelected)

    val baggageSaved = GetBaggageSaved(ticketData).invoke()

    println("Baggage Package Saved")
    println(
        baggagePackPresentation.format(baggageSaved)
    )


}
