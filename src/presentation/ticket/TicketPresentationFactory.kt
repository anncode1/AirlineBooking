package presentation.ticket

import domain.model.Ticket
import presentation.utils.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.baggage.format.BaggagePackageConsoleFormat
import presentation.baggage.types.format.BaggageTypesConsoleFormat
import presentation.ticket.formats.TicketConsoleFormat

class TicketPresentationFactory : PresentationFactory<Ticket> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Ticket> {
        return TicketConsoleFormat(
            BaggagePackageConsoleFormat(
                BaggageTypesConsoleFormat()
            )
        )
    }
}