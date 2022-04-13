package domain.usecases.flight

import domain.datasource.flight.FlightDataSource
import domain.model.Flight
import java.time.Month
/**
 * 1. Mostrar los vuelos disponibles de un mes
 * */
class GetFlights(
    private val flightDataSource: FlightDataSource
) {

    operator fun invoke(month: Month): Map<Int, Flight> {
        return flightDataSource
            .getFlights()
            .filter { flightEntry ->
                flightEntry.value.departureArrivalBooking.first.dateTime.month == month
            }
    }

}
