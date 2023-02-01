package velog.reachtherecord.codingjava;

public class SumConsecutiveNumber {
    /**
     * 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. 두 정수 num과 total이 주어집니다.
     * 연속된 수 num개를 더한 값이 total이 될 때, 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.
     *
     * 1 ≤ num ≤ 100
     * 0 ≤ total ≤ 1000
     * num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.
     */
    class Solution {
        public int[] solution(int num, int total) {
            int[] answer = new int[num];    //연속된 수를 담을 배열 생성

            int c = 0;
            int startNumber = 0;
            if (num % 2 == 1) { //num이 홀수일 경우
                c = total / num;    //센터값은 total / num
                startNumber = c - (num / 2);    //첫 수는 센터값에서 num을 2로 나눈 값을 뺀다.
            } else {
                c = ((total / (num / 2)) / 2);  //짝수일 경우 센터값 구하기
                startNumber = c - (num / 2) + 1;    //첫 수는 홀 수 구하기에 1을 더한 값
            }

            for (int i = 0; i < num; i++) { //num만큼 반복
                answer[i] = startNumber + i;    //시작 값 + i로 세팅
            }

            return answer;
        }
    }
}
