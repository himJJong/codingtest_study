import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int num, dist;

    public Pair(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}

public class codeTree_트리지름길 {
    public static final int MAX_N = 100000;

    // 변수 선언:
    public static int n;
    public static ArrayList<Pair>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] dist = new int[MAX_N + 1];

    // DFS를 통해 연결된 모든 정점을 순회합니다.
    // 동시에 시작점으로부터의 거리를 같이 계산해줍니다.
    public static void dfs(int x, int totalDist) {
        // 노드 x에 연결된 간선을 살펴봅니다.
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i).num;
            int d = edges[x].get(i).dist;
            // 아직 방문해본적이 없는 노드인 경우에만 진행합니다.
            if(!visited[y]) {
                visited[y] = true;
                dist[y] = totalDist + d;
                dfs(y, totalDist + d);
            }
        }
    }

    // 정점 x로부터 가장 멀리 있는 정점 정보를 찾아줍니다.
    public static Pair FindLargestVertex(int x) {
        // visited, dist 값을 초기화해줍니다.
        for(int i = 1; i <= n; i++) {
            visited[i] = false;
            dist[i] = 0;
        }

        // 정점 x를 시작으로 하는 DFS를 진행합니다.
        visited[x] = true;
        dist[x] = 0;
        dfs(x, 0);

        // 정점 x로부터 가장 멀리 떨어진 정점 정보를 찾습니다.
        int farthestDist = -1;
        int farthestVertex = -1;
        for(int i = 1; i <= n; i++) {
            if(dist[i] > farthestDist) {
                farthestDist = dist[i];
                farthestVertex = i;
            }
        }

        // 가장 멀리 떨어진 정점 번호와 그때의 거리를 반환합니다.
        return new Pair(farthestVertex, farthestDist);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();

        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        // n - 1개의 간선 정보를 입력받습니다.
        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();

            // 간선 정보를 인접리스트에 넣어줍니다.
            edges[x].add(new Pair(y, d));
            edges[y].add(new Pair(x, d));
        }

        // 1번 정점으로부터 가장 멀리 있는 정점 정보를 찾습니다.
        int fVertex = FindLargestVertex(1).num;

        // farthest vertex로부터 가장 멀리 있는 정점 정보를 찾습니다.
        // 이때의 거리가 지름이 됩니다.
        int diameter = FindLargestVertex(fVertex).dist;

        System.out.print(diameter);
    }
}