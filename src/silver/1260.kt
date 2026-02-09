package silver

import java.io.BufferedReader
import java.io.InputStreamReader

// - 문제 | 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
//      단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

// - 입력 | 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
//      다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

// - 출력 | 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
//    공백기준으로 n, m, v 의 값을 받음
    val (n, m, v) = br.readLine().split(" ").map(String::toInt)
//    사이즈가 n + 1 이고 배열 [0]은 버리고 1부터 쓰기 위해서
    val graph = Array(n + 1) { mutableListOf<Int>() }
//      m만큼 반복하고 숫자 ab 를 받아서 양쪽에 넣어줌
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map(String::toInt)
        graph[a].add(b)
        graph[b].add(a)
    }
    graph.forEach { it.sort() }

    val dfsVisited = BooleanArray(n + 1)
    val bfsVisited = BooleanArray(n + 1)

    val dfsResult = mutableListOf<Int>()
    val bfsResult = mutableListOf<Int>()

    fun dfs(cur: Int) {
        dfsVisited[cur] = true
        dfsResult += cur
        for (next in graph[cur]) {
            if (!dfsVisited[next]) {
                dfs(next)
            }
        }
    }

    fun bfs(start: Int) {
        val q = ArrayDeque<Int>()

        q += start
        bfsVisited[start] = true

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            bfsResult += cur
            for (next in graph[cur]) {
                if (!bfsVisited[next]) {
                    bfsVisited[next] = true
                    q += next
                }
            }
        }
    }

    dfs(v)
    bfs(v)

    println(dfsResult.joinToString(" "))
    println(bfsResult.joinToString(" "))
}