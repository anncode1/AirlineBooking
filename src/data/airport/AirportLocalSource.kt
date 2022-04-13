package data.airport

import domain.datasource.airport.AirportDataSource
import domain.model.Airport

// 1
class AirportLocalSource : AirportDataSource {
    override fun getAirports(): List<Airport> = listOf(
        Airport("QMX", "Mexico City"),
        Airport("CHI", "Chicago"),
        Airport("BOG", "Bogotá"),
        Airport("CUN", "Cancún"),
    )
}