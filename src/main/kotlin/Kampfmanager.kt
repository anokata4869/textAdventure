class KampfManager(private val helden: List<Held>, private val endgegner: Endgegner) {

    fun startKampf() {
        println("Der Kampf beginnt!")

        while (helden.any { it.hp > 0 } && endgegner.hp > 0) {
            // Helden greifen den Endgegner an
            for (held in helden) {
                held.attackiere(endgegner)
            }

            // Endgegner greift die Helden an
            endgegner.greifeAn(helden)

            if (endgegner.fluchRunden == 0) {
                endgegner.fluch(helden)
                endgegner.fluchRunden = 6
            }

            endgegner.handleEndgegnerAktionen(helden)

            // Ergebnisse anzeigen
            println("Kampf beendet!")
            println("Endgegner hat noch ${endgegner.hp} Lebenspunkte.")
            for (held in helden) {
                held.zeigeStatus()
            }
        }
    }
}


