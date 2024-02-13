public class Delivery {
    static final int INF = 5000001;
    public static void main(String[] args) {

    }
    public static int solution(int N, int[][] road, int K){
        int ans = 0;
        int[][] map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j) continue;
                map[i][j] = INF;
            }
        }

        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];

            if(map[a][b] > w){
                map[a][b] = w;
                map[b][a] = w;
            }
        }

        int[] dist = new int[N+1];
        for(int i=2; i<=N; i++){
            dist[i] = (dist[i]==0)?INF : map[1][i];
        }

        boolean[] visited = new boolean[N+1];
        visited[1] = true;

        for(int i=1; i<=N-1; i++){
            int min_idx = 1;
            int min_value = INF;
            for(int j=2; j<=N; j++){
                if(!visited[j] && dist[j] < min_value){
                    min_value = dist[j];
                    min_idx = j;
                }
            }

            visited[min_idx] = true;

            for(int j=2; j<=N; j++){
                if(dist[j] > dist[min_idx] +map[min_idx][j]){
                    dist[j] = dist[min_idx]+map[min_idx][j];
                }
            }
        }
        for(int i=1; i<=N; i++){
            if(dist[i]<=K) ans++;
        }

        return ans;

    }
}

/**
 * 문제 해석
 * 다익스트라 알고리즘 사용
 * A를 시작점으로 했을 때 다른 도시까지의 거리에 대한 정보를 dist[]로 선언하여 초기화
 * 도착점이 존재한다면 해당 weight 를, 경로가 존재하지 않는다면 INF(=5000001, 음식 배달이 가능한 시간은 500,000이하이므로)로 초기화
 * 다른 도시를 방문했는지에 대한 여부를 visited[]로 체크
 * 시작점을 제외하고 dist[]의 값이 가장 작은 도시의 index 를 가져온다.
 * 해당 index 를 visited 처리한 뒤, 그 index 의 도시를 거쳐가는 경로가 원래 dist[]에 들어있는 값보다 작으면 값을 변경
 * 3~4번을 N-1 번 반복.
 **/
