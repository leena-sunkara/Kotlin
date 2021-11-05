fun main() {
    val scores = arrayOf(28, 43, 2, 32)
    var lowest = scores[0]
    for (score in scores) {
        if (score < lowest) {
            lowest = score
        }
    }
    println(lowest)
}