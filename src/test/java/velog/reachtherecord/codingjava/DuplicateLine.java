package velog.reachtherecord.codingjava;

import java.util.Map;
import java.util.HashMap;

public class DuplicateLine {

    /**
     * 선분 3개가 평행하게 놓여 있습니다. 세 선분의 시작과 끝 좌표가
     * [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때,
     * 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
     * lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.
     * 선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 길이 2만큼 겹쳐있습니다.
     *
     * lines의 길이 = 3
     * lines의 원소의 길이 = 2
     * 모든 선분은 길이가 1 이상입니다.
     * lines의 원소는 [a, b] 형태이며, a, b는 각각 선분의 양 끝점 입니다.
     * -100 ≤ a < b ≤ 100
     */
    class Solution {
        public int solution(int[][] lines) {
            int answer = 0;
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < lines.length; i++) {
                for (int j = lines[i][0]; j < lines[i][1]; j++) {   //선분의 길이만큼 반복
                    String key = String.valueOf(j) + String.valueOf(j+1); //맵에 저장하기 위한 키 값
                    map.put(key, map.getOrDefault(key, 0) + 1); //맵에 저장된 값이 있을 경우 +1, 아닐경우 1 저장
                }
            }

            for (String key : map.keySet()) { //맵 키셋 반복
                if (map.get(key) > 1) { //값이 1이상인 경우 겹친 선분이므로 answer + 1
                    answer++;
                }
            }

            return answer;
        }
    }
}
