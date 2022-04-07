package domain.model

data class AirCraft(
    val name: String,
    val model: String,
    val airline: Airline = Airline("VL", "Volaris")
)
