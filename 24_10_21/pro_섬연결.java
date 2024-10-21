import java.util.*;

class pro_섬연결 {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        int answer = 0;
        for(int i=0; i<costs.length; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int val = costs[i][2];

            if(findParent(from) != findParent(to)){
                unionFind(from, to);
                answer += val;
            }
        }

        return answer;
    }

    private static int findParent(int val){
        if(parent[val] == val){
            return val;
        }
        return findParent(parent[val]);
    }

    private static void unionFind(int a, int b){
        int parentA = findParent(a);
        int parentB = findParent(b);

        if(parentA > parentB){
            parent[parentA] = parentB;
        }
        else{
            parent[parentB] = parentA;
        }
    }
}
// 1.플로이드워셜 접근 -> 틀린 이유 : 모두 통행이 되면서 간선의 최솟값
// 모든 노드의 연결이 되면서 최소 간선이기에, 유니온파인드를 이용한 크루스칼 접근 -> 정답