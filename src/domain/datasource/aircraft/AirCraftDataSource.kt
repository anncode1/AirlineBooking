package domain.datasource.aircraft

import domain.model.AirCraft

// 3
interface AirCraftDataSource {
    fun getAirCrafts(): List<AirCraft>
}