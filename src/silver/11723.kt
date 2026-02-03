package silver

import java.io.BufferedReader
import java.io.InputStreamReader

// - 문제 | 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
//      add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
//      remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
//      check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//      toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
//      all: S를 {1, 2, ..., 20} 으로 바꾼다.
//      empty: S를 공집합으로 바꾼다.

// - 입력 | 첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.
//      둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.

// - 출력 | check 연산이 주어질때마다, 결과를 출력한다.

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val M = br.readLine().toInt()
    val S = mutableSetOf<Int>()

    repeat(M){
        val input = br.readLine().split(" ")
        when (input[0]) {
            "add" -> S.add(input[1].toInt())
            "remove" -> S.remove(input[1].toInt())
            "check" -> sb.appendLine(if (input[1].toInt() in S) 1 else 0)
            "toggle" -> {
                val x = input[1].toInt()
                if (x in S) S.remove(x) else S.add(x)
            }
            "all" -> {
                S.clear()
                for (i in 1..20) S.add(i)
            }
            "empty" -> S.clear()
        }
    }

    print(sb)
}