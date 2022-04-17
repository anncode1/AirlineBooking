package presentation.passenger

import domain.model.Passenger
import presentation.utils.Formatter

class PassengerConsoleFormat : Formatter<Passenger> {
    override fun format(t: Passenger): String {
        return """
            Name: ${t.name}
            Email: ${t.email}
            Phone: ${t.phone}
        """.trimIndent()
    }

}
