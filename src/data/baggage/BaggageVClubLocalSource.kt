package data.baggage

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.vclub.ClubBasic
import domain.model.baggage.pack.vclub.ClubClassic
import domain.model.baggage.pack.vclub.ClubPlus

// 2 Crear
class BaggageVClubLocalSource : BaggagePackageLocalSource() {
    override fun getBaggagePacks(): Map<Int, BaggagePackage> = mapOf(
        1 to ClubBasic(price),
        2 to ClubClassic(price),
        3 to ClubPlus(price),
    )
}