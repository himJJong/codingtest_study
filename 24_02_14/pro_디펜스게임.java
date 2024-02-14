/*
    1시간 정도 소요. (해시맵, 투 포인터 등 떠올리다가 그리디로 접근하는게 맞다고 생각)
    탐색 범위가 컸음. 일반적인 방법은 안될거고, 효율적인 그리디로 접근.
    1) enemy를 순차적으로 올라가며, n에서 값을 빼주고 그때 앞쪽 범위 중 가장 큰 값을 빼고자함. (복잡하고, 명확하지 않았음)
    2) 결국 가장 큰 값만 알면되므로, 우선순위 큐를 사용하면 이를 효율적으로 해결할 수 있다고 생각해서 해결.
 */

import java.util.*;

public class pro_디펜스게임 {
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int index = 0;
            while(index !=enemy.length){
                pq.add(enemy[index]);
                n -= enemy[index];

                if(n < 0 && k > 0){
                    n += pq.poll();
                    k--;
                }
                else if (n < 0 && k == 0){
                    break;
                }

                index++;
                answer++;
            }
            return answer;
        }
    }
}
