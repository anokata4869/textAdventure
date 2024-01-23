

fun main() {
// Definiere eine Liste von Helden mit Namen, HP (Lebenspunkten) und Rüstung
    val helden = listOf(
        Held("Legendärer Ritter 1", 1200.0, 50),
        Held("Legendärer Ritter 2", 900.0, 30),
        Held("Legendärer Ritter 3", 800.0, 10)
    )
// Erstelle einen Endgegner mit bestimmten HP, Rüstung und Blutdurst
    val endgegner = Endgegner(hp = 1500.0, ruestung = 50, blutdurst = Endgegner.Blutdurst(20, 200))
    //Erstelle Inventar
    val inventar = Inventar()
//Willkommen Apell
    println("Willkommen im Kampf!")
    // Initialisierung einer Whileschleife die Solange läuft wie ein Held und der Endboss am leben sind
    while (helden.any { it.hp > 0 } && endgegner.hp > 0) {
        // Zeige Rundeninformationen
        println("\n--- Runde ---")
        // Menü Anzeige
        println("1. Attackiere")
        println("2. Heile")
        println("3. Spezialangriff")
        println("4. Nutze Beutel")
        println("5. Cheat-test") // ist nur für testzwecke um vorzeitig dass Ende einzuläuten
// Der Endgegner greift die Helden an
        endgegner.greifeAn(helden)


// Frage den Benutzer nach der Auswahl eines Helden
        print("Wähle einen Helden (1-${helden.size}): ")
        val heldIndex = readln()?.toIntOrNull()?.let { it - 1 }
        // Überprüfe die Auswahl des Benutzers
        if (heldIndex in 0 until helden.size) {
            val held = helden[heldIndex!!]
// Frage den Benutzer nach der Aktion des Helden
            print("Wähle eine Aktion: ")
            val auswahl = readln()?.toIntOrNull()
// Führe die entsprechende Aktion basierend auf der Auswahl aus
            when (auswahl) {
                1 -> held.attackiere(endgegner)
                2 -> {
                    print("Gib die Heilungsmenge ein: ")
                    val heilung = readln()?.toDoubleOrNull() ?: 0.0
                    held.heile(heilung)
                }

                3 -> held.spezialangriff()
                4 -> {
                    inventar.nutzeBeutel(held)
                }

                5 -> held.cheat(endgegner)
                else -> println("Ungültige Auswahl.")
            }
            // Überprüfe, ob der Fluch des Endgegners aktiv ist
            if (endgegner.fluchRunden == 0) {
                endgegner.fluch(helden)
                endgegner.fluchRunden = 3
            }
            //initialisierung für den Feueratem
            endgegner.handleEndgegnerAktionen(helden)
            // Endgegner greift die Helden an
            helden.forEach { held ->
                if (held.hp > 0) {
                    endgegner.greifeAn(listOf(held))
                }
            }


// Zeige die aktuellen HP der Helden und des Endgegners
            println("Helden:")
            helden.forEach { held ->
                println("${held.name} (${held.hp} HP)")
            }
            println("Endgegner: ${endgegner.name} (${endgegner.hp} HP)")
            // Der Benutzer hat einen ungültigen Helden ausgewählt
        } else {
            println("Ungültige Auswahl für den Helden.")
        }
        // Zeige Informationen nach jeder Runde
        println("Nach der Runde:")
        endgegner.zeigeStatus()
        helden.forEach { it.zeigeStatus() }
    }
    //initialisierung welches Team Gewonnen hat
    if (helden.any { it.hp > 0 }) {
        println("Die Helden haben gewonnen!")
    } else {
        println("Der Endgegner hat gewonnen.")
    }
}




