object LoginSystem {



    private val benutzerDatenbank = mutableMapOf(
        "Benutzer1" to "Passwort1",
        "Benutzer2" to "Passwort2",

    )

    fun benutzerEinloggen(): Boolean {
        print("Benutzername: ")
        val benutzername = readln()?.trim() ?: ""

        print("Passwort: ")
        val passwort = readln()?.trim() ?: ""

        return ueberpruefeAnmeldeDaten(benutzername, passwort)
    }

    private fun ueberpruefeAnmeldeDaten(benutzername: String, passwort: String): Boolean {
        val gespeichertesPasswort = benutzerDatenbank[benutzername]

        if (gespeichertesPasswort != null && gespeichertesPasswort == passwort) {
            println("Anmeldung erfolgreich! Willkommen, $benutzername.")
            return true
        } else {
            println("Falscher Benutzername oder Passwort. Anmeldung fehlgeschlagen.")
            return false
        }
    }
}