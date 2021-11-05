fun main() {
    println("Enter the countries : ")
    val arr = arrayOfNulls<String>(10)
    for (i in arr.indices) {
        arr[i] = readLine()!!
    }
    println("Enter the country to search : ")
    val input = readLine()
    println(checkCountry(arr, input))
}

fun checkCountry(arr: Array<String?>, input: String?): String {
    for (i in 0 until 10) {
        if (input.equals(arr[i])) {
            return arr[i] + " " + i
        }
    }
    return "Not Found"
}
