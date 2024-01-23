open class InventarEffekt {
     open val beschreibung: String = ""

     open fun anwendenAuf(held: Held) {

     }

     class Heiltrank : InventarEffekt() {
          override val beschreibung: String = "Heiltrank: Heilt den Spieler um die Hälfte seiner HP."

          override fun anwendenAuf(held: Held) {
               val heilung = held.maxHp / 2
               held.heile(heilung)
               println("${held.name} wurde um $heilung geheilt.")
          }
     }

     class Vitamine : InventarEffekt() {
          override val beschreibung: String = "Vitamine: Geben dem Spieler 10% mehr Stärke für die Dauer des Kampfes."

          override fun anwendenAuf(held: Held) {
               held.staerkeErhoehen(0.1)
               println("${held.name} hat 10% mehr Stärke erhalten.")
          }
     }
}

