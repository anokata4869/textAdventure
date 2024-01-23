object Ladebildschirm {

    fun zeigeLadesequenz() {
        println("Spiel wird geladen...")

        // Simuliere eine Ladeanimation von 0% bis 100%
        for (i in 0..100 step 10) {
            Thread.sleep(500) // Simuliere einen Ladevorgang
            print("\rLadevorgang: $i%")
        }

        println("\nLadevorgang abgeschlossen!")
    }

    fun zeigeLadefortschritt() {
        TODO("Not yet implemented")
    }
}

     fun zeigeLadefortschritt(prozent: Int) {
    print("\\rLadevorgang: $prozent%")
    System.out.flush()
}