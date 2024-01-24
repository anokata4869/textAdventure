fun main() {
    // Erstelle einen Endgegner mit bestimmten HP, Rüstung und Blutdurst
    val endgegner = Endgegner(hp = 1500.0, ruestung = 50, blutdurst = Endgegner.Blutdurst(20, 200))

    // Erstelle Inventar
    val inventar = Inventar()

    // Willkommen Appell
    println("Willkommen im Kampf!")


    val helden: List<Held> = listOf(
        Hauptkrieger("Eren", 1200.0, 50),
        Magier("Johnathan", 900.0, 30),
        Druide("Lillith", 800.0, 10)
    )

    // erstellung einer While-Schleife, die solange läuft wie ein Held und der Endboss am Leben sind
    while (helden.any { it.hp > 0 } && endgegner.hp > 0) {
        // Zeige Rundeninformationen
        println("\n--- Runde ---")

        // Der Endgegner greift die Helden an
        endgegner.greifeAn(helden)


        // Frage den Benutzer nach der Auswahl eines Helden
        for (held in helden) {
            zeigeHeldenMenü(held)
            val auswahl = readln()?.toIntOrNull()
println("----------------------------------------------------")
            // Führt die entsprechende Aktion basierend auf der Auswahl aus
            when (auswahl) {
                1 -> {
                    held.attackiere(endgegner)
                    println("${held.name} attackiert den Endgegner.")
                }
                2 -> {
                    print("Gib die Heilungsmenge für ${held.name} ein: ")
                    val heilung = readln()?.toDoubleOrNull() ?: 0.0
                    held.heile(heilung)
                    println("${held.name} heilt sich um $heilung.")
                }
                3 -> {
                    held.spezialangriff()
                    println("${held.name} führt einen Spezialangriff aus.")
                }
                4 -> {
                    inventar.nutzeBeutel(held)
                    println("${held.name} nutzt den Beutel.")
                }
                else -> println("Ungültige Auswahl für ${held.name}.")
            }
        }
        println("----------------------------------------------------")

        // Überprüfe, ob der Fluch des Endgegners aktiv ist
        if (endgegner.fluchRunden == 0) {
            endgegner.fluch(helden)
            endgegner.fluchRunden = 3
            println("Endgegner aktiviert Fluch.")
        }
        println("----------------------------------------------------")

        // Initialisierung für den Feueratem
        endgegner.handleEndgegnerAktionen(helden)

        // Endgegner greift die Helden an
        helden.forEach { held ->
            if (held.hp > 0) {
                endgegner.greifeAn(listOf(held))
                println("Endgegner greift ${held.name} an.")
            }
        }
        println("----------------------------------------------------")

        // Zeige die aktuellen HP der Helden und des Endgegners
        println("Helden:")
        helden.forEach { held ->
            println("${held.name} (${held.hp} HP)")
        }
        println("----------------------------------------------------")

        println("Endgegner: ${endgegner.name} (${endgegner.hp} HP)")
        println("----------------------------------------------------")

        // Zeige Informationen nach jeder Runde
        println("Nach der Runde:")
        println("----------------------------------------------------")

        endgegner.zeigeStatus()
        println("----------------------------------------------------")
        println("----------------------------------------------------")

        helden.forEach { it.zeigeStatus() }
    }
    println("----------------------------------------------------")

    // Initialisierung, welches Team gewonnen hat
    if (helden.any { it.hp > 0 }) {
        println("Die Helden haben gewonnen!")
    } else {
        println("Der Endgegner hat gewonnen.")
    }
}


fun zeigeHeldenMenü(held: Held) {
    println("Menü für ${held.name}:")
    println("1. Attackiere")
    println("2. Heile")
    println("3. Spezialangriff")
    println("4. Nutze Beutel")
    print("Wähle eine Aktion (1-4) für ${held.name}: ")
}
