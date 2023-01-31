package velog.reachtherecord.codingjava;

public class NOCDivideBeads {

    /**
     * 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 구슬은 모두 다르게 생겼습니다.
     * 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때,
     * balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.
     *
     * 1 ≤ balls ≤ 30
     * 1 ≤ share ≤ 30
     * 구슬을 고르는 순서는 고려하지 않습니다.
     * share ≤ balls
     */
    class Solution {
        public int solution(int balls, int share) {
            Long answer = 1L;
            for (int i = 0; i < share; i++) {   //share번 반복
                answer = Long.valueOf(answer * balls / (i + 1));    //순서가 뒤로 갈 수록 1/n 개의 수가 생김
                balls--;
            }

            return Integer.valueOf(String.valueOf(answer));
        }
    }
}
