public class pro_거스름돈 {
    public static void main(String[] args) {
        int n = 10;
        int[] om = {1,2,5};
        System.out.println(Solution.solution(n,om));
    }
    static public class Solution {
        public static int solution(int n, int[] money) {
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int coin : money) {
                for (int i = coin; i <= n; i++) {
                    dp[i] += dp[i - coin];
                    dp[i] %= 1000000007;
                }
            }

            return dp[n];
        }
    }
}
