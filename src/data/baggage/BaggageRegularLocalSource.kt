package data.baggage

import domain.datasource.baggage.BaggagePackageDataSource
import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.regular.RegularBasic
import domain.model.baggage.pack.regular.RegularClassic
import domain.model.baggage.pack.regular.RegularPlus
import java.math.BigDecimal

// 2 Crear
class BaggageRegularLocalSource : BaggagePackageDataSource {
    override fun getBaggagePacks(price: BigDecimal): Map<Int, BaggagePackage> = mapOf(
        1 to RegularBasic(price),
        2 to RegularClassic(price),
        3 to RegularPlus(price)
    )
}