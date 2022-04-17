package presentation.menu

import presentation.extfunction.isMenuOptionValid
import presentation.utils.Formatter


interface UIMenu<T> {

    fun showMenu(
        mapObjects: Map<Int, T>,
        formatter: Formatter<T>
    ): T? {
        var option = ""
        do {
            mapObjects.forEach { (t, u) ->
                print("$t. ")
                println(formatter.format(u))
            }

            println("*** Select Number Option ***")
            option = readLine().orEmpty()

        } while (!option.isMenuOptionValid(mapObjects))

        return mapObjects[option.toInt()]
    }

}