public class pro_퍼즐게임 {
    public static void main(String[] args) {
        int[] diffs = {1,328,467,209,54};
        int[] times = {2,7,1,4,3};
        int limit = 1723;
        System.out.println(Solution.solution(diffs,times,limit));
    }
    static class Solution {
        public static int solution(int[] diffs, int[] times, long limit) {
            long left = 1;
            long right = Integer.MIN_VALUE;
            for(int i=0; i<diffs.length; i++){
                right = Math.max(right, diffs[i]);
            }
            long answer = 0;

            while(left <= right){
                long mid = (left + right) / 2;
                long cnt = 0;
                for(int i=0; i<times.length; i++){
                    if(mid >= diffs[i]){
                        cnt += times[i];
                    }
                    else{
                        long rest = diffs[i] - mid;
                        cnt += (times[i-1] + times[i])*rest + times[i];
                    }

                    if(cnt > limit) {
                        break;
                    }
                }

                if(cnt > limit){
                    left = mid + 1;
                }
                else{
                    answer = mid;
                    right = mid - 1;
                }
            }

            return (int) answer;
        }
    }
}
