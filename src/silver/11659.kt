package silver

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.log

// - 문제 | 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

// - 입력 | 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다.
//      수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

// - 출력 | 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
//    N과 M을 받음
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
//      nums를 받음
    val nums = br.readLine().split(" ").map { it.toInt() }
//    prefix라는 인트Array를 N + 1 크기만큼 받음
    val prefix = IntArray(N + 1)
//      i는 1부터 N 까지 반복
    for (i in 1..N) {
//        만든 배열의 i 부분은 i -1 이랑 nums i -1 이다
//        -1을 넣어주는 이유는 배열은 0부터 시작을 해서
        prefix[i] = prefix[i - 1] + nums[i - 1]
    }

    repeat(M) {
//         i랑 j값 받아옴
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
//        sum = j가 높은 숫자가 오기떄문에 뒤에 i -1 을 둔다 i -1 에서 -1 을 준 이유는 자기자신을 빼려고
        val sum = prefix[j] - prefix[i - 1]
        println(sum)
    }
}