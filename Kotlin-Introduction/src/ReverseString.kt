fun main() {
    val string = readLine()!!
    val n = string.length
    for (i in n-1 downTo 0) {
        print(string[i])
    }
}