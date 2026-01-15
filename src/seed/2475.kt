package seed

// - 문제 | 고유번호의 처음 5자리에는 00000부터 99999까지의 수 중 하나가 주어지며 6번째 자리에는 검증수가 들어간다.
//  검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.

// - 입력 | 첫째 줄에 고유번호의 처음 5자리의 숫자들이 빈칸을 사이에 두고 하나씩 주어진다.

// - 출력 | 첫째 줄에 검증수를 출력한다.

fun main() {
    val num = readln().split(" ").map { it.toInt() }
    var sum = 0
    repeat(5){
        var serial: Int
        serial = num[it] * num[it]
        sum =+ sum + serial
    }
    println(sum % 10)
}