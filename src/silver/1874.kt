package silver

import java.io.BufferedReader
import java.io.InputStreamReader

// - 문제 | 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
//       스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
//      1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
//       임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

// - 입력 | 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

// - 출력 | 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

//  스택만들어주고
    val stack = ArrayDeque<Int>()
//    스트링빌더로 나중에 한번에 출력
    val result = StringBuilder()
//    몇번이나 푸시를 할까의 척도
    var current = 1
//      n만큼 반복
    repeat(n) {
//        이 숫자에대해서 어떻게 하고싶은지 설정
        val target = br.readLine().toInt()
//      푸시의 척도를가 타겟과 같거나 작을때
        while (current <= target) {
//            스택에 마지막에  current값 삽입
            stack.addLast(current)
//            result에도 + \n 추가
            result.append("+\n")
//            current도 증가
            current++
        }

//        스택의 마지막이 타겟이랑 같으면
        if (stack.last() == target) {
//            스택의 마지막을 지우고
            stack.removeLast()
//            result에 - \n 추가
            result.append("-\n")
//            아닌경우
        } else {
//            NO 출력
            println("NO")
            return
        }
    }

    print(result)
}