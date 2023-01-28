package velog.reachtherecord.codingjava;
import java.util.Arrays;
import java.util.Collections;

public class Rank {
    /**
     * 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다.
     * 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때,
     * 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 0 ≤ score[0], score[1] ≤ 100
     * 1 ≤ score의 길이 ≤ 10
     * score의 원소 길이는 2입니다.
     * score는 중복된 원소를 갖지 않습니다.
     */
    class Solution {
        public int[] solution(int[][] score) {
            int[] answer = new int[score.length];
            int[] arr = new int[score.length];  //점수를 합산해서 담을 배열 생성

            for(int i = 0; i < score.length; i++) {
                arr[i] = score[i][0] + score[i][1];
            }

            arr = Arrays.stream(arr).boxed().distinct().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray(); //중복 점수를 제거한 배열 내림차순 정렬
            int rank = 1;
            for (int i = 0; i < arr.length; i++) {
                int count = 0;
                for (int j = 0; j < score.length; j++) {
                    if (arr[i] == (score[j][0] + score[j][1])) {    //점수 합산 배열로 합친 점수값 비교, 같은 점수가 있을 경우 count하여 다음 등수에 반영
                        answer[j] = rank;
                        count ++;
                    }
                }
                rank += count;
            }

            return answer;
        }
    }
}
