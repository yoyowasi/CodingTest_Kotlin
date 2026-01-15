package seed

// - 문제 | 연산자의 기호는 ＠으로, A＠B = (A+B)×(A-B)으로 정의내리기로 했다.

// - 입력 | 첫째 줄에 A, B가 주어진다. (1 ≤ A, B ≤ 100,000)

// - 출력 | 첫째 줄에 A＠B의 결과를 출력한다.

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    println((a + b) * (a - b))
}