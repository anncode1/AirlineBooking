package domain.model

import java.time.LocalDateTime

data class AirportBooking(
    val airport: Airport,
    val dateTime: LocalDateTime
)
