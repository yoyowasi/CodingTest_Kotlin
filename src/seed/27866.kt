package seed

// - 문제 | 단어 S와 정수 i가 주어졌을 때 , S의 i 번째 글자를 출력하는 프로그램을 작성하시오

// - 입력 | 첫째줄에 영어 소문자와 대문자로만 이루어진 단어 S가 주어진다, 단어의 길이는 최대 1000이다.
// - 입력 | 둘째 줄에 정수 i가 주어진다

// - 출력 | S 의 i번째 글자를 출력한다

fun main() {
    val s = readln().map { it }
    val i = readln().toInt()
    println(s[i-1])

}