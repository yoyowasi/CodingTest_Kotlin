package bronze

// - 문제 |

// - 입력 |

// - 출력 | 형진이의 노트북으로 대회에 참가하기 위해 형진이가 백준 1001번 문제를 푸는 데까지 필요한 최대 시간을 초 단위로 출력한다.

fun main() {
    val (T1, T2) = readLine()!!.split(" ").map { it.toInt() }
    println(minOf(T1, T2))

}