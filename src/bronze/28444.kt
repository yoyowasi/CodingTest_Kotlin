package bronze

// - 문제 | HI-ARC 학회는 일상 속의 문장들을 수식으로 표현하는 것을 즐기는 특이한 문화를 가지고 있다.
//          HI-ARC 수식은 HI-ARC 학회에서 최근에 개발한 독특한 수식으로, 아래와 같은 규칙으로 계산한다.

// - 입력 |

// - 출력 | 수식을 계산한 결과값을 출력한다.

fun main() {
    val br = System.`in`.bufferedReader()
    val (H,I,A,R,C) = br.readLine().split(" ").map{ it.toInt() }
    val sum = H * I - A * R * C
    println(sum)

}