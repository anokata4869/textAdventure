// ausführung der Listen fürs Spiel

val levelEbenen = mutableListOf(
        "Schwarzdornwald der Schatten\n" ,
        "Rittertum der Verlorenen Tugenden\n" ,
        "Zauberreich der Vergessenen Magie\n" ,
        "Nebelmoor der Versunkenen Seelen\n" ,
        "Drachenklaue-Tal der Legenden\n" ,
        "Burgmauern des Ewigen Zwists\n" ,
        "Geisterpfade der Verbannten\n" ,
        "Eichenherz-Wald der Geheimnisse\n" ,
        "Sturmwolken-Gebirge des Unheils\n" ,
        "Sumpfland der Finsteren Hexerei\n" ,
        "Königsgruft der Vergangenen Ära\n" ,
        "Dämmerhöhen der Unendlichen Einsamkeit\n" ,
        "Weg der Ewigen Prüfungen\n" ,
        "Verborgenes Tal der Mystischen Artefakte\n" ,
        "Raubritter-Ruinen des Bösen Erbes")

var rassenWahl = mutableListOf(
        "Menschen der alten Welt" ,
        " Elbenvolk der Lumira " ,
        "Zwerge der Eisengrube ",
        "Feen des Lichtwaldes",
        "Nymphen des Wasserbergs")

var klassenWahlMenschen = mutableListOf("Krieger, Magier, Königsritter, Pendler")

var klassenWahlLumira = mutableListOf("Waldhüter, Weiser der Ätherie, Naturbändiger, Sternenweiser")

var waffenSchwert = mutableListOf(
        "Excalibur\n" ,
        "Durandal\n" ,
        "Joyeuse\n" ,
        "Gram\n" ,
        "Clarent\n" ,
        "Kusanagi-no-Tsurugi\n" ,
        "Zulfiqar\n" ,
        "Tizona\n" ,
        "Shamshir-e Zomorrodnegar\n" ,
        "Durendal")

var waffenAexte = mutableListOf(
        "Labrys\n" ,
        "Dane Axe\n" ,
        "Francisca\n" ,
        "Throwing Axe\n" ,
        "Viking Bearded Axe\n" ,
        "Bipennis\n" ,
        "Tomahawk\n" ,
        "Bardiche\n" ,
        "Hache du Combat\n" ,
        "Cholera Axe")

var waffenBoegen = mutableListOf(
        "Artemis Bow\n" ,
        "Longbow of Robin Hood\n" ,
        "Mongol Bow\n" ,
        "Yumi\n" ,
        "English Longbow\n" ,
        "Recurve Bow\n" ,
        "Compound Bow\n" ,
        "Crossbow of William Tell\n" ,
        "Turkish Bow\n" ,
        "Horn Bow")

var waffenSpeere = mutableListOf(
        "Gungnir\n" ,
        "Lance of Longinus\n" ,
        "Pilum\n" ,
        "Assegai\n" ,
        "Boar Spear\n" ,
        "Ranseur\n" ,
        "Partisan\n" ,
        "Pike\n" ,
        "Trident\n" ,
        "Javelin")

var waffenMagerStaebe = mutableListOf(
        "Elder Wand\n" ,
        "Scepter of Ra\n" ,
        "Caduceus\n" ,
        "Crystal Wand\n" ,
        "Staff of Gandalf\n" ,
        "Phoenix Feather Wand\n" ,
        "Rod of Asclepius\n" ,
        "Arcane Staff\n" ,
        "Divining Rod\n" ,
        "Wizard's Staff")

val levelListe = (1..70).toList()

// Variablen Deklarierung

val ausgewaehlteRasse: String = ""
val spielerName = readln() ?: "Spieler"
val spieler = Spieler(spielerName)
val boss = "Jake Michaelson"

val basisErfahrung = 1000 // Erfahrungspunkte für Level 1
val endErfahrung = 190000 // Erfahrungspunkte für Level 70


// Spielerklasse, um die Spielerdaten zu speichern
data class Spieler(
    var name: String,
    var level: Int = 1,
    var erfahrung: Int = 0,
    var skills: MutableList<String> = mutableListOf(),
    var waffen: MutableList<String> = mutableListOf(),


    // Weitere Spielerattribute können hinzugefügt werden
)
// gegenSpieler klasse
data class jakeMichaelson1(
    var name: String = "Jake Michaelson",
    var level: Int = 30,
    var erfahrung: Int = 84000
    var skills: MutableList<String> = mutableListOf(),
    var waffen: MutableList<String> = mutableListOf(),

)


// Funktion zum Starten des Spiels
fun neuesSpiel() {
    println("Neues Spiel wird gestartet...")
    // Hier füge den Code hinzu, um ein neues Spiel zu starten
}

fun SpielLaden() {
    println("Spiel wird geladen...")
    // Hier füge den Code hinzu, um das Spiel zu laden
}

//fun einstellungen() {
   // println("Einstellungen werden geöffnet...")
    // Hier füge den Code hinzu, um die Einstellungen anzuzeigen und zu ändern
//}
//fun spielBeenden() {
//  println("Spiel wird beendet")
    // Hier füge den Code hinzu, um das Spiel zu beenden
//}

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
