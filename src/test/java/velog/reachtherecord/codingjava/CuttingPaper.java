package velog.reachtherecord.codingjava;

public class CuttingPaper {
    /**
     * 머쓱이는 큰 종이를 1 x 1 크기로 자르려고 합니다. 예를 들어 2 x 2 크기의 종이를 1 x 1 크기로 자르려면 최소 가위질 세 번이 필요합니다.
     * 정수 M, N이 매개변수로 주어질 때, M x N 크기의 종이를 최소로 가위질 해야하는 횟수를 return 하도록 solution 함수를 완성해보세요.
     *
     * 0 < M, N < 100
     * 종이를 겹쳐서 자를 수 없습니다.
     */
    class Solution {
        public int solution(int M, int N) {
            int answer = 0;
            int i = 1;  //N을 1로 만들어야하는 M의 개수를 위한 변수 추가
            int j = 0;  //N을 1로 만들 때 까지 필요한 횟수 추가
            while (M > 1) { //1만큼의 길이로 전부 자를 때 까지 반복하며 횟수 추가
                M--;
                answer++;
                i++;
            }
            while (N > 1) { //1만큼의 길이로 전부 자를 때까지 반복하며 횟수 추가.
                N--;
                j++;
            }
            answer += i * j; // M을 1로 만들기 위해 필요한 횟수(answer++) + N을 1로 만들기 위해 필요한 횟수 (i * j)
            return answer;
        }
    }
}
