package data.flight

import domain.datasource.aircraft.AirCraftDataSource
import domain.datasource.airportbooking.AirportBookingDataSource
import domain.datasource.flight.FlightDataSource
import domain.model.Flight
import java.math.BigDecimal

// 4
class FlightLocalSource(
    private val airCraftDataSource: AirCraftDataSource,
    private val airportBookingDataSource: AirportBookingDataSource
) : FlightDataSource {
    override fun getFlights(): Map<Int, Flight> = mapOf(
        1 to Flight(
            number = "Y4 708",
            airCraft = airCraftDataSource.getAirCrafts().random(),
            price = BigDecimal(100.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random(),
        ),
        2 to Flight(
            number = "Y4 905",
            airCraft = airCraftDataSource.getAirCrafts().random(),
            price = BigDecimal(130.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        3 to Flight(
            number = "Y4 748",
            airCraft = airCraftDataSource.getAirCrafts().random(),
            price = BigDecimal(110.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        4 to Flight(
            number = "Y4 819",
            airCraft = airCraftDataSource.getAirCrafts().random(),
            price = BigDecimal(100.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        5 to Flight(
            number = "Y4 5478",
            airCraft = airCraftDataSource.getAirCrafts().random(),
            price = BigDecimal(90.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        6 to Flight(
            number = "Y4 901",
            airCraft = airCraftDataSource.getAirCrafts().random(),
            price = BigDecimal(90.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        7 to Flight(
            number = "Y4 858",
            airCraft = airCraftDataSource.getAirCrafts().random(),
            price = BigDecimal(150.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        ),
        8 to Flight(
            number = "Y4 806",
            airCraft = airCraftDataSource.getAirCrafts().random(),
            price = BigDecimal(60.0),
            departureArrivalBooking = airportBookingDataSource.getAirBookingPairs().random()
        )
    )

}