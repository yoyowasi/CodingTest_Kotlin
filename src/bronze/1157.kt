package bronze

/**
 * 문제: 가장 많이 사용된 알파벳 찾기 (대소문자 구분 X)
 * 전략: 모든 문자를 대문자로 통일 -> 빈도수 계산 -> 최댓값 확인 -> 중복 여부 판단
 */

fun main() {
    // 1. 입력받은 문자열을 모두 대문자로 변환 (문제 조건: 구분하지 않음)
    readln().uppercase()
        // 2. 각 문자별로 그룹을 만들고 개수를 세어 Map<Char, Int> 형태로 반환
        // 예: "AABBCC" -> {A=2, B=2, C=2}
        .groupingBy { it }.eachCount()
        // 3. 계산된 Map을 'counts'라는 이름으로 받아와서 내부 로직 처리
        .let { counts ->
            // 4. Map의 값(Value)들 중 가장 큰 숫자(최대 빈도수)를 찾음
            val max = counts.values.maxOrNull()

            // 5. 빈도수가 'max'와 일치하는 키(알파벳)들만 필터링해서 추출
            counts.filterValues { it == max }.keys.let {
                // 6. 결과 알파벳이 2개 이상이면 "?", 1개면 해당 알파벳 출력
                println(if (it.size > 1) "?" else it.first())
            }
        }
}