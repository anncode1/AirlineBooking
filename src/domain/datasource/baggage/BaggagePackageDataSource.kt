package domain.datasource.baggage

import domain.model.baggage.pack.BaggagePackage
import java.math.BigDecimal

// 1 Crear
interface BaggagePackageDataSource {
    fun getBaggagePacks(): Map<Int, BaggagePackage>
}