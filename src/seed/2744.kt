package seed

// - 문제 | 영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.

// - 입력 | 첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.

// - 출력 | 첫째 줄에 입력으로 주어진 단어에서 대문자는 소문자로, 소문자는 대문자로 바꾼 단어를 출력한다.

fun main() {
    val N = readln().toCharArray()
//        입력을 받아서 배열로 정리
    repeat(N.size){
//        N의 사이즈만큼 반복문 실행
        if (N[it].isLowerCase()) N[it] = N[it].uppercaseChar()
//        만약 N에서 소문자였음 uppercaseChar 적용
        else N[it] = N[it].lowercaseChar()
//        그외 나머지 소문자가 아닌경우 lowercaseChar
    }
    println(N.joinToString(""))
//    N에 있는 배열 합쳐서 문자열로 출력


}