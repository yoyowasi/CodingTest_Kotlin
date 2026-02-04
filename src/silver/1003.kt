package silver

import java.io.BufferedReader
import java.io.InputStreamReader

// - 문제 | 다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.
//
//int fibonacci(int n) {
//    if (n == 0) {
//        printf("0");
//        return 0;
//    } else if (n == 1) {
//        printf("1");
//        return 1;
//    } else {
//        return fibonacci(n‐1) + fibonacci(n‐2);
//    }
//}
//      fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
//      fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
//      fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
//      두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
//      fibonacci(0)은 0을 출력하고, 0을 리턴한다.
//      fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
//      첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
//      fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
//      1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

// - 입력 | 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
//      각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

// - 출력 | 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

fun main() {
//    빠른 입력을 위한 버퍼리더
    val br = BufferedReader(InputStreamReader(System.`in`))
//    한번에 출력할수있게 StringBuilder 사용
    val sb = StringBuilder()
//    0 과 1 에 대한 숫자 배열 선언 최대값이 정해져있으니까
    val zero = IntArray(41)
    val one = IntArray(41)
//  반복문에 포함되지않는 예외사항 0이거나 1일떄 제외
    zero[0] = 1
    one[0] = 0
    zero[1] = 0
    one[1] = 1
//  0과1을 제외했으니 2부터 40까지 반복 시작
    for (i in 2..40) {
//        0의 [2] = 0[1] + 0[0]
//        추후에 받는 n 값이 이런식으로 들어간 데이터를 가지고 나오는것
        zero[i] = zero[i - 1] + zero[i - 2]
//        1의 [2] = 1[1] + 1[0]
        one[i] = one[i - 1] + one[i - 2]
    }

    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        sb.append(zero[n]).append(' ').append(one[n]).append('\n')
    }

    print(sb.toString())
}