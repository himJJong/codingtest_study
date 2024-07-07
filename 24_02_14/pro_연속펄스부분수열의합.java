public class pro_연속펄스부분수열의합 {
    class Solution {
        public long solution(int[] sequence) {
            long answer = 0;
            int[] a = new int[sequence.length];
            int[] b = new int[sequence.length];

            long[] dp1 = new long[sequence.length];
            long[] dp2 = new long[sequence.length];

            for(int i=0; i<sequence.length; i++){
                if(i % 2 == 0){
                    b[i] = sequence[i] * -1;
                    a[i] = sequence[i];
                }
                else {
                    a[i] = sequence[i] * -1;
                    b[i] = sequence[i];
                }
            }

            if(sequence.length == 1){
                return Math.max(sequence[0] * -1, sequence[0]);
            }
            dp1[0] = a[0];
            dp2[0] = b[0];

            long answer1 = Long.MIN_VALUE;
            long answer2 = Long.MIN_VALUE;

            for(int i=1; i<a.length; i++){
                dp1[i] = a[i];
                dp2[i] = b[i];
                if(dp1[i] < a[i] + dp1[i-1]){
                    dp1[i] = a[i] + dp1[i-1];
                }
                if(dp2[i] < b[i] + dp2[i-1]){
                    dp2[i] = b[i] + dp2[i-1];
                }

                answer1 = Math.max(answer1, dp1[i]);
                answer2 = Math.max(answer2, dp2[i]);
            }

            return Math.max(answer1, answer2);
        }
    }
}
