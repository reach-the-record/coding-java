package velog.reachtherecord.codingjava;
import java.util.*;
public class FindMode {

    /**
     * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
     * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
     * 최빈값이 여러 개면 -1을 return 합니다.
     *
     * 0 < array의 길이 < 100
     * 0 ≤ array의 원소 < 1000
     */
    class Solution {
        public int solution(int[] array) {
            int answer = -1;
            int[] arr = Arrays.stream(array).distinct().sorted().toArray(); //중복된 값 제거 후 정렬하여 배열로 생성
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                int v = 0;
                for (int j = 0; j < array.length; j++) {
                    if (arr[i] == array[j]) {   //기존 배열과 중복제거한 배열을 비교하여 카운트를 맵에 저장
                        v++;
                    }
                }
                map.put(arr[i], v);
            }

            arr = map.values().stream()     //넣어둔 맵의 값을 내림차순으로 정렬하여 배열로 변환
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue).toArray();
            if (arr.length > 1 && arr[0] == arr[1]) {   //배열의 0,1 index 값이 같으면 -1 리턴, 아닐 경우 map의 키값이 0번 index와 같은 경우를 찾아 리턴
                return answer;
            } else {
                for (Integer key : map.keySet()) {
                    if (map.get(key) == arr[0]) {
                        return key;
                    }
                }
            }
            return answer;
        }
    }
}
