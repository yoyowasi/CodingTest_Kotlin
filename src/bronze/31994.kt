package bronze


// - 문제 |

// - 입력 |

// - 출력 |

fun main() {
    var maxPeople = 0
    var maxName = ""

    repeat(7) {
        val (name, people) = readLine()!!.split(" ")
        if (people.toInt() > maxPeople) {
            maxPeople = people.toInt()
            maxName = name
        }
    }
    println(maxName)

}