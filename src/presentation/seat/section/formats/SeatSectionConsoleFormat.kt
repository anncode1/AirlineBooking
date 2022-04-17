package presentation.seat.section.formats

import domain.model.seat.SeatSection
import presentation.utils.Formatter

class SeatSectionConsoleFormat : Formatter<SeatSection> {
    override fun format(t: SeatSection): String {
        return """
            Seat Class: ${t.seatClass.name}
            Price $${t.price}
            
        """.trimIndent()
//        Seat Range ${t.seats.first()} - ${t.seats.last()}
    }
}