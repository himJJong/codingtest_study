import java.util.*;
public class DefenceGame {
    public static void main(String[] args) {

    }

    public static int solution(int n, int k, int[]enemy){
        int ans = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<enemy.length; i++){
            n-=enemy[i];
            pq.add(enemy[i]);

            if(n<0){
                if(k>0 && !pq.isEmpty()){
                    n += pq.poll();
                    k--;
                }else{
                    break;
                }
            }
            ans++;
        }
        return ans;
    }
}

/**
 * 문제 해석
 * 매 라운드 별로 n 에서 enemy[i]를 뺀다.
 * 그 후 enemy[i]를 우선순위 큐에 넣는다.
 * 만약 n-enemy[i]가 0보다 작고, 무적권을 쓸 수 있을 때 n에 다시 enemy[i]를 넣는다.
 * 그 후, 무적권의 사용 횟수 1을 줄인다.
 * 무적권을 쓸 수 없고, n-enemy[i]가 0보다 작다면, 멈춘다.
 **/

/**
 * 놓친 부분
 * 1 <= n <= 1,000,000,000 / 1 <= k <= 500,000
 * 1 <= enemy.length <= 1,000,000 / 1 <= enemy[i] <= 1,000,000
 * 위와 같이 범위가 매우 크다. 따라서, 단순 반복문을 사용하면 시간 초과가 일어난다.
 * 또한, 어떤 라운드에서 무적권을 써야 할 지를 정해야 되는데, 이러한 부분들을
 * 우선순위 큐를 사용하여 0 미만이 되는 경우 사용하면 되게끔 코드를 작성하였다.
 **/