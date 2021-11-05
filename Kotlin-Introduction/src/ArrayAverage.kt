fun main() {
    val arrOne = arrayOf(0)
    val arrTwo = arrayOf(1, 2, 3, 4, 5)
    val arrThree = arrayOf(-12, -39, 12, 41, 22, 44)
    var sumOne = 0
    for (element in arrOne) {
        sumOne += element
    }
    val avgOne = sumOne / arrOne.size
    println(avgOne)

    var sumTwo = 0
    for (element in arrTwo) {
        sumTwo += element
    }
    val avgTwo = sumTwo / arrTwo.size
    println(avgTwo)

    var sumThree = 0
    for (element in arrThree) {
        sumThree += element
    }
    val avgThree = sumThree / arrThree.size
    println(avgThree)
}