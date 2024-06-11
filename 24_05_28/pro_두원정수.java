import java.util.*;

public class pro_두원정수 {
    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 4;
        System.out.println(Solution.solution(r1, r2));
    }
    static class Solution {
        public static long solution(int r1, int r2) {
            long answer = (long)(r2-r1+1)*4L;
            int smallY = 0;
            int bigY = 0;

            for(int x=1;x<r2;x++){
                smallY = (int)Math.sqrt((long)r1*r1-(long)x*x);
                bigY = (int)Math.sqrt((long)r2*r2-(long)x*x);
                answer += (long)(bigY-smallY)*4;

                if(x<r1 && Math.sqrt((long)r1*r1-(long)x*x)%1 ==0) {
                    answer+=4L;
                }
            }
            return answer;
        }
    }
}
/*
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        long[] data = new long[r2];
        long[] sum = new long[r2];
        data[1] = 8;
        sum[1] = 8;
        for(int i=2; i<r2; i++){
            data[i] = (((i*2)+1)*2) + (((i-1)*2)+1)*2;
            System.out.println(data[i]);
        }

        for(int i=r1; i<r2; i++){
            answer += data[i];
        }

        return (long) (answer + 4);
    }
}
 */
