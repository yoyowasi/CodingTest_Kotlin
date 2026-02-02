package silver

// - 문제 | 상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
// 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
//상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만,
// 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
//상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.

// - 입력 | 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)

// - 출력 | 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.

fun main() {
//    N을 배달해야함 근데 봉지는 3키로랑  5키로짜리만 있음 최대효율을 뽑기위해 최대한 큰용량으로 가져가려고 함
    val N = readln().toInt()
//    N값을 받음
    var answer = Int.MAX_VALUE
//    봉지에 대한 상태 부여
    val maxFive = N / 5
//    N값에 대해서 5키로로 분할되는 최대 개수

    for (a in maxFive downTo 0) {
//        ex) N이 18이였다면  3부터 0까지
        val remain = N - 5 * a
//        remain 값을 지정
        if (remain % 3 == 0) {
//            remain을 3으로 나누었을때 나머지가 0이면
            val b = remain / 3
//            remain을 3으로 나눈 몫이 B
            val bags = a + b
//            bags = a + b
            if (bags < answer) {
//                bags가 answer보다 작으면
                answer = bags
//                answer = bags
            }
        }
    }
    if (answer == Int.MAX_VALUE) {
//        answer랑 Int.Max_VALUE랑 같으면 -1 출력
        println(-1)
    } else {
        println(answer)
    }


}