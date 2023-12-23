// Hier können die Variablen und Listen für das Spiel definiert werden

var rassenWahl = mutableListOf(
        "Menschen der alten Welt" ,
        " Elbenvolk der Lumira " ,
        "Zwerge der Eisengrube ",
        "Feen des Lichtwaldes",
        "Nymphen des Wasserbergs")

var klassenWahlMenschen = mutableListOf("Krieger, Magier, Königsritter, Pendler")
var klassenWahlLumira = mutableListOf("Waldhüter, Weiser der Ätherie, Naturbändiger, Sternenweiser")
var weaponMutableList = mutableListOf("..")
val ausgewaehlteRasse: String = ""
val spielerName = readln() ?: "Spieler"
val spieler = Spieler(spielerName)
val boss = "Jake Michaelson"




//val indexDesGewaehltenEintrags: String = readln()

// Spielerklasse, um die Spielerdaten zu speichern
data class Spieler(
    var name: String,
    var level: Int = 1,
    var erfahrung: Int = 0,
    var skills: MutableList<String> = mutableListOf(),
    var waffen: MutableList<String> = mutableListOf(),




    // Weitere Spielerattribute können hinzugefügt werden
)

data class jakeMichaelson1(
    var name: String = "Jake Michaelson",
    var level: Int = 30,
    var erfahrung: Int = 25000

)



// Funktion zum Starten des Spiels

fun main() {



    println("Willkommen im Hauptmenü")
    println("1. Neues Spiel")
    println("2. Spiel Laden")
    println("3. Einstellungen")
    println("4. Beenden")

    print("Bitte wähle eine Option: ")
    val auswahl = readln()?.toIntOrNull()

    when (auswahl) {
        1 -> neuesSpiel(prolog(), startGame())
        2 -> spielLaden()
        3 -> einstellungen()
        4 -> spielBeenden()
        else -> println("Ungültige Option. Bitte wähle eine Zahl zwischen 1 und 4.")
    }









}


fun startGame() {
    println("Willkommen im mittelalterlichen Königreich! Ein Abenteuer erwartet dich.")

    // Spielererstellung und Einführung
    println("Welche Rasse willst du Spielen? ")
    println("folgende Rassen stehen zur auswahl: ${rassenWahl.joinToString()}")
    rassenWahl.forEachIndexed { index, rasse -> println("${index + 1}. $rasse") }

    print("Bitte gib den Namen der gewählten Rasse ein: ")
    val eingabe = readln()?.trim()

    val gewaehlteRasse = rassenWahl.find { it.equals(eingabe, ignoreCase = true) }

    if (gewaehlteRasse != null) {
        println("Du hast die Rasse '$gewaehlteRasse' gewählt. Viel Spaß beim Abenteuer!")
        // Hier kannst du weitere Logik für das Spiel mit der gewählten Rasse implementieren
    } else {
        println("Ungültige Auswahl. Bitte gib den Namen einer verfügbaren Rasse ein.")
    }

    println("Wie ist dein Name, tapferer Recke?")
    spielerName





    println("Hallo, $spielerName! Begib dich auf deine Reise und sei der Held der Geschichte.")
    prolog()


}
fun prolog(){

    println("01.01.1634")
    println("Die geschichte beginnt ihren Lauf in Silberbach einem kleinen dorf Südlich von Falkenhorst und dem derzeit Herrschenden König Henry von Lancaster ")
    println("Der Junge $spielerName erwacht aus seinem Kinderbett, und sieht überall Blut")
    println("plötzlich sieht er $boss mit dem Rücken zum Kinderbett, lachend ein Schwert in der Hand")
    println("die andere Hand richtung Wand gestreckt, und an dessen ende MAAAMAAA!!!!!")
    println("Jake dreht sich um sieht den Knaben lacht und sagt mit furchtergender ruhe in seiner Stimme")
    println("Sie es dir gut an junge, nicht lange und dich ereilt dass selbe Schicksal, aber bis dahin sollst du leiden")
    println("Solange leiden wie ich nach diesem Schwert suchen musste")



}


