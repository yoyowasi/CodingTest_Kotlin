package bronze

// - 문제 |

// - 입력 |

// - 출력 |

fun main() {
    val T= readln().toInt()
    var x = 1
    repeat(T){
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        val sum = a + b
        println("Case $x: $sum")
        x++
    }

}