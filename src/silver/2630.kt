package silver

import java.util.StringTokenizer

// - 문제 | 아래 <그림 1>과 같이 여러개의 정사각형칸들로 이루어진 정사각형 모양의 종이가 주어져 있고, 각 정사각형들은 하얀색으로 칠해져 있거나 파란색으로 칠해져 있다. 주어진 종이를 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 색종이를 만들려고 한다.
//          전체 종이의 크기가 N×N(N=2k, k는 1 이상 7 이하의 자연수) 이라면 종이를 자르는 규칙은 다음과 같다.
//          전체 종이가 모두 같은 색으로 칠해져 있지 않으면 가로와 세로로 중간 부분을 잘라서 <그림 2>의 I, II, III, IV와 같이 똑같은 크기의 네 개의 N/2 × N/2색종이로 나눈다.
//           나누어진 종이 I, II, III, IV 각각에 대해서도 앞에서와 마찬가지로 모두 같은 색으로 칠해져 있지 않으면 같은 방법으로 똑같은 크기의 네 개의 색종이로 나눈다.
//           이와 같은 과정을 잘라진 종이가 모두 하얀색 또는 모두 파란색으로 칠해져 있거나, 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지 반복한다.
//          위와 같은 규칙에 따라 잘랐을 때 <그림 3>은 <그림 1>의 종이를 처음 나눈 후의 상태를, <그림 4>는 두 번째 나눈 후의 상태를, <그림 5>는 최종적으로 만들어진
//           다양한 크기의 9장의 하얀색 색종이와 7장의 파란색 색종이를 보여주고 있다.
//          입력으로 주어진 종이의 한 변의 길이 N과 각 정사각형칸의 색(하얀색 또는 파란색)이 주어질 때 잘라진 하얀색 색종이와 파란색 색종이의 개수를 구하는 프로그램을 작성하시오.

// - 입력 | 첫째 줄에는 전체 종이의 한 변의 길이 N이 주어져 있다. N은 2, 4, 8, 16, 32, 64, 128 중 하나이다.
//      색종이의 각 가로줄의 정사각형칸들의 색이 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다.
//      하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어지며, 각 숫자 사이에는 빈칸이 하나씩 있다.

// - 출력 | 첫째 줄에는 잘라진 햐얀색 색종이의 개수를 출력하고, 둘째 줄에는 파란색 색종이의 개수를 출력한다.


// [전역 변수] 재귀 함수 안에서도 편하게 쓰기 위해 함수 밖에 선언했어.
var white = 0 // 하얀색 색종이 개수 저장
var blue = 0  // 파란색 색종이 개수 저장
lateinit var paper: Array<IntArray> // 종이 그림(0, 1)을 저장할 2차원 배열

fun main() {
    // 1. 빠른 입력을 위해 BufferedReader 사용
    val br = System.`in`.bufferedReader()

    // 첫 줄: 종이의 한 변의 길이 N 입력 받기
    val N = br.readLine().toInt()

    // 2. 종이 배열 초기화 (N x N 크기)
    paper = Array(N) { IntArray(N) }

    // 3. 종이 정보 입력 받기 (이중 반복문 대신, 한 줄씩 읽어서 채우기)
    for (i in 0 until N) {
        // 공백으로 구분된 숫자들을 효율적으로 자르기 위해 StringTokenizer 사용
        val st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            paper[i][j] = st.nextToken().toInt() // 0 또는 1 저장
        }
    }

    // 4. 분할 정복 시작! (가장 큰 종이 전체부터 시작하니까 0, 0, N)
    partition(0, 0, N)

    // 5. 정답 출력
    println(white)
    println(blue)
}

/**
 * 분할 정복을 수행하는 재귀 함수
 * @param row : 현재 종이의 시작 행(세로) 인덱스
 * @param col : 현재 종이의 시작 열(가로) 인덱스
 * @param size : 현재 종이의 한 변의 길이
 */
fun partition(row: Int, col: Int, size: Int) {

    // [1단계: 검사] 현재 자른 종이가 모두 같은 색인지 확인
    if (checkColor(row, col, size)) {
        // [성공 - Base Case]
        // 모두 같은 색이라면 더 이상 자를 필요 없음!
        // 해당 색깔의 카운트를 1 올리고 함수 종료 (return)
        if (paper[row][col] == 0) {
            white++ // 0이면 하얀색
        } else {
            blue++  // 1이면 파란색
        }
        return
    }

    // [2단계: 분할] 색이 섞여 있다면? 4등분 해야 함!
    val newSize = size / 2 // 길이를 절반으로 줄임

    // [3단계: 재귀 호출] 4개의 작은 사각형으로 나누어 다시 검사
    // 1사분면 (왼쪽 위)
    partition(row, col, newSize)
    // 2사분면 (오른쪽 위) -> 가로(col)로 newSize만큼 이동
    partition(row, col + newSize, newSize)
    // 3사분면 (왼쪽 아래) -> 세로(row)로 newSize만큼 이동
    partition(row + newSize, col, newSize)
    // 4사분면 (오른쪽 아래) -> 가로, 세로 둘 다 이동
    partition(row + newSize, col + newSize, newSize)
}

/**
 * 현재 영역이 모두 같은 색인지 확인하는 함수
 * @return true: 모두 같은 색, false: 섞여 있음
 */
fun checkColor(row: Int, col: Int, size: Int): Boolean {
    // 기준 색깔: 해당 영역의 가장 첫 번째 칸 (왼쪽 위)의 색
    val color = paper[row][col]

    // 영역 전체를 순회하면서 다른 색이 있는지 검사
    for (i in row until row + size) {
        for (j in col until col + size) {
            // 하나라도 기준 색과 다른 색이 나오면 즉시 실패(false) 리턴
            if (paper[i][j] != color) {
                return false
            }
        }
    }
    // 반복문을 무사히 통과했다면 모두 같은 색이라는 뜻!
    return true
}