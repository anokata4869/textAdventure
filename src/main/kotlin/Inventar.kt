class Inventar {
    private val effekte = mutableListOf(
        InventarEffekt.Heiltrank(),
        InventarEffekt.Heiltrank(),
        InventarEffekt.Heiltrank(),
        InventarEffekt.Vitamine()
    )

    fun nutzeBeutel(held: Held): InventarEffekt? {
        if (effekte.isNotEmpty()) {
            println("${held.name}, wähle einen Trank aus dem Beutel:")
            effekte.forEachIndexed { index, trank ->
                println("${index + 1}. ${trank.beschreibung}")
            }

            print("Deine Auswahl (1-${effekte.size}): ")

            val auswahl = readln()?.toIntOrNull()

            if (auswahl != null && auswahl in 1..effekte.size) {
                val gewaehlterEffekt = effekte[auswahl - 1]
                println("${held.name} nutzt ${gewaehlterEffekt.beschreibung}.")
                gewaehlterEffekt.anwendenAuf(held)
                effekte.remove(gewaehlterEffekt)
                println("Verbleibende Tränke: ${effekte.size}")
                return gewaehlterEffekt
            } else {
                println("Ungültige Auswahl. Der Beutel bleibt unberührt.")
                return null
            }
        } else {
            println("Der Beutel ist leer. Nichts mehr verfügbar.")
            return null
        }
    }
}