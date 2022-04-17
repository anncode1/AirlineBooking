
import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import domain.model.Flight
import domain.model.baggage.pack.BaggagePackage
import domain.model.seat.Seat
import domain.model.seat.SeatSection
import domain.usecases.baggage.GetBaggagePackages
import domain.usecases.baggage.GetBaggageSaved
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.GetFlights
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.seat.GetSeatSaved
import domain.usecases.seat.GetSeatsBy
import domain.usecases.seat.GetSeatsSection
import domain.usecases.ticket.AssignBaggagePackageToTicket
import domain.usecases.ticket.AssignFlightToTicket
import domain.usecases.ticket.AssignSeatToTicket
import domain.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.baggage.BaggagePackPresentationFactory
import presentation.baggage.BaggagePackageEnum
import presentation.flight.FlightPresentationFactory
import presentation.menu.UIMenu
import presentation.seat.SeatPresentationFactory
import presentation.seat.section.SeatSectionPresentationFactory
import presentation.utils.Formatter
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightsPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val baggagePackPresentation = BaggagePackPresentationFactory().getPresentationFormat(format)
    val seatSectionPresentation = SeatSectionPresentationFactory().getPresentationFormat(format)
    val seatPresentation = SeatPresentationFactory().getPresentationFormat(format)

    /** 1. Showing Flight List */
    val flightData = FlightDataDI().providesFlights()
    val uiMenuFlight = object : UIMenu<Flight> {}
    val flightsMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(
            flightsMap, flightsPresentation
    )

    /** 2. Saving Flight in Ticket */
    AssignFlightToTicket(
        TicketDataDI().providesTicket()
    ).invoke(flightSelected)

    val getFlightSaved = GetFlightSaved(
        TicketDataDI().providesTicket()
    )
    val flightSaved = getFlightSaved.invoke()

    println("Flight Saved")
    println(
        flightsPresentation.format(flightSaved)
    )

    /** 3. Showing Baggage Packages */
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
    AssignBaggagePackageToTicket(
        TicketDataDI().providesTicket()
    ).invoke(baggagePackageSelected)

    val baggageSaved = GetBaggageSaved(
        TicketDataDI().providesTicket()
    ).invoke()

    println("Baggage Package Saved")
    println(
        baggagePackPresentation.format(baggageSaved)
    )

    /** 5. Showing available seats */
    val seatSectionMap = GetSeatsSection(
        getFlightSaved
    ).invoke()

    val uiSeatsSectionsMenu = object : UIMenu<SeatSection> { }
    val seatSectionSelected = uiSeatsSectionsMenu.showMenu(
        seatSectionMap, seatSectionPresentation
    )

    val seatsMap = GetSeatsBy().invoke(seatSectionSelected)
    val uiSeatsMenu = object : UIMenu<Seat> { }
    val seatSelected = uiSeatsMenu.showMenu(seatsMap, seatPresentation)

    /** 6. Save Seat Selected */
    AssignSeatToTicket(
        TicketDataDI().providesTicket()
    ).invoke(seatSelected)

    val seatSaved = GetSeatSaved(
        TicketDataDI().providesTicket()
    ).invoke()

    println("Seat Saved")
    println(
        seatPresentation.format(seatSaved)
    )



}
