package domain.usecases.ticket.di

import data.ticket.TicketSingleton
import domain.datasource.ticket.TicketDataSource

class TicketDataDI {
    fun providesTicket(): TicketDataSource {
        return TicketSingleton()
    }
}