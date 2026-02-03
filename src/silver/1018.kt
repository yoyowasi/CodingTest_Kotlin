package silver

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

// - 문제 | 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
//       어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
//       체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고,
//       변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다.
//       하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
//       보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
//       당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

// - 입력 | 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
// 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

// - 출력 | 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.

fun main() {
    // 입력 처리를 위한 BufferedReader 선언
    val br = BufferedReader(InputStreamReader(System.`in`))

    // 첫 줄에서 공백을 기준으로 N(행)과 M(열)을 분리하고 정수로 변환하여 할당
    val (N, M) = br.readLine()!!.split(' ').map { it.toInt() }

    // N행 M열 크기의 2차원 문자 배열(보드) 생성
    val board = Array(N) { CharArray(M) }

    // 입력받은 문자열을 파싱하여 보드 배열 초기화
    for (i in 0 until N) {
        val line = br.readLine() // 한 줄씩 읽어옴
        for (j in 0 until M) {
            board[i][j] = line[j] // 각 문자를 2차원 배열에 저장
        }
    }

    // 갱신될 최솟값을 저장할 변수 (초기값은 비교를 위해 정수의 최댓값으로 설정)
    var answer = Int.MAX_VALUE

    // 8x8 크기로 자를 수 있는 모든 경우의 수를 탐색 (완전 탐색 / Brute Force)
    // sr: 잘라낼 체스판의 시작 행 (Start Row)
    for (sr in 0..N - 8) {
        // sc: 잘라낼 체스판의 시작 열 (Start Column)
        for (sc in 0..M - 8) {

            // 맨 왼쪽 위가 'W'(흰색)로 시작해야 하는 경우 다시 칠해야 할 개수
            var repaintW = 0
            // 맨 왼쪽 위가 'B'(검은색)로 시작해야 하는 경우 다시 칠해야 할 개수
            var repaintB = 0

            // 선택된 8x8 영역 내부를 순회하며 검사
            for (i in 0 until 8) {
                for (j in 0 until 8) {
                    // 현재 검사하려는 보드판의 실제 색상
                    val current = board[sr + i][sc + j]

                    // 체스판 로직: 행 인덱스와 열 인덱스의 합이 짝수인지 확인
                    // 합이 짝수인 칸끼리는 색이 같아야 하고, 홀수인 칸끼리도 색이 같아야 함
                    val even = (i + j) % 2 == 0

                    // 1. 맨 왼쪽 위가 흰색(W)이라고 가정했을 때의 정답 색상 계산
                    // (짝수 칸은 W여야 하고, 홀수 칸은 B여야 함)
                    val expectedW = if (even) 'W' else 'B'
                    if (current != expectedW) repaintW++ // 다르면 다시 칠하기 카운트 증가

                    // 2. 맨 왼쪽 위가 검은색(B)이라고 가정했을 때의 정답 색상 계산
                    // (짝수 칸은 B여야 하고, 홀수 칸은 W여야 함)
                    val expectedB = if (even) 'B' else 'W'
                    if (current != expectedB) repaintB++ // 다르면 다시 칠하기 카운트 증가
                }
            }

            // 두 가지 경우(W시작, B시작) 중 더 적게 칠하는 횟수와 현재까지의 최솟값을 비교하여 갱신
            answer = min(answer, min(repaintW, repaintB))
        }
    }

    // 최종적으로 구한 최솟값 출력
    println(answer)
}