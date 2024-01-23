class Kampfsystem {

    val heldenTeam = mutableListOf(
        Held("Held 1", 100.0, 2000),
        Held("Held 2", 120.0, 2000),
        Held("Held 3", 80.0, 2000)
    )

    val endgegner = Endgegner("Endgegner", 200.0, 2500, Endgegner.Blutdurst(0, 250))
    val unterboss: Unterboss? = null
    val beutel = Beutel()

    fun kämpfe() {
        var runde = 1

        while (heldenTeam.any { it.hp > 0 } && endgegner.hp > 0) {
            println("\n--- Runde $runde ---")
            println("Helden-Team: ${heldenTeam.map { "${it.name}(${it.hp}HP)" }}")
            println("Endgegner: ${endgegner.name}(${endgegner.hp}HP)")

            heldenTeam.forEach { held ->
                println("\n${held.name}, wähle deine Aktion:")
                held.aktionen.forEachIndexed { index, aktion ->
                    println("${index + 1}. $aktion")
                }

                val auswahl = readln()?.toIntOrNull()

                when (auswahl) {
                    in 1..held.aktionen.size -> {
                        val gewählteAktion = held.aktionen[auswahl!! - 1]
                        handleHeldenAktion(held, gewählteAktion)
                    }
                    else -> println("Ungültige Auswahl.")
                }
            }

            handleEndgegnerAktion()

            runde++
        }

        println("\n--- Kampf beendet ---")
        if (heldenTeam.any { it.hp > 0 }) {
            println("Die Helden haben gewonnen!")
        } else {
            println("Der Endgegner hat gewonnen.")
        }
    }

    private fun handleHeldenAktion(held: Held, aktion: String) {
        when (aktion) {
            "Angriff" -> {
                held.attackiere(endgegner)
            }
            "Heilung" -> {
                // Implementiere Logik für Heilung
            }
            "Schutzzauber" -> {
                // Implementiere Logik für Schutzzauber
            }
            "Beutel nutzen" -> {
                beutel.nutzeBeutel(held)?.let { effekt ->
                    when (effekt) {
                        is InventarEffekt.Heiltrank -> {
                            // Implementiere Logik für Heiltrank
                        }
                        is InventarEffekt.Vitamine -> {
                            // Implementiere Logik für Vitamine
                        }
                    }
                }
            }
            else -> println("Ungültige Aktion.")
        }
    }

    private fun handleEndgegnerAktion() {
        endgegner.aktionen.shuffled().firstOrNull()?.let { aktion ->
            when (aktion) {
                "Flächenschaden" -> {
                    // Implementiere Logik für Flächenschaden
                }
                "Fluch" -> {
                    // Implementiere Logik für Fluch
                }
                "Beschwörung Unterboss" -> {
                    unterboss?.let {
                        // Implementiere Logik für Beschwörung Unterboss
                    }
                }
            }
        }
    }
}
