import java.util.HashMap;
import java.util.Map;

public class 기출복기2 {

    // 문자열을 분할했을 때 가장 많이 등장한 알파벳의 등장 횟수 중 최댓값이 x 이하로 가능한지 확인하는 함수
    public static boolean canSplit(String s, int n, int maxCount) {
        int left = 0;
        int parts = 0;

        while(left < s.length()){
            int[] count = new int[27];
            int right = left;
            int max = 0;
            while(right < s.length()){
                count[s.charAt(right) - 'a']++;
                max = Math.max(max, count[s.charAt(right) - 'a']);

                if(max > maxCount){
                    break;
                }
                right++;
            }
            parts++;
            left = right;
            if(parts > n+1){
                return false;
            }
        }
        return true;
    }

    // 이분 탐색을 이용해 각 문자열에서 가장 많이 등장한 알파벳의 등장 횟수 중 최댓값을 최소화하는 함수
    public static int minimizeMaxCount(String s, int n) {
        int left = 1;
        int right = s.length();
        int answer = 0;

        while(left <= right){
            int mid = (left + right)/2;

            if(canSplit(s,n,mid)){ // 가능하다면
                answer = mid;
                right = mid - 1;

            }
            else {   // 불가능하다면
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        String s1 = "aabbbabba";
        int n1 = 2;
        System.out.println(minimizeMaxCount(s1, n1));  // Expected: 2

        // 테스트 케이스 2
        String s2 = "xyyyyxxxxxx";
        int n2 = 2;
        System.out.println(minimizeMaxCount(s2, n2));  // Expected: 3

        // 테스트 케이스 3
        String s3 = "abcd";
        int n3 = 1;
        System.out.println(minimizeMaxCount(s3, n3));  // Expected: 1
    }
}
