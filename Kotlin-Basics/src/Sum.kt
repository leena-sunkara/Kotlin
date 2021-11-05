fun main() {
    var sum = 0
    for (i in 1..10) {
        if (i % 3 == 0) {
            sum += i
        }
    }
    println(sum)
}