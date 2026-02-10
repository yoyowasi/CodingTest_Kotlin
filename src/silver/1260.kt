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

    // 공백 기준으로 잘라서 n(정점), m(간선), v(시작점) 값을 받음
    val (n, m, v) = br.readLine().split(" ").map(String::toInt)

    // [중요] 정점 번호가 1번부터 시작하므로, 인덱스를 맞추기 위해 크기를 n + 1로 설정 (0번 인덱스는 버림)
    val graph = Array(n + 1) { mutableListOf<Int>() }

    // m번 반복하면서 간선 정보(a, b)를 받아서 양쪽 리스트에 모두 추가 (양방향 그래프니까!)
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map(String::toInt)
        graph[a].add(b)
        graph[b].add(a)
    }

    // [문제 조건] 방문할 수 있는 정점이 여러 개면 "작은 번호"부터 가야 하므로 정렬 필수
    graph.forEach { it.sort() }

    // 방문 여부를 체크할 배열 (True: 방문함, False: 아직 안 감)
    val dfsVisited = BooleanArray(n + 1)
    val bfsVisited = BooleanArray(n + 1)

    // 방문한 정점 번호를 순서대로 "기록"할 리스트 (결과 출력용)
    val dfsResult = mutableListOf<Int>()
    val bfsResult = mutableListOf<Int>()

    // DFS 함수 (재귀 구조)
    fun dfs(cur: Int) {
        // 현재 위치(cur) 방문 처리 (도장 쾅!)
        dfsVisited[cur] = true

        // [수정] cur 값을 더하는 게 아니라, 결과 리스트에 '추가'하는 것
        dfsResult += cur

        // 현재 정점(cur)과 연결된 친구들(next)을 하나씩 확인
        for (next in graph[cur]) {
            // [수정] 0이 아니라면(X) -> 아직 방문하지 않았다면(False라면) (O)
            if (!dfsVisited[next]) {
                // 더 깊이 들어간다 (재귀 호출)
                dfs(next)
            }
        }
    }

    // BFS 함수 (큐 구조)
    fun bfs(start: Int) {
        // 대기열(큐) 생성
        val q = ArrayDeque<Int>()

        // [수정] 큐에 시작점을 '넣음' (더하기 아님)
        q += start

        // 시작점 방문 처리
        bfsVisited[start] = true

        // 큐에 대기 중인 정점이 있는 동안 계속 반복
        while (q.isNotEmpty()) {
            // [수정] 큐의 맨 앞(First) 값을 꺼내옴 (삭제하면서 가져옴)
            val cur = q.removeFirst()

            // [수정] 결과 리스트에 꺼내온 정점을 '추가' (삭제 아님)
            bfsResult += cur

            // 현재 정점(cur)과 연결된 친구들 확인
            for (next in graph[cur]) {
                // [수정] 아직 방문하지 않았다면 (False라면)
                if (!bfsVisited[next]) {
                    // 큐에 넣을 때 미리 방문 처리 (중복 방지)
                    bfsVisited[next] = true
                    // 큐에 줄 세우기 (추가)
                    q += next
                }
            }
        }
    }

    // 탐색 시작
    dfs(v)
    bfs(v)

    // 리스트에 담긴 정점들을 공백으로 연결해서 예쁘게 출력
    println(dfsResult.joinToString(" "))
    println(bfsResult.joinToString(" "))
}