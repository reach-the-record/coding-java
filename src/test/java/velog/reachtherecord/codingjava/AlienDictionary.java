package velog.reachtherecord.codingjava;
import java.util.Arrays;

public class AlienDictionary {

    /**
     * PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
     * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
     * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1,
     * 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * spell과 dic의 원소는 알파벳 소문자로만 이루어져있습니다.
     * 2 ≤ spell의 크기 ≤ 10
     * spell의 원소의 길이는 1입니다.
     * 1 ≤ dic의 크기 ≤ 10
     * 1 ≤ dic의 원소의 길이 ≤ 10
     * spell의 원소를 모두 사용해 단어를 만들어야 합니다.
     * spell의 원소를 모두 사용해 만들 수 있는 단어는 dic에 두 개 이상 존재하지 않습니다.
     * dic과 spell 모두 중복된 원소를 갖지 않습니다.
     */
    class Solution {
        public int solution(String[] spell, String[] dic) {
            int[] arr = new int[dic.length];    //dic만큼의 배열 생성 (dic 배열 안의 문자열 길이를 구하기 위함)
            for (int i = 0; i < dic.length; i++) {//dic 배열 안에 있는 문자열 값을 arr에 저장
                arr[i] = dic[i].length();
            }
            dic = Arrays.stream(dic).filter(s -> s.length() == spell.length).toArray(String[]::new);    //dic 배열 중에 spell의 개수와 일치하는 배열만 filtering
            for (int i = 0; i < dic.length; i++) {
                int cnt = 0;
                for (int j = 0; j < spell.length; j++) {    //dic 배열과 spell 배열의 문자열을 하나씩 비교해서 값이 있을 경우를 카운트한 후 spell 길이와 count가 같을 경우 1 리턴
                    if (dic[i].indexOf(spell[j]) > -1) {
                        cnt++;
                    } else {
                        break;
                    }
                    if (cnt == spell.length) {
                        return 1;
                    }
                }
            }

            return 2;
        }
    }
}
