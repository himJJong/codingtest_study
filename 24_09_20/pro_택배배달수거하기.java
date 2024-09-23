class pro_택배배달수거하기 {
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1,0,3,1,2};
        int[] pickups = {0,3,0,4,0};

        Solution sol1 = new Solution();
        Solution sol2 = new Solution();
        System.out.println(sol1.solution(cap, n, deliveries, pickups));

        cap = 2;
        n = 7;
        int[] deliveries2 = {1,0,2,0,1,0,2};
        int[] pickups2 = {0,2,0,1,0,2,0};
        System.out.println(sol2.solution(cap,n,deliveries2, pickups2));
    }
}
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int del = 0;
        int pick = 0;
        // 맨 마지막 집부터 시작
        for (int i = n-1; i >= 0; i--) {
            // 만약 현재 집에 배달이나 수거를 할 상자가 있다면
            if (deliveries[i] > 0 || pickups[i] > 0) {
                // 현재 집에 방문해야할 횟수를 누적할 변수
                int cnt = 0;
                // 배달,수거 상자 개수가 현재 집의 배달,수거 개수보다 커질때까지 반복
                // 이건 현재 집에 방문해야 하는 횟수를 측정하기 위함임
                while (del < deliveries[i] || pick < pickups[i]) {
                    // 현재 집 방문 횟수 카운트
                    cnt++;
                    // 현재 집에 배달,수거 가능한 상자의 개수를 누적
                    // 한번의 방문당 배달, 수거 가능한 최대 개수는 cap만큼 가능
                    del += cap;
                    pick += cap;
                }
                // 현재 집에 배달,수거를 한 이후
                // 물류센터로 돌아가지 않고 추가로 배달,수거를 할 수 있는 상자의 개수를 측정
                del -= deliveries[i];
                pick -= pickups[i];
                // 이동거리 계산
                answer += (i+1) * cnt * 2;
            }
        }
        return answer;
    }
}

// 배달 -> 가장 바깥쪽에 있는거부터 차례로 놔두기
// 수거 -> 가장 바깥에 있는거부터 차례로 가져오기


// 문제 내 뒤에 있는지 없는지 체크해야함. -> 인덱스를 두고 체크하면 되고,
// 배달이 다 되었더라도 해당 위치에서 수거해야 하니까, 인덱스를 각각 두고 if 조건문으로 온다면?
// 1 0 4 5 7

// 배달 -> 가장 바깥쪽에 있는거부터 차례로 놔두기
// 수거 -> 가장 바깥에 있는거부터 차례로 가져오기


// 문제 내 뒤에 있는지 없는지 체크해야함. -> 인덱스를 두고 체크하면 되고, 
// 배달이 다 되었더라도 해당 위치에서 수거해야 하니까, 인덱스를 각각 두고 if 조건문으로 온다면?
// 1 0 4 5 7