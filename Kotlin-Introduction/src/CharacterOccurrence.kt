import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter the string")
    var s = scanner.nextLine()
    s = s.replace(" ", "")
    val n = s.length
    val hashmap = LinkedHashMap<Char, Int>()
    for (i in 0 until n) {
        if (hashmap.containsKey(s[i])) {
            hashmap[s[i]] = hashmap[s[i]]!! + 1
        } else hashmap[s[i]] = 1
    }
    hashmap.forEach { (key, value) ->
        println("$key-$value")
    }
}