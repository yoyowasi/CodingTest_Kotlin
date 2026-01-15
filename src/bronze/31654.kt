package bronze

// - 문제 |

// - 입력 |

// - 출력 |

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    if (a + b == c) println("correct!") else println("wrong!")

}