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

        int d = 0;
        int p = 0;
        for (int i = n - 1; i > -1; i--) { // (1)
            int cnt = 0;
            d -= deliveries[i]; // (2)
            p -= pickups[i];
            while (d < 0 || p < 0) { // (3)
                d += cap;
                p += cap;
                cnt++;
            }

            answer += (i + 1) * 2 * cnt; // (4)
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