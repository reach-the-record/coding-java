package velog.reachtherecord.codingjava;
import java.util.Arrays;

public class CalcRectangle {

    class Solution {
        /**
         * 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다.
         * 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때,
         * 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.
         *
         * dots의 길이 = 4
         * dots의 원소의 길이 = 2
         * -256 < dots[i]의 원소 < 256
         * 잘못된 입력은 주어지지 않습니다.
         *
         */
        public int solution(int[][] dots) {
            int answer = 0;
            int[] x = new int[dots.length]; //x좌표만 넣을 배열 추가
            int[] y = new int[dots.length]; //y좌표만 넣을 배열 추가

            for (int i = 0; i < dots.length; i++) { //각 배열에 좌표값 입력
                x[i] = dots[i][0];
                y[i] = dots[i][1];
            }

            x = Arrays.stream(x).distinct().sorted().toArray(); //같은 좌표값 제거, 소팅
            y = Arrays.stream(y).distinct().sorted().toArray();

            answer = (x[1] - x[0]) * (y[1] - y[0]); // (x2 - x1) * (y2 - y1)

            return answer;
        }
    }
}
