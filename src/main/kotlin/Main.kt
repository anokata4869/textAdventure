import kotlin.random.Random

class Person(var name: String, var alter: Int, var wohnort: String) {
    fun aelterWerden() {
        alter++
    }

    fun info(): String {
        return "Name: $name, Alter: $alter, Wohnort: $wohnort"
    }
}

var genericVorName = mutableListOf("Nathan\n" ,
        "Wolfram\n",
        "Ilay\n" ,
        "Andre\n" ,
        "Joey\n" ,
        "Olaf\n" ,
        "Erik\n" ,
        "Janek\n" ,
        "Henry\n" ,
        "Luc\n" ,
        "Domenik\n" ,
        "Marek\n" ,
        "Ömer\n" ,
        "Yannis\n" ,
        "Vincent")

var genericNachName = mutableListOf("Lutz\n" ,
        "Baumeister\n" ,
        "Sailer\n" ,
        "Borchert\n" ,
        "Metzner\n" ,
        "Nguyen\n" ,
        "Wille\n" ,
        "Kersten\n" ,
        "Wiedemann\n" ,
        "Thomas\n",
        "Schmitz\n",
        "Kohlscheidt\n",
        "Winchester\n",
        "Balduin\n",
        "Karrenbauer\n",
        "Kahn\n",
    )

    val kombiList = genericVorName.zip(genericNachName)

    val randomNameIndex = Random.nextInt(kombiList.size)
    val randomFullName = kombiList[randomNameIndex]

fun main() {
    println("Willkommen bei Esort of Magic")

    println("Gib deinen Namen ein:")
    var name = readln() ?: "" // Benutzereingabe für den Namen

    println("Gib dein Alter ein:")
    val alterInput = readln()  ?: "0" // Benutzereingabe für das Alter
    val alter = alterInput.toIntOrNull() ?: 0 // Das Alter in Integer umwandeln, Standardwert: 0, falls die Eingabe ungültig ist

    println("Gib deinen Wohnort ein:")
    val wohnort = readln()  ?: "" // Benutzereingabe für den Wohnort

    // Erstellen einer Person-Instanz mit den eingegebenen Informationen
    val person1 = Person(name, alter, wohnort)

    // Informationen über die erstellte Person ausgeben
    println("Neue Person erstellt:")
    println(person1.info())


    println("Hallo $name wie geht es dir")




    println("Mein Name ist ${randomFullName.first} ${randomFullName.second}, wie geht es dir?")
    val antwort = readln() ?: ""

    if (antwort.equals("Gut" , ignoreCase = true)) {
        println("Das freut mich sehr.")
    } else {
        println("Ich hoffe, ich kann deine Laune steigern.")
    }


}