package domain.datasource.airport

import domain.model.Airport

// 1.
interface AirportDataSource {
    fun getAirports(): List<Airport>
}