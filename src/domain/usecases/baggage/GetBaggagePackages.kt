package domain.usecases.baggage

import domain.model.baggage.pack.BaggagePackage

/**
 * 3. Mostrar los tipos de Equipajes disponibles
 * */
class GetBaggagePackages() {

    operator fun invoke(): Map<Int, BaggagePackage> {
        return mapOf()
    }
}