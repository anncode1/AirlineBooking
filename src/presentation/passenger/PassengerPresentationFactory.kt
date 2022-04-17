package presentation.passenger

import domain.model.Passenger
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.utils.Formatter

class PassengerPresentationFactory : PresentationFactory<Passenger> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Passenger> {
        return PassengerConsoleFormat()
    }

}
