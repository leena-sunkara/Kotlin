import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter the total price")
    val n = scanner.nextInt()
    if (n < 300) {
        println("No discount")
    } else {
        val discount = 0.1 * n
        if (discount >= 100) {
            println(100)
        } else println(discount)
    }
}