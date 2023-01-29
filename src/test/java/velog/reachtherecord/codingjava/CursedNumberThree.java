package velog.reachtherecord.codingjava;

public class CursedNumberThree {
    /**
     * 3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다. 3x 마을 사람들의 숫자는 다음과 같습니다.
     *
     * 10진법	3x 마을에서 쓰는 숫자	10진법	3x 마을에서 쓰는 숫자
     * 1	1 |	6	8
     * 2	2 |	7	10
     * 3	4 |	8	11
     * 4	5 |	9	14
     * 5	7 |	10	16
     * 정수 n이 매개변수로 주어질 때, n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.
     *
     * 1 ≤ n ≤ 100
     */
    class Solution {
        public int solution(int n) {
            int[] arr = new int[100]; //n이 최대 100까지 이므로 100까지 배열을 생성
            int answer = 0;
            arr[0] = 1; //1의 값 세팅
            for (int i = 1; i < arr.length; i++) {
                int buffer = 1;
                boolean f = true;
                while(f) {
                    f = false;
                    int b = arr[i - 1] + buffer;    //이전 배열 값에 1을 더한다.
                    if (b % 3 == 0 || String.valueOf(b).indexOf("3") > -1) { //3의 배수와 숫자 3이 포함될 경우 버퍼값에 세팅하고 다시 확인한다.
                        buffer++;
                        f = true;
                    }
                }
                arr[i] = arr[i - 1] + buffer;   //배열에 세팅
            }

            return arr[n - 1];
        }
    }
}
