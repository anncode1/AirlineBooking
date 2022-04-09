
import domain.usecases.flight.GetFlights
import presentation.flight.formats.FlightConsoleFormat
import java.time.Month

fun main() {
    val getFlights = GetFlights().invoke(Month.JANUARY)
    getFlights.forEach { (t, u) ->
        print("$t. ")
        println(FlightConsoleFormat().format(u))
    }

    /*println("BaggageVClub")
    GetBaggages(BaggageVClubData()).invoke()
        .forEach { (t, u) ->
            print("$t. ")
            println(BaggagePackageConsole().format(u))
        }*/

    /*println("Baggage Regular")
    GetBaggagePackages(BaggageRegularData()).invoke()
        .forEach { (t, u) ->
            print("$t. ")
            println(BaggagePackageConsole().format(u))
        }*/

}
