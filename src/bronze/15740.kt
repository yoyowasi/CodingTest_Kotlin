package bronze

// - 문제 | 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

// - 입력 | 첫째 줄에 A와 B (-1010000 ≤ A, B ≤ 1010000)가 주어진다.

// - 출력 | 첫째 줄에 A+B를 출력한다.

fun main() {
    val (A,B) = readln().split(" ").map { it.toBigInteger() }
    print(A+B)

}