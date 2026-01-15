package seed

fun main() {
    val submitted = BooleanArray(31)
    repeat(28) {
        val n = readln().toInt()
        submitted[n] = true
    }
    for (i in 1..30) {
        if (!submitted[i]) {
            println(i)
        }
    }
}