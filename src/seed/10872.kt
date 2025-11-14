package seed

fun main() {
    val n= readln().toInt()
    var i = 1
    for(a in 1 ..n ){
        i *= a
    }
    println(i)
}