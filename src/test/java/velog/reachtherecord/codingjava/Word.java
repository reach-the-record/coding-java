package velog.reachtherecord.codingjava;
import java.util.Arrays;

/*
 * 문자열 s가 매개변수로 주어집니다. s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return하도록 solution 함수를 완성해보세요.
 * 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
 * */

public class Word {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(); //stream 내에서  String을 저장할 StringBuilder 선언
        String answer = "";
        String[] sArr = s.split(""); //입력받은 String을 글자 단위로 쪼개서 배열로 변환
        for (int i = 0; i < sArr.length; i++) {
            String str = s.substring(i, i+1); //입력받은 문자열을 글자 하나씩 추출
            int cnt = 0;
            for (int j = 0; j < sArr.length; j++) {
                if (str.equals(sArr[j])) { //쪼개서 담아 둔 배열을 돌아 전체적으로 같은 글자가 있는지 비교.
                    cnt++;
                }
            }
            if (cnt == 1) {
                answer += str; //1회만 나온 경우 문자열에 추가
            }
        }
        Arrays.stream(answer.split("")).sorted().forEach(t -> sb.append(t)); //문자열을 쪼개서 배열로 만들어 소팅한 뒤 StringBuilder에 추가

        return sb.toString();
    }
}