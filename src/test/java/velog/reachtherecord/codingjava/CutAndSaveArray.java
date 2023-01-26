package velog.reachtherecord.codingjava;
public class CutAndSaveArray {

    /**
     * 문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution함수를 완성해주세요.
     *
     * 1 <= my_str의 길이 <= 100
     * 1 <= n <= my_str의 길이
     * my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.
     */
    class Solution {
        public String[] solution(String my_str, int n) {
            int idx = my_str.length() % n > 0 ? (my_str.length() / n) + 1 : my_str.length() / n;    //n으로 문자열을 나눠서 나머지가 있을 경우 배열길이 1 추가
            String[] answer = new String[idx];

            for (int i = 0; i < answer.length; i++) {   //선언한 배열만큼 문자열을 나눠서 저장
                if (my_str.length() < n) {
                    answer[i] = my_str;
                } else {
                    answer[i] = my_str.substring(0, n);
                    my_str = my_str.substring(n); //문자열을 저장한 뒤 저장이 끝난 문자열은 제거
                }
            }

            return answer;
        }
    }
}
