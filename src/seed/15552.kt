package seed

import java.util.StringTokenizer

fun main(){
    val reader = System.`in`.bufferedReader()
    val t = reader.readLine()?.toInt() ?: return

    val result = buildString{
        repeat(t){
            val st = StringTokenizer(reader.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()

            appendLine(a + b)
        }
    }
    print(result)

}