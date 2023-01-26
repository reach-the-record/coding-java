package velog.reachtherecord.codingjava;

public class CalcString {
    /**
     * my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 문자열 my_string이 매개변수로 주어질 때, 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.
     *
     * 연산자는 +,-만 존재합니다.
     * 0으로 시작하는 숫자는 주어지지 않습니다.
     * 잘못된 수식은 주어지지 않습니다.
     * 5<= my_string의 길이 <= 100
     * my_string을 계산한 결과값은 1 이상 100,000 이하입니다.
     * my_string의 중간 계산 값은 -100,000 이상 100,000 이하입니다.
     * 계산에 사용하는 숫자는 1 이상 20,000 이하인 자연수입니다.
     * my_string에는 연산자가 적어도 하나 포함되어 있습니다.
     * return type 은 정수형입니다.
     * my_string의 숫자와 연산자는 공백 하나로 구분되어 있습니다.
     *
     */
    class Solution {
        public int solution(String my_string) {
            int answer = 0;
            String[] arr = my_string.split(" ");    // 공백으로 구분된 문자열을 나눠서 배열로 저장
            boolean isPlus = true;                        // 문자열에 포함된 기호가 +인지 확인
            answer += Integer.valueOf(arr[0]);            // 배열 첫번째는 무조건 숫자이므로 answer에 미리 더한다.
            for (int i = 1; i < arr.length; i++) {        // 2번째 항부터 반복
                if (i % 2 == 1) {                         // 2번째 항(인덱스는 홀수)은 무조건 부호이기 때문에 부호를 확인해서 저장
                    if (arr[i].equals("+")) {
                        isPlus = true;
                    } else {
                        isPlus = false;
                    }
                } else {                                  // 부호에 따라 값을 더하거나 뺀다.
                    if (isPlus) {
                        answer += Integer.valueOf(arr[i]);
                    } else {
                        answer -= Integer.valueOf(arr[i]);
                    }
                }
            }
            return answer;
        }
    }
}
