import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.regular.Regular
import domain.model.baggage.pack.regular.RegularBasic
import domain.model.baggage.pack.regular.RegularClassic
import domain.model.baggage.pack.regular.RegularPlus
import domain.model.baggage.pack.vclub.ClubBasic
import domain.model.baggage.pack.vclub.ClubClassic
import domain.model.baggage.pack.vclub.VClub
import domain.model.baggage.type.Checked
import java.math.BigDecimal

fun main() {

    val checkedBaggage = Checked()
    println(checkedBaggage.emoji)
    println()

    val basicPrice = BigDecimal(200)
    val clasicPrice = BigDecimal(400)

    val basicClub: VClub = ClubBasic(basicPrice)
    val clasicClub: VClub = ClubClassic(clasicPrice)

    println(basicClub.name)
    println(basicClub.price)

    println(clasicClub.name)
    println(clasicClub.price)

    val basic: Regular = RegularBasic(basicPrice)
    val clasic: Regular = RegularClassic(clasicPrice)

    println(basic.name)
    println(basic.price)

    println(clasic.name)
    println(clasic.price)

//    val vclub = VClub()
//    val regular = Regular()
//    val baggagePackage = BaggagePackage()
}