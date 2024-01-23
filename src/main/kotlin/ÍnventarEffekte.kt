open class InventarEffekt {
     open fun anwendenAuf(held: Held) {

     }

     class Heiltrank : InventarEffekt() {
          override fun anwendenAuf(held: Held) {
               val heilung = held.maxHp / 2
               held.heile(heilung)
               println("${held.name} wurde um $heilung geheilt.")
          }
     }

     class Vitamine : InventarEffekt() {
          override fun anwendenAuf(held: Held) {
               held.staerkeErhoehen(0.1)
               println("${held.name} hat 10% mehr Stärke erhalten.")
          }
     }
}
