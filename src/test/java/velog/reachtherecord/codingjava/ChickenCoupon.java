package velog.reachtherecord.codingjava;

public class ChickenCoupon {
    /**
     * 프로그래머스 치킨은 치킨을 시켜먹으면 한 마리당 쿠폰을 한 장 발급합니다.
     * 쿠폰을 열 장 모으면 치킨을 한 마리 서비스로 받을 수 있고, 서비스 치킨에도 쿠폰이 발급됩니다.
     * 시켜먹은 치킨의 수 chicken이 매개변수로 주어질 때 받을 수 있는 최대 서비스 치킨의 수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * chicken은 정수입니다.
     * 0 ≤ chicken ≤ 1,000,000
     */
    class Solution {
        public int solution(int chicken) {
            int answer = 0;
            boolean isChange = true;
            answer = chicken / 10;  //치킨 10마리 당 쿠폰 1개
            chicken = (chicken % 10) + answer;  //치킨 쿠폰으로 바꾸고 남은 치킨 수 + 쿠폰으로 바꿀 수 있는 치킨 수

            while (isChange) {
                isChange = false;
                int c = 0;

                if (chicken >= 10) {    //치킨 수가 10마리 넘으면 다시 쿠폰 발급 과정 처리
                    c = chicken / 10;   //쿠폰 발급
                    chicken = chicken % 10 + c; //쿠폰으로 바꾸고 남은 치킨에 쿠폰으로 바꾼 치킨 수
                    answer += c;    //총 쿠폰 수에 발급한 쿠폰 수 추가
                    isChange = true;
                }
            }

            return answer;
        }
    }
}
