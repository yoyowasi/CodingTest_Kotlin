package bronze

// - 문제 |UOS 문자열이란 UOSUOSUOSU...와 같이 UOS가 무한히 반복되어 나타나는 문자열이다. 양의 정수
//$x$가 주어질 때 UOS 문자열의
//$x$번째 문자를 구하여라.

// - 입력 | 첫 번째 줄에
//$x$가 주어진다.
//$(1 \leq x \leq 10^9)$ 

// - 출력 | UOS 문자열의
//$x$번째 문자를 출력한다

fun main() {
    val x = readln().toInt()
    val st = "SUO"
    println(st[x % st.length])

}