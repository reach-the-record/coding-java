package velog.reachtherecord.codingjava;
import java.util.*;
public class DeterminingFiniteDecimal {

    /**
     * 소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다.
     * 분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다.
     * 유한소수가 되기 위한 분수의 조건은 다음과 같습니다.
     * 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
     * 두 정수 a와 b가 매개변수로 주어질 때, a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * a, b는 정수
     * 0 < a ≤ 1,000
     * 0 < b ≤ 1,000
     */
    class Solution {
        public int solution(int a, int b) {
            int answer = 0;
            int c = 0;
            boolean f = true;
            while (f) {
                f = false;
                for (int i = 2; i <= (a > b ? b : a); i++) {    //2부터 a가 b보다 크면 b까지, 아니면 a까지 반복
                    if (a % i == 0 && b % i == 0) { //기약분수로 만들기 위해 i가 a와 b에 공통으로 나누어떨어지지 않을때까지 나눈다.
                        a /= i;
                        b /= i;
                        f = true;
                        break;
                    }
                }
            }
            f = true;
            List<Integer> list = new ArrayList<>();
            while (f) {
                f = false;
                for (int i = 2; i <= b; i++) {  //기약분수에서 분모 값을 나눠서 리스트에 저장
                    if (b % i == 0) {
                        b /= i;
                        list.add(i);
                        f = true;
                        break;
                    }
                }
            }

            answer = list.stream().distinct().filter(i -> i != 2 && i != 5).count() > 0 ? 2 : 1; //분모를 나눈 값에서 2와 5를 제외하고 다른 수가 있을 경우 무한소수.

            return answer;
        }
    }
}
