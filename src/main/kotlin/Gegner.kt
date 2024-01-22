open class Gegner(
    val name: String,
    var hp: Double,
    val aktionen: List<String> = listOf("Flächenschaden", "Fluch", "Beschwörung Unterboss")
)