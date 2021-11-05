fun main() {
    val day = "Monday"
    when(day) {
        "Monday" -> println("Mon")
        "Tuesday" -> println("Tue")
        "Wednesday" -> println("Wed")
        "Thursday" -> println("Thu")
        "Friday" -> println("Fri")
        "Saturday" -> println("Sat")
        "Sunday" -> println("Sun")
        else -> println("Invalid Day")
    }
}