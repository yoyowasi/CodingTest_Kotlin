package bronze

import java.io.BufferedReader
import java.io.InputStreamReader

// - 문제 | 화은이는 제3회 SMUPC를 맞이하여 환영의 의미로 "WelcomeToSMUPC"가 반복적으로 적혀 있는 라벨지를 프린트했다.
//       라벨지에는 공백 없이 글자들이 이어져 있고 "WelcomeToSMUPC"의 마지막 글자인 C 이후에는 W부터 다시 "WelcomeToSMUPC"가 반복된다.
//       N번째 글자가 있는 곳까지 라벨지를 자르려 할 때,
//       N번째에는 어떤 글자가 있을지 구해보자.

// - 입력 |

// - 출력 | 첫째 줄에 N번째에 해당하는 글자를 출력한다.

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val label = "WelcomeToSMUPC"
    val N = br.readLine()!!.toInt()
    val idx = (N - 1) % label.length
    println(label[idx])
}