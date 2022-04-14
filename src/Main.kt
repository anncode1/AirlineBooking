
import data.airbooking.AirBookingLocalSource
import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import data.flight.FlightLocalSource
import data.ticket.TicketSingleton
import domain.datasource.baggage.BaggagePackageDataSource
import domain.usecases.baggage.GetBaggagePackages
import domain.usecases.flight.GetFlights
import domain.usecases.ticket.AssignFlightToTicket
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole
import presentation.flight.formats.FlightConsoleFormat
import java.math.BigDecimal
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

    // 7. Crear
    println()

    /*val basePrice = BigDecimal(50)
    val vClubLocalSource = BaggageVClubLocalSource()
    val regularLocalSource = BaggageRegularLocalSource()

    // 8 crear
    println("*** VClub Baggage's ***")
    printBaggagePacksConsole(regularLocalSource, basePrice)
    println()
    println("*** Regular Baggage's ***")
    printBaggagePacksConsole(vClubLocalSource, basePrice)*/

    println("*** Flight Selected ***")
    val ticketSingleton = TicketSingleton()
    val flight = getFlights[1]
    AssignFlightToTicket(ticketSingleton).invoke(flight)

    val flightSelected = ticketSingleton.ticket.flight
    println(
        FlightConsoleFormat().format(flightSelected)
    )
}

// 8 crear
fun printBaggagePacksConsole(
    baggageDataSource: BaggagePackageDataSource,
    basePrice: BigDecimal
) {
    val getBaggagePackages = GetBaggagePackages(baggageDataSource).invoke(basePrice)

    getBaggagePackages.forEach { (t, u) ->
        print("$t. ")
        println(BaggagePackageConsole(
            BaggageTypesConsole()
        ).format(u))
    }

}
