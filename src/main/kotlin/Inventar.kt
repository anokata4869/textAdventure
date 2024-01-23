

class Inventar {
    private val effekte = mutableListOf(
        InventarEffekt.Heiltrank(),
        InventarEffekt.Heiltrank(),
        InventarEffekt.Heiltrank(),
        InventarEffekt.Vitamine()
    )

    fun nutzeBeutel(held: Held): InventarEffekt? {
        if (effekte.isNotEmpty()) {
            val gewaehlterEffekt = effekte.shuffled().first()
            println("${held.name} nutzt den Beutel.")
            gewaehlterEffekt.anwendenAuf(held)
            effekte.remove(gewaehlterEffekt)
            println("Verbleibende Tränke: ${effekte.size}")
            return gewaehlterEffekt
        } else {
            println("Der Beutel ist leer. Nichts mehr verfügbar.")
            return null
        }
    }
}