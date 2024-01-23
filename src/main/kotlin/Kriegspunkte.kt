open class Kriegspunkte {
    var aktuell: Int = 0
    val max: Int = 250

     fun erhoeheDurchAngriff() {
        val zufälligerAnstieg = (10..15).random()
        erhoeheKriegspunkte(zufälligerAnstieg)
    }

    fun erhoeheDurchTrank() {
        val zufälligerAnstieg = (2..3).random()
        erhoeheKriegspunkte(zufälligerAnstieg)
    }

    private fun erhoeheKriegspunkte(anstieg: Int) {
        aktuell += anstieg
        if (aktuell >= max) {
            aktuell = max
            println("Der Spezialangriff steht zur Verfügung!")
        }

        println("Kriegspunkte: $aktuell/$max")
    }
}
