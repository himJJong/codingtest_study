public class pro_가장큰정사각형찾기 {
    public static void main(String[] args) {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        // board의 행 또는 열이 1로 주어질 때 예외처리
        if(row<2||col<2){
            System.out.println(1);
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(board[i][j] !=0){
                    // board[i][j]의 왼쪽 상단, 왼쪽, 위쪽 중 최솟값 구해서 +1 후 할당
                    board[i][j] = Math.min(board[i-1][j-1],Math.min(board[i-1][j],board[i][j-1]))+1;
                }
                // 그 중 최댓값을 answer에 할당
                if(answer < board[i][j]) answer = board[i][j];
            }
        }

        System.out.println(answer * answer);
    }
}
