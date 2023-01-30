package velog.reachtherecord.codingjava;

public class UnusualArray {
    /**
     * 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다.
     * 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
     * 정수가 담긴 배열 numlist와 정수 n이 주어질 때
     * numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 1 ≤ n ≤ 10,000
     * 1 ≤ numlist의 원소 ≤ 10,000
     * 1 ≤ numlist의 길이 ≤ 100
     * numlist는 중복된 원소를 갖지 않습니다.
     */
    class Solution {
        public int[] solution(int[] numlist, int n) {
            int[] answer = new int[numlist.length];

            for (int i = 0; i < numlist.length; i++) {
                int rank = 1;
                int a = n - numlist[i]; //비교군 a 값 세팅
                for (int j = 0; j < numlist.length; j++) {
                    int b = n - numlist[j]; //비교군 b 값 세팅
                    if (i != j) {   //같은 값을 비교하지 않기 위해 i와 j가 다를 때만 실행
                        if (Math.abs(a) > Math.abs(b)) {    //절대값으로 차이 비교
                            rank++;
                        } else if (Math.abs(a) == Math.abs(b)) {    //절대값이 같은 경우 큰 수 먼저
                            if (a < b) {
                            } else {
                                rank++;
                            }
                        }
                    }
                }
                answer[rank - 1] = numlist[i];  //랭크에 인덱스 값으로 -1하여 배열에 등록
            }

            return answer;
        }
    }
}
