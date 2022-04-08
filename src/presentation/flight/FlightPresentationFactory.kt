package presentation.flight

import domain.model.Flight
import domain.utils.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.flight.formats.FlightConsoleFormat
import presentation.flight.formats.FlightHTMLFormat

class FlightPresentationFactory : PresentationFactory<Flight> {

    override fun getPresentationFormat(format: PresentationFormat): Formatter<Flight> {
        return when(format) {
            PresentationFormat.CONSOLE -> FlightConsoleFormat()
            PresentationFormat.HTML -> FlightHTMLFormat()
            else -> FlightConsoleFormat()
        }
    }
}