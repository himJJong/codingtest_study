public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(solution("abcdcba"));
    }
    public static int solution(String s) {
        int ans = 0;
        int n = s.length();

        loop:
        for(int i=n; i>=1; i--){
            for(int j=0; j<=n-i; j++){
                boolean flag = true;
                int start = j;
                int end = j+i-1;

                while(start<end){
                    if(s.charAt(start)!=s.charAt(end)){
                        flag = false;
                        break;
                    }
                    start++;
                    end--;
                }
                if(flag){
                    ans=i;
                    break loop;
                }
            }
        }
        return ans;
    }
}

/**
 * 문제 해석
 * 가장 긴 팰린드롬부터 찾는다.
 * start와 end를 비교하여 서로의 문자가 다르다면 flag=false
 * 만약 flag가 true라면 i값이 팰린드롬의 길이
 **/

/**
 * 놓친 부분
 * substring 함수의 수행시간이 O(N)이어서 시간 초과가 발생한다.
 * 따라서 문자열을 일일히 비교하지 않고, 문자 하나씩을 비교한다.
 **/
