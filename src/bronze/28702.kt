package bronze

import java.io.BufferedReader
import java.io.InputStreamReader

// - 문제 | FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열이 주어집니다. 이때, 이 세 문자열 다음에 올 문자열은 무엇일까요?

// - 입력 | FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열이 한 줄에 하나씩 주어집니다. 각 문자열의 길이는
//          8 이하입니다. 입력이 항상 FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열에 대응됨이 보장됩니다.

// - 출력 | 연속으로 출력된 세 개의 문자열 다음에 올 문자열을 출력하세요. 여러 문자열이 올 수 있는 경우, 아무거나 하나 출력하세요.

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val s1 = br.readLine()
    val s2 = br.readLine()
    val s3 = br.readLine()

    var nextValue = 0

    if (s1.all { it.isDigit() }) {
        nextValue = s1.toInt() + 3
    }
    else if (s2.all { it.isDigit() }) {
        nextValue = s2.toInt() + 2
    }
    else if (s3.all { it.isDigit() }) {
        nextValue = s3.toInt() + 1
    }

    if (nextValue % 3 == 0 && nextValue % 5 == 0) {
        println("FizzBuzz")
    } else if (nextValue % 3 == 0) {
        println("Fizz")
    } else if (nextValue % 5 == 0) {
        println("Buzz")
    } else {
        println(nextValue)
    }
}