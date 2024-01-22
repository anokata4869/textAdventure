

class Inventar {
    private val effekte = listOf(
        InventarEffekt.Heiltrank(),
        InventarEffekt.Heiltrank(),
        InventarEffekt.Heiltrank(),
        InventarEffekt.Vitamine()
    )



    fun nutzeBeutel(held: Held): InventarEffekt? {
        println("${held.name} nutzt den Beutel.")
        return effekte.shuffled().firstOrNull()?.also {
            effekte.remove(it)
        }
    }