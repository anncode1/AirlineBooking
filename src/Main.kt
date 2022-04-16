
import data.flight.di.FlightDataDI
import domain.usecases.flight.GetFlights
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


    val flightData = FlightDataDI().providesFlights()
    val getFlights = GetFlights(flightData).invoke(Month.JANUARY)
    val flightsPresentation = FlightPresentationFactory().getPresentationFormat(format)
    getFlights.forEach { (t, u) ->
        print("$t. ")
        println(flightsPresentation.format(u))
    }
}