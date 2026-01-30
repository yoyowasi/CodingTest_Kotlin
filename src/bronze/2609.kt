package bronze

// - 문제 | 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

// - 입력 | 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

// - 출력 | 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

fun main() {
    val (A, B) = readln().split(" ").map { it.toInt() }
    val num = if (A < B) A else B
//    숫자를 받아서 A가 B보다 작으면 A 아니면 B
    var max = 0
//    최대값 선언해주고
    for (i in num downTo 1) {
//        i 는 A or B에서 1까지 반복
        if (A % i == 0 && B % i == 0) {
//            만약 A 와 B가 i라는 값으로 나누어 떨어지면
            max = i
//            그것이 최대공약수
            break
//            더 반복할이유가 없음
        }
    }
    val min = (A * B) / max
//    최소공배수는 A * B / 최대공약수 하면 말그대로 최소공배숫가나옴

    println(max)
    println(min)
}