package seed

fun main() {
    while (true) {
        val input = readlnOrNull() ?: break // 더 이상 읽을게 없으면 루프 탈출
        val (a, b) = input.split(" ").map { it.toInt() } //
        println(a + b)


    }
}