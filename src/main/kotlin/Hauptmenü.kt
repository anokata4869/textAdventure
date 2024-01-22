object Hauptmenü {



    fun zeigeHauptmenü() {
        var auswahl: Int

        do {
            println("---- Hauptmenü ----")
            println("1. Neues Spiel")
            println("2. Spiel Laden")
            println("3. Optionen")
            println("4. Spiel Beenden")

            print("Wähle eine Option (1-4): ")
            auswahl = readln()?.toIntOrNull() ?: 0

            when (auswahl) {
                1 -> starteNeuesSpiel()
                2 -> ladeSpiel()
                3 -> zeigeOptionen()
                4 -> println("Das Spiel wird beendet.")
                else -> println("Ungültige Auswahl. Bitte wähle eine Option zwischen 1 und 4.")
            }
        } while (auswahl != 4)
    }



    private fun starteNeuesSpiel() {
        Ladebildschirm.zeigeLadesequenz()
        val kampfsystem = Kampfsystem()
        kampfsystem.kämpfe()
    }

    private fun ladeSpiel() {

        println("Spiel wird geladen...")
    }


    private fun zeigeOptionen() {

        println("Optionen werden angezeigt...")
    }