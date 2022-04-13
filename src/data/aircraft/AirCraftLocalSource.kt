package data.aircraft

import domain.datasource.aircraft.AirCraftDataSource
import domain.model.AirCraft
import domain.model.seat.Seat
import domain.model.seat.SeatClass
import domain.model.seat.SeatSection
import java.math.BigDecimal

// 3
class AirCraftLocalSource : AirCraftDataSource {
    override fun getAirCrafts(): List<AirCraft> = listOf(
        AirCraft("Airbus", "A320", getSeatSections()),
        AirCraft("Airbus", "A320", getSeatSections()),
        AirCraft("Airbus", "A320", getSeatSections())
    )

    private fun getSeatSections(): List<SeatSection> {
        return listOf(
            SeatSection(
                seatClass = SeatClass.BUSINESS,
                seats = arrayOf(
                    Seat("1", BigDecimal(30), SeatClass.BUSINESS),
                    Seat("2", BigDecimal(30), SeatClass.BUSINESS),
                    Seat("3", BigDecimal(30), SeatClass.BUSINESS),
                ),
                BigDecimal(30)
            ),
            SeatSection(
                seatClass = SeatClass.PLUS,
                seats = arrayOf(
                    Seat("4", BigDecimal(20), SeatClass.PLUS),
                    Seat("5", BigDecimal(20), SeatClass.PLUS),
                    Seat("6", BigDecimal(20), SeatClass.PLUS),
                ),
                BigDecimal(20)
            ),
            SeatSection(
                seatClass = SeatClass.ECONOMY,
                seats = arrayOf(
                    Seat("7", BigDecimal(10), SeatClass.ECONOMY),
                    Seat("8", BigDecimal(10), SeatClass.ECONOMY),
                    Seat("9", BigDecimal(10), SeatClass.ECONOMY),
                ),
                BigDecimal(10)
            )
        )
    }
}