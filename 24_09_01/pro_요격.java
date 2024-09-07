import java.util.Arrays;

public class pro_요격 {
    public static void main(String[] args) {
        int[][] t = {{4,5}, {4,8}, {10,14}, {11,13}, {5,12}, {3,7}, {1,4}};
        System.out.println(Solution.solution2(t));
        System.out.println(Solution.solution(t));
    }
    static class Solution {
        public static int solution(int[][] targets) {
            Arrays.sort(targets, (a, b) -> a[0] - b[0]);

            int cnt = 0;
            int last = -1;

            for(int[] t : targets){
                if(t[0] > last){ // 새로운 요격 미사일 필요
                    cnt++;
                    last = t[1] - 1; // 해당 미사일로 커버되는 거리
                }
                else if(t[1] - 1 < last){ // 더 작은 범위로 커버 가능한 미사일 필요
                    last = t[1] - 1; // 해당 미사일로 커버되는 범위
                }
            }
            return cnt;
        }



        public static int solution2(int[][] targets) {
            int answer = 0;

            Arrays.sort(targets, (a, b) -> a[1] - b[1]);

            int left = 0;
            for(int i=0; i<targets.length; i++){
                if(left <= targets[i][0]){
                    left = targets[i][1];
                    answer++;
                }
            }

            return answer;
        }

    }
}
