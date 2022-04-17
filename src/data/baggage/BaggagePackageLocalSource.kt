package data.baggage

import domain.datasource.baggage.BaggagePackageDataSource
import java.math.BigDecimal

abstract class BaggagePackageLocalSource: BaggagePackageDataSource {
    val price: BigDecimal = BigDecimal(50)
}