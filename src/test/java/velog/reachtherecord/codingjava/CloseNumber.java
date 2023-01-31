package velog.reachtherecord.codingjava;
import java.util.Arrays;

public class CloseNumber {

    /**
     * 정수 배열 array와 정수 n이 매개변수로 주어질 때,
     * array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
     *
     * 1 ≤ array의 길이 ≤ 100
     * 1 ≤ array의 원소 ≤ 100
     * 1 ≤ n ≤ 100
     * 가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
     */
    class Solution {
        public int solution(int[] array, int n) {
            array = Arrays.stream(array).distinct().sorted().toArray(); //배열을 중복 제거하고, 오름차순 정렬
            int a = Math.abs(n - array[0]); //첫번째 수와 n의 절대차를 a로 생성
            int answer = array[0];
            for (int i = 1; i < array.length; i++) {
                if (a > Math.abs(n - array[i])) { //첫 항과 비교해가며 절대차가 작은 경우 answer값, a값 변경
                    a = Math.abs(n - array[i]);
                    answer = array[i];
                } else if (a == Math.abs(n - array[i])) { //a값과 절대차가 같을 경우 더 작은 수를 리턴해야 한다
                    if (n > array[i]) {     //n값과 array[i]값을 비교하여 적은 경우 answer값으로 변경
                        answer = array[i];
                        return answer;
                    } else {
                        return answer;
                    }
                }
            }

            return answer;
        }
    }
}
