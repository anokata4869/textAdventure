class Minion(var name: String = "kleiner Gehilfe") {
    private var hp: Int = 300

    fun greifeAn(held: Held) {
        val schaden = 50
        held.ermittleSchaden(schaden)

        println("Minion $name greift die Helden an und fügt $schaden Schaden zu!")
    }

    fun greifeAn(held: Endgegner) {

    }
}

class Endgegner(
    name: String = "Jake Michaelson",
    hp: Double,
    ruestung: Int,
    var blutdurst: Blutdurst
) : Gegner(name, hp, ruestung) {

    class Blutdurst(var aktuell: Int, val max: Int)

    private var minionBeschworen = false
    private var minion: Minion? = null
    private var fluchAktiviert = false
    var fluchRunden = 0

    init {
        println("Endgegner erstellt:")
        println("Name: $name")
        println("HP: $hp")
        println("Rüstung: $ruestung")
        println("Blutdurst: ${blutdurst.aktuell}/${blutdurst.max}")
    }

    fun zeigeStatus() {
        println("Endgegner Status:")
        println("HP: $hp")
        println("Rüstung: $ruestung")
        println("Blutdurst: ${blutdurst.aktuell}/${blutdurst.max}")
    }
    fun beschwoereMinion() {
        if (minionBeschworen) return

        val neuerMinion = Minion("Minion-1")
        println("Der Endgegner $name beschwört einen Minion: ${neuerMinion.name}")
        minion = neuerMinion
    }


    fun greifeMitMinionAn() {
        minion?.greifeAn(this)
    }

    fun feueratem(helden: List<Held>) {
        if (blutdurst.aktuell >= 40) {
            println("$name aktiviert Feueratem und fügt allen Helden Flächenschaden zu!")

            for (held in helden) {
                val schaden = (held.hp / 2).coerceAtLeast(0.0)
                held.hp -= schaden
                println("${held.name} erleidet $schaden Schaden. Neue HP: ${held.hp}")
            }

            blutdurst.aktuell -= 40
            println("Blutdurst des Endgegners: ${blutdurst.aktuell}/${blutdurst.max}")
        } else {
            println("$name kann Feueratem nicht aktivieren. Nicht genügend Blutdurst.")
        }
    }



    fun fluch(helden: List<Held>) {
        if (!fluchAktiviert) {
            for (held in helden) {
                held.ermittleSchaden(10)
                println("${held.name} erleidet Fluchschaden! Neue HP: ${held.hp}")
            }
            fluchAktiviert = true
        } else {
            println("Der Fluch wurde bereits aktiviert und ist nicht erneut verfügbar.")
        }
    }


    fun kiGesteuerterAngriff(helden: List<Held>) {
        println("--- $name ist am Zug ---")
        if (!fluchAktiviert) {
            fluchAktiviert = true
            println("Der Fluch des Endgegners $name wurde aktiviert.")
        }

        if (fluchRunden > 0) {
            fluchRunden--
            greifeAn(helden)

        } else {
            // KI-Entscheidung basierend auf HP und Blutdurst
            when {
                hp <= 200 -> {
                    // Wenn HP niedrig sind, Fluch anwenden
                    fluch(helden)
                    println("$name verwendet Fluch aufgrund niedriger HP.")
                }
                hp <= 1000 && !minionBeschworen -> {
                    // Wenn HP unter 1000 und Minion noch nicht beschworen wurde, Minion beschwören
                    beschwoereMinion()
                    println("$name beschwört einen Minion aufgrund niedriger HP.")
                }
                blutdurst.aktuell >= 40 -> {
                    // Wenn ausreichend Blutdurst vorhanden ist, Feueratem anwenden
                    feueratem(helden)
                    println("Ihr wagt es euch mir zu wiedersetzen, wie schmeckt euch mein Feueratem.")
                }
                else -> {
                    // Ansonsten normal angreifen
                    greifeAn(helden)
                    println("$name führt normalen Angriff aus.")
                }
            }
        }

        blutdurst.aktuell = (blutdurst.aktuell + berechneZufallsSchaden() / 2).coerceAtMost(blutdurst.max)
        println("Blutdurst des Endgegners: ${blutdurst.aktuell}/${blutdurst.max}")

        if (minionBeschworen) {
            greifeMitMinionAn()
            println("Minion greift an.")
        } else {
            println("$name hat noch keine Minions beschworen.")
        }
    }




    private fun berechneZufallsSchaden(): Int {
        return (Math.random() * 20 + 30).toInt()
    }

    fun handleEndgegnerAktionen(helden: List<Held>) {
        val maxHp: Double = 1200.0
        val hpVerlust = maxHp - hp
        val prozentualerVerlust = hpVerlust / maxHp

        if (prozentualerVerlust >= 0.5) {
            // 20% Chance, Feueratem zu benutzen
            if (Math.random() < 0.2) {
                feueratem(helden)
            } else {
                if (hp < 1000 && !minionBeschworen) {
                    beschwoereMinion()
                } else {
                    greifeMitMinionAn()
                }
            }
        } else {
            if (hp < 1000 && !minionBeschworen) {
                beschwoereMinion()
            } else {
                greifeMitMinionAn()
            }
        }
        helden.forEach { held ->
            if (held.hp > 0) {
                greifeAn(listOf(held))
            }
        }
    }

    fun greifeAn(helden: List<Held>) {

    }
}
