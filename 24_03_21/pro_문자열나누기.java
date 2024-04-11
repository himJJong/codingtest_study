public class pro_문자열나누기 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("banana"));
    }
    static class Solution {
        public static int solution(String s) {
            int answer = 1;

            char x = s.charAt(0);
            int count = 1;
            for (int i = 1; i < s.length(); i++) {
                if (count == 0) {
                    answer++;
                    x = s.charAt(i);
                }

                if (x == s.charAt(i)) {
                    count++;
                } else {
                    count--;
                }
            }


            return answer;
        }
    }
}
