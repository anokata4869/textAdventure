import kotlin.random.Random

open class Held(
    val name: String = readln(),
    var hp: Double,
    var ruestung: Int,
    //var kriegspunkte: Kriegspunkte = Kriegspunkte(0, 200)
) {
    //class Kriegspunkte(var aktuell: Int, val max: Int)

    fun zeigeStatus() {
        println("Status von $name:")
        println("Rüstung: $ruestung")
        //println("Kriegspunkte: ${kriegspunkte.aktuell}/${kriegspunkte.max}")
    }

    open fun attackiere(gegner: Gegner) {
        println("$name greift ${gegner.name} an!")

        val schadenswert = generiereZufallsSchaden(12, 33)
        val effektiverSchaden = schadenswert - gegner.ruestung.coerceAtLeast(0)

        if (effektiverSchaden > 0) {
            gegner.hp -= effektiverSchaden
            println("$name greift den ${gegner.name} an und fügt $effektiverSchaden Schaden zu.")

        } else {
            println("$name greift den ${gegner.name} an, aber der Angriff wurde von der Rüstung abgewehrt.")
        }
    }

    fun ermittleSchaden(schaden: Int) {
        hp -= schaden
        if (hp < 0) {
            hp = 0.0
        }
    }

    private fun spezialangriff() {
        println("$name führt einen Spezialangriff aus!")


        val schadensanteil = Random.nextDouble(0.2, 0.45)

        hp = maxHp
        println("$name und die Helden wurden geheilt. Neue HP von $name: $hp")
    }

    private fun generiereZufallsSchaden(min: Int, max: Int): Int {
        return Random.nextInt(min, max + 1)
    }

    private val maxHp: Double = hp
}

    fun cheat(){
        Endgegner
    }
