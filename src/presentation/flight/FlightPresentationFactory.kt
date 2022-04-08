package presentation.flight

import domain.model.Flight
import domain.utils.Formatter
import presentation.PresentationFormat
import presentation.flight.formats.FlightConsoleFormat
import presentation.flight.formats.FlightHTMLFormat

class FlightPresentationFactory {

    fun getPresentationFormat(format: PresentationFormat): Formatter<Flight> {
        return when(format) {
            PresentationFormat.CONSOLE -> FlightConsoleFormat()
            PresentationFormat.HTML -> FlightHTMLFormat()
            else -> FlightConsoleFormat()
        }
    }
}