fun main() {
    println("Willkommen im Hauptmenü")
    println("1. Neues Spiel")
    println("2. Spiel Laden")
    println("3. Einstellungen")
    println("4. Beenden")

    print("Bitte wähle eine Option: ")
    val auswahl = readln()?.toIntOrNull()

    when (auswahl) {
        1 -> neuesSpiel(prolog(), startGame())
        2 -> spielLaden()
        3 -> einstellungen()
        4 -> spielBeenden()
        else -> println("Ungültige Option. Bitte wähle eine Zahl zwischen 1 und 4.")
    }
}

fun neuesSpiel(prolog: Unit, startGame: Unit) {
    println("Neues Spiel wird gestartet...")
    // Hier füge den Code hinzu, um ein neues Spiel zu starten
}

fun spielLaden() {
    println("Spiel wird geladen...")
    // Hier füge den Code hinzu, um das Spiel zu laden
}

fun einstellungen() {
    println("Einstellungen werden geöffnet...")
    // Hier füge den Code hinzu, um die Einstellungen anzuzeigen und zu ändern
}

fun spielBeenden() {
    println("Spiel wird beendet")
    // Hier füge den Code hinzu, um das Spiel zu beenden
}