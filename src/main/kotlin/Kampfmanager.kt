
    class KampfManager(private val helden: List<Held>, private val endgegner: Endgegner) {

        // Funktion für einen Angriff
        private fun attack(attacker: Held, target: Endgegner) {
            val schaden = (Math.random() * (attacker.angriff + 1)).toInt()
            val finalerSchaden = schaden - endgegner.ruestung
            val endgegnerHP = Math.max(0.0, target.hp - finalerSchaden)
            target.hp = endgegnerHP
            println("${attacker.name} greift den Endgegner an und verursacht $finalerSchaden Schaden.")
            println("Endgegner hat noch $endgegnerHP Lebenspunkte.")
        }


        fun startKampf() {
            fun startKampf() {
                println("Der Kampf beginnt!")

                // Helden greifen den Endgegner an
                for (held in helden) {
                    held.attackiere(endgegner)
                }

                // Endgegner greift die Helden an
                endgegner.greifeAn(helden)

                // Ergebnisse anzeigen
                println("Kampf beendet!")
                println("Endgegner hat noch ${endgegner.hp} Lebenspunkte.")
                for (held in helden) {
                    held.zeigeStatus()
                }
            }
        }


