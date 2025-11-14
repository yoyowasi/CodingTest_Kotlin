package seed

fun main(){
    val n = readln().toInt()
    for(i in 1 .. 9){
        val result = i * n
        println("${n} * $i = ${result}")
    }
}