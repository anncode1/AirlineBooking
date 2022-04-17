package presentation.seat.section

import domain.model.seat.SeatSection
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.seat.section.formats.SeatSectionConsoleFormat
import presentation.utils.Formatter

class SeatSectionPresentationFactory : PresentationFactory<SeatSection> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<SeatSection> {
        return SeatSectionConsoleFormat()
    }
}