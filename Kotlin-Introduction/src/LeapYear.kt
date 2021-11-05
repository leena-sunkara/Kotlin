fun main() {
    val num = readLine()!!
    if (num.toInt() % 4 == 0) {
        if (num.toInt() % 100 == 0) {
            if (num.toInt() % 400 == 0)
                println("Leap Year")
            else println("Not a Leap Year")
        } else println("Leap Year")
    } else println("Not a Leap Year")
}