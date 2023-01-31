package velog.reachtherecord.codingjava;

public class NextNumber {
    /**
     * 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
     *
     * 2 < common의 길이 < 1,000
     * -1,000 < common의 원소 < 2,000
     * common의 원소는 모두 정수입니다.
     * 등차수열 혹은 등비수열이 아닌 경우는 없습니다.
     * 등비수열인 경우 공비는 0이 아닌 정수입니다.
     */
    class Solution {
        public int solution(int[] common) {
            int answer = 0;
            String kind = common[2] - common[1] == common[1] - common[0] ? "+" : "x";   //1,0 인덱스 차와 2,1 인덱스의 차가 같을 경우 등차수열/ 아닐경우 등비수열
            int v = 0;

            if (kind.equals("+")) {
                answer = common[common.length - 1] + (common[1] - common[0]);   //등차수열일 경우 1,0 인덱스 차 만큼 마지막 인덱스에 더한다.
            } else {
                answer = common[common.length - 1] * (common[1] / common[0]);   //등비수열일 경우 1,0인덱스 비 만큼 마지막 인덱스에 곱한다.
            }

            return answer;
        }
    }
}
