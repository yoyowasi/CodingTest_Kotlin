package bronze

// - 문제 |  A B C 를 각각 수와 문자열로 생각했을 때 A + B - C를 출력

// - 입력 | 첫줄에는 정수 A 둘째 줄에는 정수 B 셋째줄에는 정수 C

// - 출력 | 첫줄에는 A + B - C 를 출력
//          둘째 줄에는 A , B , C 를 문자열로 생각했을 때 A + B = C를 출력

fun main() {
    val A = readln()
    val B = readln()
    val C = readln()
    println(A.toInt() + B.toInt() - C.toInt())
    val combinedAB = (A + B).toLong()
    println(combinedAB - C.toLong())

}