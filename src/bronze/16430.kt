package bronze

fun main(){
    val (A, B) = readLine()!!.split(" ").map { it.toInt() }
    println("${B - A} $B")
}