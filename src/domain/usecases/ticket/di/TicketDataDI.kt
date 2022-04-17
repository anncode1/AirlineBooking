package domain.usecases.ticket.di

import data.ticket.TicketListSingleton
import domain.datasource.ticket.TicketsDataSource

class TicketDataDI {
    fun providesTicketData(): TicketsDataSource {
        return TicketListSingleton()
    }
}