package velog.reachtherecord.codingjava;
import java.util.Arrays;

public class PlusPolynomial {
    /** 다항식 더하기
     * 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다.
     * 다항식을 계산할 때는 동류항끼리 계산해 정리합니다.
     * 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때,
     * 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요.
     * 같은 식이라면 가장 짧은 수식을 return 합니다.
     *
     * 0 < polynomial에 있는 수 < 100
     * polynomial에 변수는 'x'만 존재합니다.
     * polynomial은 0부터 9까지의 정수, 공백, ‘x’, ‘+'로 이루어져 있습니다.
     * 항과 연산기호 사이에는 항상 공백이 존재합니다.
     * 공백은 연속되지 않으며 시작이나 끝에는 공백이 없습니다.
     * 하나의 항에서 변수가 숫자 앞에 오는 경우는 없습니다.
     * " + 3xx + + x7 + "와 같은 잘못된 입력은 주어지지 않습니다.
     * "012x + 001"처럼 0을 제외하고는 0으로 시작하는 수는 없습니다.
     * 문자와 숫자 사이의 곱하기는 생략합니다.
     * polynomial에는 일차 항과 상수항만 존재합니다.
     * 계수 1은 생략합니다.
     * 결괏값에 상수항은 마지막에 둡니다.
     * 0 < polynomial의 길이 < 50
     */
    class Solution {
        public String solution(String polynomial) {
            String answer = "";
            String[] arr = polynomial.split(" ");   //다항식 문자열을 공백문자 기준 배열로 분리
            arr = Arrays.stream(arr).filter(s -> !s.equals("+")).toArray(String[]::new);    //덧셈으로 이루어진 다항식이므로 + 문자는 filtering
            int x = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].indexOf("x") > -1) { //x가 있는 경우
                    if (arr[i].indexOf("x") > 0) {//x가 맨 앞에 없을 경우 x 앞에 있는 수를 따로 저장
                        x += Integer.valueOf(arr[i].substring(0, arr[i].length() - 1));
                    } else {
                        x++;
                    }
                }
            }
            int b = Arrays.stream(arr).filter(s -> s.indexOf("x") == -1).mapToInt(Integer::valueOf).sum();  //x가 들어있지 않은 항만 sum

            if (x == 0 && b == 0) { //x값도 없고 정수의 합도 0일 경우 0 반환
                return "0";
            }

            if (x > 1) {    //x가 1 이상일 경우 x값 설정
                answer += String.valueOf(x);
            }
            if (x > 0) {
                answer += "x";
            }

            if (b > 0) {    //정수항이 0 이상이고 x값이 있을 경우 + 추가
                if (x > 0) {
                    answer += " + ";
                }
                answer += String.valueOf(b);
            }

            return answer;
        }
    }
}
