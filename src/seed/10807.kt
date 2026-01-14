package seed

fun main(){
    val n = readln().toInt()
    val st = readln().split(" ").map { it.toInt() }
    val v = readln().toInt()

    println(st.count { it == v })
}