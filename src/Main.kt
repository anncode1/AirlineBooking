import domain.model.baggage.pack.regular.Regular
import domain.model.baggage.pack.regular.Basic as BasicRegular
import domain.model.baggage.pack.regular.Clasic as ClasicRegular
import domain.model.baggage.pack.vclub.Basic
import domain.model.baggage.pack.vclub.Clasic
import domain.model.baggage.pack.vclub.VClub
import domain.model.baggage.type.Checked
import java.math.BigDecimal

fun main() {

    val checkedBaggage = Checked()
    println(checkedBaggage.emoji)
    println()

    val basicPrice = BigDecimal(200)
    val clasicPrice = BigDecimal(400)

    val basicClub: VClub = Basic(basicPrice)
    val clasicClub: VClub = Clasic(clasicPrice)

    println(basicClub.name)
    println(basicClub.price)

    println(clasicClub.name)
    println(clasicClub.price)

    val basic: Regular = BasicRegular(basicPrice)
    val clasic: Regular = ClasicRegular(clasicPrice)

    println(basic.name)
    println(basic.price)

    println(clasic.name)
    println(clasic.price)
}