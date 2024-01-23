import kotlin.random.Random
open class Held(
    val name: String,
    var hp: Double,
    var ruestung: Int,
    private var staerke: Double = 1.0
) {

    val angriff: Int = 100
    val maxHp: Double = hp

    fun zeigeStatus() {
        println("Status von $name:")
        println("Rüstung: $ruestung")
        println("HP: $hp")
        println("Stärke: $staerke")
    }

    open fun attackiere(gegner: Gegner) {
        println("$name greift ${gegner.name} an!")

        val schadenswert = generiereZufallsSchaden(120, 330)
        val effektiverSchaden = schadenswert - gegner.ruestung.coerceAtLeast(0)

        if (effektiverSchaden > 0) {
            gegner.hp -= effektiverSchaden
            println("$name greift den ${gegner.name} an und fügt $effektiverSchaden Schaden zu.")

        } else {
            println("$name greift den ${gegner.name} an, aber der Angriff wurde von der Rüstung abgewehrt.")
        }
    }

    fun heile(heilung: Double) {
        hp = minOf(hp + heilung, maxHp)
    }

    fun staerkeErhoehen(erhoehung: Double) {
        staerke += erhoehung
    }

    fun ermittleSchaden(schaden: Int) {
        hp -= schaden
        if (hp < 0) {
            hp = 0.0
        }
    }

    fun spezialangriff() {
        println("$name führt einen Spezialangriff aus!")

        val schadensanteil = Random.nextDouble(0.2, 0.45)

        hp = maxHp
        println("$name und die Helden wurden geheilt. Neue HP von $name: $hp")
    }

    private fun generiereZufallsSchaden(min: Int, max: Int): Int {
        return Random.nextInt(min, max + 1)
    }

    fun cheat(gegner: Gegner) {
        gegner.hp = 0.0
    }
}
