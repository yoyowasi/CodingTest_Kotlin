package seed

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val a = sc.nextInt()
    val b = sc.nextInt()
    if(a > 0 && b > 0){
        println(1)
    }else if(a < 0 && b > 0){
        println(2)
    }else if (a < 0 && b < 0){
        println(3)
    }else{
        println(4)
    }
}