package seed

fun main() {
    val n = readln().toInt()

    repeat(n) { i ->
        println("*".repeat(i + 1))
    }
}