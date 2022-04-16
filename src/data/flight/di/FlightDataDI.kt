package data.flight.di

import data.airbooking.AirBookingLocalSource
import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.flight.FlightLocalSource
import domain.datasource.flight.FlightDataSource

class FlightDataDI {

    fun providesFlights(): FlightDataSource {
        val airportData = AirportLocalSource()
        val airBookingData = AirBookingLocalSource(airportData)
        val airCraftData = AirCraftLocalSource()
        return FlightLocalSource(
            airCraftData, airBookingData
        )
    }
}