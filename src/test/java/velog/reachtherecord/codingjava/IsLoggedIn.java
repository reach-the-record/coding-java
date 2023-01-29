package velog.reachtherecord.codingjava;
import java.util.Arrays;

public class IsLoggedIn {
    /**
     * 머쓱이는 프로그래머스에 로그인하려고 합니다.
     * 머쓱이가 입력한 아이디와 패스워드가 담긴 배열 id_pw와 회원들의 정보가 담긴 2차원 배열 db가 주어질 때,
     * 다음과 같이 로그인 성공, 실패에 따른 메시지를 return하도록 solution 함수를 완성해주세요.
     *
     * 아이디와 비밀번호가 모두 일치하는 회원정보가 있으면 "login"을 return합니다.
     * 로그인이 실패했을 때 아이디가 일치하는 회원이 없다면 “fail”를,
     * 아이디는 일치하지만 비밀번호가 일치하는 회원이 없다면 “wrong pw”를 return 합니다.
     *
     * 회원들의 아이디는 문자열입니다.
     * 회원들의 아이디는 알파벳 소문자와 숫자로만 이루어져 있습니다.
     * 회원들의 패스워드는 숫자로 구성된 문자열입니다.
     * 회원들의 비밀번호는 같을 수 있지만 아이디는 같을 수 없습니다.
     * id_pw의 길이는 2입니다.
     * id_pw와 db의 원소는 [아이디, 패스워드] 형태입니다.
     * 1 ≤ 아이디의 길이 ≤ 15
     * 1 ≤ 비밀번호의 길이 ≤ 6
     * 1 ≤ db의 길이 ≤ 10
     * db의 원소의 길이는 2입니다.
     */
    class Solution {
        public String solution(String[] id_pw, String[][] db) {
            String answer = "";
            int[] results = new int[db.length]; //결과값을 저장할 배열 생성
            for (int i = 0; i < db.length; i++) {
                int a = 0;  //아이디/패스워드 비교값 저장할 변수 생성
                if (db[i][0].equals(id_pw[0])) {
                    a++;
                }
                if (a > 0 && db[i][1].equals(id_pw[1])) {
                    a++;
                }
                results[i] = a;
            }

            results = Arrays.stream(results).sorted().toArray();    //결과값 저장한 배열 소팅
            int result = results[results.length - 1];   //배열의 가장 마지막 값에 따라 로그인 여부 확인
            switch(result) {
                case 0:
                    answer = "fail";
                    break;
                case 1:
                    answer = "wrong pw";
                    break;
                case 2:
                    answer = "login";
                    break;
            }

            return answer;
        }
    }
}
