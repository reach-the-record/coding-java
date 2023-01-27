package velog.reachtherecord.codingjava;
import java.util.Arrays;

public class TriangleTwo {

    /**
     * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
     * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
     * 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
     * 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.
     *
     * sides의 원소는 자연수입니다.
     * sides의 길이는 2입니다.
     * 1 ≤ sides의 원소 ≤ 1,000
     */
    class Solution {
        public int solution(int[] sides) {
            int answer = 0;
            sides = Arrays.stream(sides).sorted().toArray();    //배열로 넘어온 값을 순차로 정렬
            int a = sides[0];   //가장 작은 값과 두번째로 작은 값을 할당
            int b = sides[1];

            for (int i = 1; i <= b; i++) {  //b가 가장 큰 변이 되기 위해서 최소 b보다 작거나 같을때까지 반복해서 조건을 만족하는 값만큼 더한다.
                if (i + a > b) {
                    answer++;
                }
            }

            for (int i = b + 1; i < a + b; i++) {   //나머지 값이 가장 큰 값일 경우만큼 반복하여 조건을 만족하는 만큼 더한다.
                if (i < a + b) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
