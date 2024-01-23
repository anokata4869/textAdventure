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

    fun greifeAn(helden: List<Held>) {
        if (fluchRunden > 0) {
            fluchRunden--
            fluch(helden)
        }

        val schaden = berechneZufallsSchaden()
        val reduzierterSchaden = schaden - helden.first().ruestung.coerceAtLeast(0)

        if (reduzierterSchaden > 0) {
            val zufaelligerHeld = helden.random()
            zufaelligerHeld.ermittleSchaden(reduzierterSchaden)
            println("Der Endgegner $name greift an und fügt ${zufaelligerHeld.name} $reduzierterSchaden Schaden zu!")
        } else {
            println("Der Angriff des Endgegners wurde abgewehrt! Kein Schaden zugefügt.")
        }

        blutdurst.aktuell = (blutdurst.aktuell + schaden / 2).coerceAtMost(blutdurst.max)
        println("Blutdurst des Endgegners: ${blutdurst.aktuell}/${blutdurst.max}")

        if (minionBeschworen) {
            beschwoereMinion()
        } else {
            println("Der Endgegner hat noch keine Minions beschworen.")
        }
    }

    open fun feueratem(helden: List<Held>) {
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

    fun beschwoereMinion() {
        if (!minionBeschworen) return

        val neuerMinion = Minion("Minion-1")
        println("Der Endgegner $name beschwört einen Minion: ${neuerMinion.name}")
        minion = neuerMinion
    }

    fun greifeMitMinionAn() {
        minion?.greifeAn(this)
    }

    fun fluch(helden: List<Held>) {
        for (held in helden) {
            held.ermittleSchaden(10)
            println("${held.name} erleidet Fluchschaden! Neue HP: ${held.hp}")
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
                greifeMitMinionAn()
            }
        } else {
            greifeMitMinionAn()
        }

        // Endgegner greift die Helden an
        helden.forEach { held ->
            if (held.hp > 0) {
                greifeAn(listOf(held))
            }
        }
    }
}
