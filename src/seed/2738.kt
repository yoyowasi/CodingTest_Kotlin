package seed

// - 문제 N*M 크기의 두 행렬 A와 B가 주어졌을때 두 행렬을 더하는 프로그램을 만들어야함

// - 입력 첫째 줄에 행렬의 크기 N, M 이 주어진다
// - 입력 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다, 이어서 N개의 줄에 B의 원소 M개 가 차례대로 주어짐
// - 조건 N, M은 <= 100 행렬의 원소는 <= 100

// - 출력 첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행령을 출력한다, 행렬의 각 원소는 공백으로 구분

fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
//    처음 N 과 M 을 입력받아서 int형식으로 배열에 넣어놓는다
    val numA = Array(n) {
        readln().split(" ").map { it.toInt() }.toIntArray()
    }
//   numA 라는 변수에 사이즈가 n인 배열을 만들고 그안에 int형식으로 저장한다
    val st = StringBuilder()
//    변수 st 로 스트링빌더를 선언
    repeat(n) { r ->
//        n의 개수만큼 반복을 함
        val rowB = readln().split(" ").map { it.toInt() }
//   rowB 라는 변수에 입력을 받아 int형식으로 저장한다
        repeat(m) { c ->
            val sum = numA[r][c] + rowB[c]
//            ex) 0, 1 | 0, 2  | 0, 3 | 이런식으로 기사시험에 많이 나오는 for 중첩문같이 사용
            st.append("$sum ")
//            계산된 값을 아까 만들어둔 스트링 빌더에 추가
        }
        st.append("\n")
//        끝나고 줄바꿈
    }
    println(st)
//    출력
}