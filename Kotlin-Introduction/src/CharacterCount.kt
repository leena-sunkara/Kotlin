fun main() {
    val arr = arrayOf("HTML", "CSS", "JAVA", "JS", "ANDROID")
    var length = 0
    for (element in arr) {
        length += element.length
    }
    println(length)
}