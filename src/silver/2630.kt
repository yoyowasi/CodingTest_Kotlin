package silver

import java.util.StringTokenizer

// - 문제 | 아래 <그림 1>과 같이 여러개의 정사각형칸들로 이루어진 정사각형 모양의 종이가 주어져 있고, 각 정사각형들은 하얀색으로 칠해져 있거나 파란색으로 칠해져 있다.
//          주어진 종이를 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 색종이를 만들려고 한다.
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

// 재귀함수를 사용하기 위해서 전역번수에 흰색 파란색 선언
// 종이의 사이즈 2차원배열도 미리 선언이지만 lateinit을 사용해서 나중에 초기화를 받도록 함
var white = 0
var blue = 0
lateinit var paper: Array<IntArray>

fun main() {
//    빠른 입력을 위한 버퍼리더
    val br = System.`in`.bufferedReader()
//    전체 종이의 한변의 길이인 N을 받는다
    val N = br.readLine().toInt()
//     정사각형이니 종이의 사이는 N * N 을 한다
    paper = Array(N) { IntArray(N) }
//      종이의 배열을 끝까지 돌기위해 이중 for문을 사용하는데 주어진 숫자를 받아서 바로 배열에 넣어준다
    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            paper[i][j] = st.nextToken().toInt()
        }
    }
//    파티션이라는 함수에 0,0, N이라는 값을 넣어준다
    partition(0, 0, N)
//      흰색과 파란색을 출력한다
    println(white)
    println(blue)
}
//      함수 파티션을 정의하고 row 와 col 와 size를 선언하고 타입을 지정하여 준다
fun partition(row: Int, col: Int, size: Int) {
//      checkColor라는 함수를 호출을 한다
    if (checkColor(row, col, size)) {
        if (paper[row][col] == 0) {
            white++
        } else {
            blue++
        }
//        리턴해줘서 함수 끝
        return
    }
// 새로운 사이즈를 선언해준다 이것은 size / 2 한 값이다
    val newSize = size / 2
//    파티션으로 다시 재귀함수를 돌린다
    partition(row, col, newSize)
    partition(row, col + newSize, newSize)
    partition(row + newSize, col, newSize)
    partition(row + newSize, col + newSize, newSize)
}
//      색상을 확인하는 함수를 선언해준다 반환값은 Bool이다
fun checkColor(row: Int, col: Int, size: Int): Boolean {
//    color는 종이의 row col 배열안에있는 값이다
    val color = paper[row][col]
//      i를 row 부터 row + size -1 까지 반복을 한다
    for (i in row until row + size) {
//        j를 col 부터 row + size -1 까지 반복을 한다
        for (j in col until col + size) {
//            만약 종이의 배열의 값이 color가 아닐경우 false를 반환한다
            if (paper[i][j] != color) {
                return false
            }
        }
    }
//    아니라면 true를 반환한다
    return true
}