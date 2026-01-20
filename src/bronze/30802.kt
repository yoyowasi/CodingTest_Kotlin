package bronze

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// - 문제 | 티셔츠는 S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈가 있습니다. 티셔츠는 같은 사이즈의 T 장 묶음으로만 주문할 수 있습니다
//      펜은 한 종류로,  P 자루씩 묶음으로 주문하거나 한 자루씩 주문할 수 있습니다

// - 입력 |

// - 출력 | 첫 줄에 티셔츠를 T 장씩 최소 몇 묶음 주문해야 하는지 출력하세요.
//      다음 줄에 펜을 P 자루씩 최대 몇 묶음 주문할 수 있는지와, 그 때 펜을 한 자루씩 몇 개 주문하는지 구하세요.

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val st = StringTokenizer(readLine())

    val sizes = IntArray(6) { st.nextToken().toInt() }

    val st2 = StringTokenizer(readLine())
    val t = st2.nextToken().toInt()
    val p = st2.nextToken().toInt()

    println(sizes.sumOf { (it + t - 1) / t })

    println("${n / p} ${n % p}")
}