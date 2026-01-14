package seed

import java.util.StringTokenizer

fun main(){
    val (n, x) = readln().split(" ").map { it.toInt() }
    val st = StringTokenizer(readln())

    repeat(n){
        val num = st.nextToken().toInt()

        if (num < x){
            print("${num} ")
        }
    }



}