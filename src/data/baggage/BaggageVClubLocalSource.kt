package data.baggage

import domain.datasource.baggage.BaggagePackageDataSource
import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.vclub.ClubBasic
import domain.model.baggage.pack.vclub.ClubClassic
import domain.model.baggage.pack.vclub.ClubPlus
import java.math.BigDecimal

// 2 Crear
class BaggageVClubLocalSource : BaggagePackageDataSource {
    override fun getBaggagePacks(price: BigDecimal): Map<Int, BaggagePackage> = mapOf(
        1 to ClubBasic(price),
        2 to ClubClassic(price),
        3 to ClubPlus(price),
    )
}