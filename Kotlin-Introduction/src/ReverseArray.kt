import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter the size of the array")
    val n = scanner.nextInt()
    println("Enter the array elements")
    val arr = arrayOfNulls<Int>(n)
    for (i in 0 until n) {
        arr[i] = scanner.nextInt()
    }
    for (i in n-1 downTo 0) {
        println(arr[i])
    }
}