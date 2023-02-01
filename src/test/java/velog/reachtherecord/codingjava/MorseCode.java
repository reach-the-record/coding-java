package velog.reachtherecord.codingjava;
import java.util.Map;

import java.util.HashMap;
public class MorseCode {
    /**
     * 머쓱이는 친구에게 모스부호를 이용한 편지를 받았습니다. 그냥은 읽을 수 없어 이를 해독하는 프로그램을 만들려고 합니다.
     * 문자열 letter가 매개변수로 주어질 때, letter를 영어 소문자로 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 1 ≤ letter의 길이 ≤ 1,000
     * return값은 소문자입니다.
     * letter의 모스부호는 공백으로 나누어져 있습니다.
     * letter에 공백은 연속으로 두 개 이상 존재하지 않습니다.
     * 해독할 수 없는 편지는 주어지지 않습니다.
     * 편지의 시작과 끝에는 공백이 없습니다.
     */
    class Solution {
        public String solution(String letter) {
            Map<String, String> map = new HashMap<>();

            String[] morse = {
                    ".-:a","-...:b","-.-.:c","-..:d",".:e","..-.:f",
                    "--.:g","....:h","..:i",".---:j","-.-:k",".-..:l",
                    "--:m","-.:n","---:o",".--.:p","--.-:q",".-.:r",
                    "...:s","-:t","..-:u","...-:v",".--:w","-..-:x",
                    "-.--:y","--..:z"
            };  //모스부호값 배열 생성

            for(int i = 0; i < morse.length; i++) {
                String[] str = morse[i].split(":"); //구분값으로 부호와 알파벳 분할하여 맵에 저장
                map.put(str[0], str[1]);
            }
            String answer = "";
            String[] lArr = letter.split(" ");  //letter값을 공백 기준으로 배열로 변환
            for(int i = 0; i < lArr.length; i++) {
                answer += map.get(lArr[i]); //맵에서 키값인 부호로 알파벳 추가
            }
            return answer;
        }
    }
}
