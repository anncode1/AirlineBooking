package domain.datasource.airportbooking

import domain.model.AirportBooking

// 2
interface AirportBookingDataSource {
    fun getAirBookingPairs(): List<Pair<AirportBooking, AirportBooking>>
}