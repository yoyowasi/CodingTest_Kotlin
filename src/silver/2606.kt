package silver

import java.io.BufferedReader
import java.io.InputStreamReader

// - 문제 | 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
//      예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는
//       웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
//      어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
// - 입력 | 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
//      둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

// - 출력 | 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

fun main() {
//        값을 받는 부분
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
//      그래프를 만들어주는데 배열의 사이즈는 N + 1 이고 수정가능한 리스트
    val graph = Array(n + 1) { mutableListOf<Int>() }
//    n의 값만큼 반복
    repeat(m) {
//    쌍으로된 숫자를 공백기준으로 받음
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
//        그래프 배열의 a자리에 b값을 넣음
        graph[a].add(b)
//        그래프 배열의 b자리에 a값을 넣음
        graph[b].add(a)
    }

//  방문횟수를 불리언배열로 만듬
    val visited = BooleanArray(n + 1)
//    횟수를 세는 변수 선언
    var count = 0
// 함수 dfs를 선언
    fun dfs(now: Int) {
//        vistied의 배열의 now값은 true이다
        visited[now] = true
//    그래프의 배열을 처음부터 끝까지 반복
        for (next in graph[now]) {
//            만약 visited가 false면
            if (!visited[next]) {
//                카운트 + 1
                count++
//                dfs로 재귀
                dfs(next)
            }
        }
    }
//   dfs에 1값을 넣어서 사용
    dfs(1)
    println(count)
}
