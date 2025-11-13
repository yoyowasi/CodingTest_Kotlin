package seed

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val a = sc.nextInt()
    val b = sc.nextInt()
    val result: Double = a.toDouble() /b
    val formattedResult = String.format("%.9f", result)
    println(formattedResult)

}