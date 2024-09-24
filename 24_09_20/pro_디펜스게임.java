import java.util.*;
// 이분탐색 떠올린 이유는 -> 해당 기준을 최댓값 구하는거고, TTTTFFFF

class pro_디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int left  = 0;
        int right = enemy.length;

        while(left <= right){
            int mid = (left + right)/2;
            if (mid > enemy.length) {
                break; // 범위 초과 방지
            }
            if(check(mid, enemy, k, n)){
                answer = Math.max(answer, mid);
                left = mid + 1;
            }

            else{
                right = mid-1;
            }
        }
        return answer;
    }

    // 시작 끝값, 다르게해야함. 
    private static boolean check(int mid, int[] enemy, int k, int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for(int i=0; i<mid; i++){
            sum += enemy[i];
            pq.add(enemy[i]);
        }

        for(int i=0; i<k && !pq.isEmpty(); i++){
            sum -= pq.poll();
        }


        if(sum <= n){
            return true;
        }
        return false;
    }
}