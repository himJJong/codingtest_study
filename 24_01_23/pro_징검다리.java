public class pro_징검다리 {
    public static void main(String[] args) {
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        int k = 3;

        System.out.println(solution(stones, k));
    }

    private static int solution(int[] stones, int k) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<stones.length; i++){
            max = Math.max(stones[i], max);
        }

        int left = 0;
        int right = max;
        while(left <= right){
            int mid = (left + right)/2;
            int check = Integer.MIN_VALUE;
            int test = 0;
            for(int i=0; i<stones.length; i++){
                if(stones[i] < mid){
                    test++;
                }
                else{
                    test = 0;
                }

                check = Math.max(check,test);
            }

            if(check < k){
                left = mid + 1;
                answer = mid;
            }
            else{
                right = mid - 1;
            }
        }

        return answer;
    }
}
