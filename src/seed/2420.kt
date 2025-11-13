package seed

fun main() {
    val (N, M) = readln().split(" ").map { it.toLong() }
    if (N > M) {
        println(N - M)
    } else if (N < M) {
        println(M - N)
    } else {
        println(0)
    }
}
