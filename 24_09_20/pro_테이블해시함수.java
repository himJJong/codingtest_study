import java.util.*;

class pro_테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int newCol = col-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[newCol] == b[newCol]) {
                    return b[0] - a[0];
                }
                return a[newCol] - b[newCol];
            }
        });

        for(int i=row_begin-1; i<=row_end-1; i++){ // 2500 // 500.              1250000
            long sum = 0;
            for(int j=0; j<data[0].length; j++){
                sum += (long) (data[i][j] % (i+1));
            }
            answer ^= sum;
        }
        return answer;
    }
}