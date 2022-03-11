package domain.model

import java.math.BigDecimal
import java.time.Duration

data class Flight(
    val number: String,
    val airCraft: AirCraft,
    val price: BigDecimal,
    val duration: Duration,
    val departureArrivalBooking: Pair<AirportBooking, AirportBooking>
)
