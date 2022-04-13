package domain.datasource.flight

import domain.model.Flight

// 4
interface FlightDataSource {
    fun getFlights(): Map<Int, Flight>
}