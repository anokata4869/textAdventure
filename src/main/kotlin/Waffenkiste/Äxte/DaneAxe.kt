package Waffenkiste.Äxte

import kotlin.random.Random

class DaneAxe(val traeger: Held) {


    val staerke: Int = generiereZufallswert(10, 20)
    val staerkeBuff: Int = generiereZufallswert(5, 10)
    val minRuestungZumTragen: Int = 15 // Beispielwert, anpassen nach Bedarf


    fun effekt() {
        println("Die Dane Axe hat einen coolen Effekt: Vergiftung und eigene Heilung")
        vergifteGegner()
        heileTräger()
    }

    fun verbessereTräger() {
        println("Die Dane Axe verbessert die Werte des Trägers.")
        traeger.staerke += staerkeBuff
        traeger.ruestung += 5 // Beispielwert, anpassen nach Bedarf
        traeger.heilung = true // Beispiel für eine verbesserte Heilung, anpassen nach Bedarf
    }

    private fun vergifteGegner() {
        println("Gegner wurden vergiftet!")
        // Hier kannst du die Logik für die Vergiftung der Gegner implementieren
    }

    private fun heileTräger() {
        println("Träger wird geheilt!")
        // Hier kannst du die Logik für die Heilung des Trägers implementieren
    }

    private fun generiereZufallswert(min: Int, max: Int): Int {
        return Random.nextInt(min, max + 1)
    }
}

class Held(val name: String) {
    var staerke: Int = 0
    var ruestung: Int = 0
    var heilung: Boolean = false
    // Weitere Attribute des Helden nach Bedarf

    fun zeigeStatus() {
        println("Status von $name:")
        println("Stärke: $staerke")
        println("Rüstung: $ruestung")
        println("Heilung: $heilung")
    }
}

fun main() {
    val held = Held("Held1")
    val daneAxe = DaneAxe(held)

    // Zeige Status vor der Nutzung der Dane Axe
    held.zeigeStatus()

    // Nutze die Dane Axe
    daneAxe.effekt()
    daneAxe.verbessereTräger()

    // Zeige Status nach der Nutzung der Dane Axe
    held.zeigeStatus()
}
