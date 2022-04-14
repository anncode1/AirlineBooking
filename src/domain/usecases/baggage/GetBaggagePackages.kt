package domain.usecases.baggage

import domain.datasource.baggage.BaggagePackageDataSource
import domain.model.baggage.pack.BaggagePackage
import java.math.BigDecimal

/**
 * 3. Mostrar los tipos de Equipajes disponibles
 * */
// 3 clase-17 Hacer
class GetBaggagePackages(
    private val baggagePackageDataSource: BaggagePackageDataSource
) {

    operator fun invoke(price: BigDecimal): Map<Int, BaggagePackage> {
        return baggagePackageDataSource.getBaggagePacks(price)
    }
}