package bronze

// - 문제 |

// - 입력 |

// - 출력 |

fun main() {
    val standard = intArrayOf(1, 1, 2, 2, 2, 8)

    val found = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    for (i in standard.indices) {
        print("${standard[i] - found[i]} ")
    }
}