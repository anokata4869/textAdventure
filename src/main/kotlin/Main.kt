// Hier können die Variablen und Listen für das Spiel definiert werden

var RassenWahl = mutableListOf(
        "Menschen der alten Welt" ,
        " Elbenvolk der Lumira " ,
        "Zwerge der Eisengrube ",
        "Feen des Lichtwaldes",
        "Nymphen des Wasserbergs")

var klassenWahlMenschen = mutableListOf("Krieger, Magier, Königsritter, Pendler")
var klassenWahlLumira = mutableListOf("Waldhüter, Weiser der Ätherie, Naturbändiger, Sternenweiser")
var weaponMutableList = mutableListOf("..")
val ausgewaehlteRasse: String = ""
//val indexDesGewaehltenEintrags: String = readln()

// Spielerklasse, um die Spielerdaten zu speichern
data class Spieler(
    var name: String,
    var level: Int = 1,
    var erfahrung: Int = 0,
    var skills: MutableList<String> = mutableListOf(),
    var waffen: MutableList<String> = mutableListOf(),


    // Verwende den ausgewählten Eintrag aus der Liste

    // Weitere Spielerattribute können hinzugefügt werden
)

// Funktion zum Starten des Spiels
fun startGame() {
    println("Willkommen im mittelalterlichen Königreich! Ein Abenteuer erwartet dich.")

    // Spielererstellung und Einführung
    println("Welche Rasse willst du Spielen? ")
    println("folgende Rassen stehen zur auswahl: ${RassenWahl.joinToString()}")
    val ausgewaehlteRasse: String = ""
    val indexDesGewaehltenEintrags: String = readln()

    println("du bist ein $indexDesGewaehltenEintrags")


    println("Wie ist dein Name, tapferer Recke?")
    val spielerName = readln() ?: "Spieler"
    val spieler = Spieler(spielerName)

    println("Hallo, $spielerName! Begib dich auf deine Reise und sei der Held der Geschichte.")

    // Starte das Abenteuer und implementiere die Spielmechanik hier
    // Hier kannst du Funktionen für verschiedene Spielmechaniken, Ereignisse und Interaktionen implementieren
    // wie z.B. Kämpfe, Levelaufstiege, Fähigkeitenerwerb, Waffenfund usw.
}


fun prolog(){

    println("01.01.1634")
    println("Die geschichte beginnt ihren Lauf in Silberbach einem kleinen dorf Südlich von Falkenhorst und dem derzeit Herrschenden König Henry von Lancaster ")


}

fun main() {
    prolog()
    startGame()


}