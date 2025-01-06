import java.util.*;

public class pro_공원 {
    public static void main(String[] args) {
        int[] s = {5,3,2};
        String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
        System.out.println(Solution.solution(s,park));

    }
    static class Solution {
        public static int solution(int[] mats, String[][] park) {
            int answer = Integer.MIN_VALUE;;
            Arrays.sort(mats);
            int index = mats.length-1;
            boolean flag = false;

            for(int i=0; i<park.length; i++){
                for(int j=0; j<park[0].length; j++){
                    if(park[i][j].equals("-1")){
                        for(int cnt = index; cnt>=0; cnt--){
                            if(mats[cnt] <= answer){
                                continue;
                            }
                            boolean check = true;
                            for(int row = i; row < i + mats[cnt]; row++){
                                if(!check) break;
                                for(int col = j; col < j + mats[cnt]; col++){
                                    if(row < park.length && col < park[0].length
                                            && park[row][col].equals("-1")){
                                        continue;
                                    }
                                    else{
                                        check = false;
                                        break;
                                    }
                                }
                            }
                            if(check) {
                                answer = Math.max(mats[cnt], answer);
                                break;
                            }
                        }
                    }
                }
            }
            return answer;
        }
    }
}
