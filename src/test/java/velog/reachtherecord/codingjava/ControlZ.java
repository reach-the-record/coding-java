package velog.reachtherecord.codingjava;

public class ControlZ {
    /**
     * 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다.
     * 문자열에 있는 숫자를 차례대로 더하려고 합니다. 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다.
     * 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.
     *
     * 1 ≤ s의 길이 ≤ 200
     * -1,000 < s의 원소 중 숫자 < 1,000
     * s는 숫자, "Z", 공백으로 이루어져 있습니다.
     * s에 있는 숫자와 "Z"는 서로 공백으로 구분됩니다.
     * 연속된 공백은 주어지지 않습니다.
     * 0을 제외하고는 0으로 시작하는 숫자는 없습니다.
     * s는 "Z"로 시작하지 않습니다.
     * s의 시작과 끝에는 공백이 없습니다.
     * "Z"가 연속해서 나오는 경우는 없습니다.
     */
    class Solution {
        public int solution(String s) {
            int answer = 0;

            String[] arr = s.split(" "); // 공백으로 구분된 문자열을 배열로 분할
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("Z")) {   //해당 값이 Z일 경우 전에 나온 숫자를 빼고, 아닐 경우 더한다.
                    answer -= Integer.valueOf(arr[i - 1]);
                } else {
                    answer += Integer.valueOf(arr[i]);
                }
            }

            return answer;
        }
    }
}
