package bronze

// - 문제 |

// - 입력 |

// - 출력 |

fun main() {
    val ori = "SciComLove"
    var count = 0
    val input = readLine()!!.toString()
    for ( i in 0 until input.length){
        if (input[i] != ori[i]){
            count++
        }
    }
    println(count)

}