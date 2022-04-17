package presentation.seat

import domain.model.seat.Seat
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.seat.formats.SeatConsoleFormat
import presentation.utils.Formatter

class SeatPresentationFactory : PresentationFactory<Seat> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Seat> {
        return SeatConsoleFormat()
    }

}
