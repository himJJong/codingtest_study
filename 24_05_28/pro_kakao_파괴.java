public class pro_kakao_파괴 {
    class Solution {
        public int solution(int[][] board, int[][] skill) {
            int answer = 0;
            int N = board.length;
            int M = board[0].length;

            int[][] arr = new int[N+1][M+1];

            for(int i=0; i<skill.length; i++){
                int val = 1;
                if(skill[i][0] == 1){
                    val = -1;
                }
                val *= skill[i][5];

                int r1 = skill[i][1];
                int c1 = skill[i][2];
                int r2 = skill[i][3]+1;
                int c2 = skill[i][4]+1;

                arr[r1][c1] += val;
                arr[r2][c2] += val;
                arr[r1][c2] += val * (-1);
                arr[r2][c1] += val * (-1);
            }

            for(int i=0; i<N; i++){
                for(int j=1; j<M; j++){
                    arr[i][j] += arr[i][j-1];
                }
            }


            for(int i=0; i<N; i++){
                for(int j=1; j<M; j++){
                    arr[j][i] += arr[j-1][i];
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    board[i][j] += arr[i][j];
                    if(board[i][j] > 0){
                        answer++;
                    }
                }
            }


            return answer;
        }
    }
}
