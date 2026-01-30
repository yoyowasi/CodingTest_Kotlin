package bronze

// - 문제 |

// - 입력 4개의 줄에 걸쳐 우경이가 각 바퀴를 뛰는 데 걸린 시간 t가 초 단위로 한 줄에 하나씩 주어진다.

// - 출력 |

fun main() {
    val t1 = readln().toInt()
    val t2 = readln().toInt()
    val t3 = readln().toInt()
    val t4 = readln().toInt()
    val sum = t1 + t2 + t3 +t4 + 300
    if (sum <= 1800) println("Yes") else println("No")

}