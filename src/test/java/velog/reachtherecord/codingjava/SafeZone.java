package velog.reachtherecord.codingjava;

public class SafeZone {

    /**
     * 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
     * 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
     * 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
     *
     * board는 n * n 배열입니다.
     * 1 ≤ n ≤ 100
     * 지뢰는 1로 표시되어 있습니다.
     * board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
     */
    class Solution {
        public int solution(int[][] board) {
            int answer = 0;

            if (board.length == 1) {    //board가 1칸일 경우 지뢰인지 아닌지만 확인
                return board[0][0] == 0 ? 1 : 0;
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    boolean safe = false;
                    if (board[i][j] == 0) { //해당 칸이 0인지 확인
                        safe = true;
                        if (i != 0) {   //제일 위칸이 아닐 경우 위칸을 확인
                            if (board[i-1][j] != 0) {   //해당 칸의 위칸에 지뢰여부 확인
                                safe = false;
                            }
                            if (j != 0) {   //제일 왼쪽이 아닐 경우
                                if (board[i-1][j-1] != 0) { //왼쪽 대각선 위 확인
                                    safe = false;
                                }
                                if (board[i][j-1] != 0) { //왼쪽 확인
                                    safe = false;
                                }
                            }
                            if (j != board[i].length - 1) { //제일 오른쪽 칸이 아닐 경우
                                if (board[i-1][j+1] != 0) { //오른쪽 대각선 위 확인
                                    safe = false;
                                }
                                if (board[i][j+1] != 0) {   //오른쪽 확인
                                    safe = false;
                                }
                            }
                        }
                        if (i != board.length - 1) {    //제일 아래쪽 칸이 아닐 경우
                            if (board[i+1][j] != 0) {   //아래쪽 확인
                                safe = false;
                            }
                            if (j != 0) {
                                if (board[i+1][j-1] != 0) { //왼쪽 대각선 아래 칸 확인
                                    safe = false;
                                }
                            }
                            if (j != board[i].length - 1) {
                                if (board[i+1][j+1] != 0) { //오른쪽 대각선 아래 확인
                                    safe = false;
                                }
                            }
                        }
                    }
                    if (safe) { //전부 확인해서 safe가 true일 경우 +1
                        answer++;
                    }
                }
            }

            return answer;
        }
    }
}
