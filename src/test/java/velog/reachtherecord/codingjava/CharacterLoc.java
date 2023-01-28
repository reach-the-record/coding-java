package velog.reachtherecord.codingjava;

public class CharacterLoc {
    class Solution {
        /**
         * 머쓱이는 RPG게임을 하고 있습니다. 게임에는 up, down, left, right 방향키가 있으며 각 키를 누르면 위, 아래, 왼쪽, 오른쪽으로 한 칸씩 이동합니다.
         * 예를 들어 [0,0]에서 up을 누른다면 캐릭터의 좌표는 [0, 1], down을 누른다면 [0, -1], left를 누른다면 [-1, 0], right를 누른다면 [1, 0]입니다.
         * 머쓱이가 입력한 방향키의 배열 keyinput와 맵의 크기 board이 매개변수로 주어집니다.
         * 캐릭터는 항상 [0,0]에서 시작할 때 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 [x, y]를 return하도록 solution 함수를 완성해주세요.
         * [0, 0]은 board의 정 중앙에 위치합니다. 예를 들어 board의 가로 크기가 9라면 캐릭터는 왼쪽으로 최대 [-4, 0]까지 오른쪽으로 최대 [4, 0]까지 이동할 수 있습니다.
         *
         * board은 [가로 크기, 세로 크기] 형태로 주어집니다.
         * board의 가로 크기와 세로 크기는 홀수입니다.
         * board의 크기를 벗어난 방향키 입력은 무시합니다.
         * 0 ≤ keyinput의 길이 ≤ 50
         * 1 ≤ board[0] ≤ 99
         * 1 ≤ board[1] ≤ 99
         * keyinput은 항상 up, down, left, right만 주어집니다.
         *
         */
        public int[] solution(String[] keyinput, int[] board) {
            int maxX = board[0] / 2;    //x좌표, y좌표의 최대값을 구한다
            int maxY = board[1] / 2;

            int x = 0;  //캐릭터 기본 좌표 초기화
            int y = 0;
            for (int i = 0; i < keyinput.length; i++) {
                switch(keyinput[i]) {   //input에 따라 보드 수에 맞게 이동
                    case "left":
                        if (x > (-1 * maxX)) x--;   //left는 maxX의 -값으로 비교 후 이동 처리
                        break;
                    case "right":
                        if (x < maxX) x++;
                        break;
                    case "up":
                        if (y < maxY) y++;
                        break;
                    case "down":
                        if (y > (-1 * maxY)) y--; //down은 maxY의 -값으로 비교 후 이동 처리
                        break;
                }
            }
            int[] answer = {x, y};

            return answer;
        }
    }
}
