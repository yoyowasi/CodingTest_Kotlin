package bronze

import java.math.BigInteger

// - 문제 | 은하는 수업 때 1부터 N까지 수의 합과 1부터 N까지 수의 세제곱의 합과 관련된 다음 공식을 배웠습니다.

// - 입력 | 첫 줄에 문제의 정수 N이 주어집니다

// - 출력 | 첫 줄에는 1부터 N까지 수의 합 1+2+....+N을 출력하세요.
//      둘째 줄에는 1$부터 N$까지 수의 합을 제곱한 수 (1+2+....+N)^2을 출력하세요.
//      셋째 줄에는 1$부터 N$까지 수의 세제곱의 합 1^3+2^3+...+N^3$을 출력하세요.

fun main() {
    val N = readln().toBigInteger()
    val sum = N.multiply(N.add(BigInteger.ONE)).divide(BigInteger.valueOf(2))

    val sumTwo = sum.multiply(sum)

    val sumThree = sumTwo
    println(sum)
    println(sumTwo)
    println(sumThree)


}