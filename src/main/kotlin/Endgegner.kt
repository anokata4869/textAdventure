class Endgegner(
    name: String = "Jake Michaelson",
     hp: Double,
    var ruestung: Int,
    var blutdurst: Blutdurst
) : Gegner(name, hp, ruestung) {

    class Blutdurst(var aktuell: Int, val max: Int)

    private var hatUnterbosse = false
    private var unterbossBeschworen = false
    private var fluchRunden = 0

    init {
        println("Endgegner erstellt:")
        println("Name: $name")
        println("HP: $hp")
        println("Rüstung: $ruestung")
        println("Blutdurst: ${blutdurst.aktuell}/${blutdurst.max}")
    }

    fun greifeAn(helden: List<Held>) {
        if (hatUnterbosse) {
            if (fluchRunden > 0) {
                fluchRunden--
                for (held in helden) {
                    held.ermittleSchaden(10)
                    println("${held.name} erleidet Fluchschaden! Neue HP: ${held.hp}")
                }
            }

            val schaden = berechneZufallsSchaden()
            val reduzierterSchaden = schaden - helden.first().ruestung.coerceAtLeast(0)

            if (reduzierterSchaden > 0) {
                helden.forEach { it.hp -= reduzierterSchaden }
                println("Der Endgegner $name greift an und fügt allen Helden $reduzierterSchaden Schaden zu!")
            } else {
                println("Der Angriff des Endgegners wurde abgewehrt! Kein Schaden zugefügt.")
            }

            blutdurst.aktuell += schaden / 2
            println("Blutdurst des Endgegners: ${blutdurst.aktuell}/${blutdurst.max}")

            if (hatUnterbosse && unterbossBeschworen && Math.random() < 0.2) {
                feueratem(helden)
            }
        } else {
            println("Der Endgegner hat noch keine Unterbosse beschworen.")
        }
    }

    fun fluch() {
        fluchRunden = 5
        println("$name wirkt Fluch! Die Helden erleiden in den nächsten 5 Runden jeweils 10 Schaden.")
    }

    private fun feueratem(helden: MutableList<Held>) {
        if (blutdurst.aktuell == blutdurst.max) {
            println("$name aktiviert Feueratem und fügt allen Helden Flächenschaden zu!")

            for (held in helden) {
                val schaden = (held.hp * 0.8).coerceAtLeast(0.0)
                held.hp -= schaden
                println("${held.name} erleidet $schaden Schaden. Neue HP: ${held.hp}")
            }
        } else {
            println("$name kann Feueratem nicht aktivieren.")
        }
    }

    fun beschwoereUnterboss() {
        hatUnterbosse = true
        unterbossBeschworen = true
        println("Der Endgegner $name hat Unterbosse beschworen!")
    }

    fun verliereUnterbosse() {
        hatUnterbosse = false
        unterbossBeschworen = false
        println("Der Endgegner $name hat seine Unterbosse verloren.")
    }

    private fun berechneZufallsSchaden(): Int {
        return (Math.random() * 20 + 30).toInt()
    }
}



