import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter the size of the array")
    val n = scanner.nextInt()
    println("Enter the array elements")
    val arr = arrayOfNulls<Int>(n)
    val hashmap = LinkedHashMap<Int, Int>()
    for (i in 0 until n) {
        arr[i] = scanner.nextInt()
        if (hashmap.containsKey(arr[i])) {
            hashmap[arr[i]!!] = hashmap[arr[i]]!! + 1
        } else hashmap[arr[i]!!] = 1
    }
    hashmap.forEach { (key, value) ->
        if (value == 1) {
            print("$key ")
        }
    }
}
