package velog.reachtherecord.codingjava;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
* 문자열 my_string이 매개변수로 주어집니다. my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. my_string 안의 자연수들의 합을
* return하도록 solution 함수를 완성해주세요.
* */
public class PlusHiddenNumber {
    public int solution(String my_string) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        String str = my_string.replaceAll("\\D", " "); //정규식으로 숫자이외의 모든 문자열을 공백으로 치환
        String[] arr = str.split(" "); //치환한 문자열을 공백 기준 배열로 변환
        answer = Arrays.stream(arr).filter(s -> !s.isEmpty()) // 변환한 배열을 stream으로 변환하여 비어있지 않은 문자열을 filtering한 뒤 int맵으로 변환하여 sum 처리
                .mapToInt(Integer::parseInt).sum();

        return answer;
    }
}