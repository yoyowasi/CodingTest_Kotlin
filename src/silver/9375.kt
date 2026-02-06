package silver

import java.io.BufferedReader
import java.io.InputStreamReader

// - 문제 | 해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
//      예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경 대신 렌즈를 착용하거나 해야 한다.
//      해빈이가 가진 의상들이 주어졌을 때, 과연 해빈이는 알몸이 아닌 상태로 며칠 동안 밖에 돌아다닐 수 있을까?
//
// - 입력 | 첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.
//      각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
//      다음 n개 줄에는 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다.
//      같은 종류의 의상은 하나만 입을 수 있다.
//      같은 이름을 가진 의상은 존재하지 않는다.
//
// - 출력 | 각 테스트 케이스에 대해
//      해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우의 수를 출력한다.

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
//  테스트 케이스 개수 입력
    val T = br.readLine().toInt()
//  테스트 케이스 개수만큼 반복
    repeat(T) {
//      의상 수 입력
        val wear = br.readLine().toInt()
//      종류별로 저장할 map 생성
        val map = HashMap<String, Int>()
//      wear만큼 반복
        repeat(wear) {
//          공백 기준으로 name과 kind를 나눠서 받음
            val (name, kind) = br.readLine().split(" ")
//          kind의 개수를 1 증가 (없으면 0에서 시작)
            map[kind] = (map[kind] ?: 0) + 1
        }
//      곱셈이니까 1로 시작
        var result = 1
//      각 종류마다 (value값 + 벗었을때 1개)를 곱해 줌
        for (i in map.values) {
            result *= (i + 1)
        }
//      알몸 1가지를 빼고 출력
        println(result - 1)
    }
}
