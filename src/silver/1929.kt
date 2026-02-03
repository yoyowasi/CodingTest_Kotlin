package silver

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

// - 문제 | M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

// - 입력 | 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

// - 출력 | 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

fun main() {
//    버퍼리더를 선언
    val br = BufferedReader(InputStreamReader(System.`in`))
//    M과 N값을 공백으로 구분하여 값을 받아옴
    val (M, N) = br.readLine().split(" ").map { it.toInt() }

//    참 거짓 배열을 N + 1 크기만큼 만들고 그안을 true로 채워
    val isPrime = BooleanArray(N + 1) { true }
//    배열의 0 과 1은 false값을 넣어줌
    isPrime[0] = false
    isPrime[1] = false
//      i는 2부터 N의 제곱근까지
//     제곱근을 사용한 이유는 큰수들의 배수는 이미 소수에서 제외 대상이기때문에
    for (i in 2..sqrt(N.toDouble()).toInt()) {
//        만약 불리언 배열의 i번쨰가 참이라면
        if (isPrime[i]) {
//            j는 i의 제곱
            var j = i * i
//            j는 N보다 작거나 같을때까지 반복
            while (j <= N) {
//                배열의 j번째에 false를 넣고
                isPrime[j] = false
//                j에 + i 을 해준다
                j += i
            }
        }
    }
//    i를 M 부터 N 까지 반복문을 돌리고
    for (i in M..N){
//        배열의 i번쨰 값이 참이면 i를 출력함
        if(isPrime[i]){
            println(i)
        }
    }

}