
import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import domain.datasource.baggage.BaggagePackageDataSource
import domain.usecases.baggage.GetBaggagePackages
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole

fun main() {

    // 7. Crear
    println()

    val vClubLocalSource = BaggageVClubLocalSource()
    val getVClubPackages = GetBaggagePackages(vClubLocalSource).invoke()

    val regularLocalSource = BaggageRegularLocalSource()
    val getRegularPackages = GetBaggagePackages(regularLocalSource).invoke()

    /*println("*** VClub Baggage's ***")
    getVClubPackages.forEach { (t, u) ->
        print("$t. ")
        println(BaggagePackageConsole(
            BaggageTypesConsole()
        ).format(u))
    }

    println()
    println("*** Regular Baggage's ***")
    getRegularPackages.forEach { (t, u) ->
        print("$t. ")
        println(BaggagePackageConsole(
            BaggageTypesConsole()
        ).format(u))
    }*/

    // 8 crear
    println("*** VClub Baggage's ***")
    printBaggagePacksConsole(regularLocalSource)
    println()
    println("*** Regular Baggage's ***")
    printBaggagePacksConsole(vClubLocalSource)

}

// 8 crear
fun printBaggagePacksConsole(
    baggageDataSource: BaggagePackageDataSource
) {
    val getBaggagePackages = GetBaggagePackages(baggageDataSource).invoke()

    getBaggagePackages.forEach { (t, u) ->
        print("$t. ")
        println(BaggagePackageConsole(
            BaggageTypesConsole()
        ).format(u))
    }

}
