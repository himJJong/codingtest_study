import java.util.*;

public class pro_해시테이블함수 {


    class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int answer = 0;

            Arrays.sort(data, (o1, o2) -> {
                if(o1[col-1] == o2[col-1]){
                    return o2[0] - o1[0];
                }
                return o1[col-1] - o2[col-1];
            });

            for(int i=row_begin-1; i<=row_end-1; i++){

                int tmp = 0;
                for(int j=0; j<data[0].length; j++){
                    tmp += data[i][j] % (i+1);
                }
            /*
            int finalI = i + 1;
            int dataTotal = Arrays.stream(data[i])
                    .map(j -> j % finalI)
                    .sum();
            */
                answer = answer ^ tmp;
            }

            return answer;
        }
    }
}
