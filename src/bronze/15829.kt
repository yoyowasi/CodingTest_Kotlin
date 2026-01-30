package bronze

import java.math.BigInteger

// - 문제 |

// - 입력 | 첫 줄에는 문자열의 길이 L이 들어온다. 둘째 줄에는 영문 소문자로만 이루어진 문자열이 들어온다.
//          입력으로 주어지는 문자열은 모두 알파벳 소문자로만 구성되어 있다.

// - 출력 | 문제에서 주어진 해시함수와 입력으로 주어진 문자열을 사용해 계산한 해시 값을 정수로 출력한다.

fun main() {
    val L = readln().toInt()
    val S = readln()
    val M = BigInteger("1234567891")
    val r = BigInteger("31")

    var sum = BigInteger.ZERO
    var power = BigInteger.ONE

    for (i in 0 until L) {
        val charNu = (S[i] - 'a' + 1).toLong()
        val term = BigInteger.valueOf(charNu).multiply(power)
        sum = sum.add(term)
        power = power.multiply(r).remainder(M)
    }
    println(sum.remainder(M))
}