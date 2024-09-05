import java.util.*;
class pro_kakaoWinter_도넛 {
    public static void main(String[] args) {
        int[][] arr ={{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8},
                {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1},{5, 3}, {11,9}, {3, 8}};
        System.out.println(pro_kakaoWinter_도넛.solution(arr));
    }
    static class Node {
        int from;
        int to;

        Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static ArrayList<Node>[] list;
    static int nodeCnt = 0;
    static int[] degree;
    static boolean[] visited;
    static int vertexCnt = 0;
    static int edgeCnt = 0;
    static int bar = 0;
    static int oct = 0;
    static int cir = 0;

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        // 최대 노드 번호를 계산
        for (int i = 0; i < edges.length; i++) {
            nodeCnt = Math.max(nodeCnt, Math.max(edges[i][0], edges[i][1]));
        }

        list = new ArrayList[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];
        degree = new int[nodeCnt + 1];

        for (int i = 1; i <= nodeCnt; i++) {
            list[i] = new ArrayList<>();  // 리스트 초기화
        }

        // 간선 정보를 리스트에 추가하고 진입 차수 계산
        for (int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(new Node(edges[i][0], edges[i][1]));
            degree[edges[i][1]]++;
        }

        // 진입 차수가 0이고, 2개 이상의 간선이 있는 노드를 찾음
        int vertex = -1;
        for (int i = 1; i <= nodeCnt; i++) {
            if (degree[i] == 0 && list[i].size() >= 2) {
                vertex = i;
                answer[0] = vertex;
                break;
            }
        }

        // vertex에 연결된 노드를 DFS로 탐색
        if (vertex != -1) {
            for (int i = 0; i < list[vertex].size(); i++) {
                if (!visited[list[vertex].get(i).to]) {
                    vertexCnt = 0;
                    edgeCnt = 0;
                    Arrays.fill(visited, false);  // 각 연결된 컴포넌트마다 방문 초기화

                    visited[list[vertex].get(i).to] = true;
                    dfs(list[vertex].get(i).to);

                    // 도넛 모양
                    if (vertexCnt == edgeCnt) {
                        cir++;
                    }
                    // 막대 모양
                    else if (vertexCnt > edgeCnt && vertexCnt - edgeCnt == 1) {
                        bar++;
                    }
                    // 8자 모양
                    else if (vertexCnt % 2 == 1) {
                        int octSize = (vertexCnt - 1) / 2;
                        if (octSize * 2 + 1 == vertexCnt && octSize * 2 + 2 == edgeCnt) {
                            oct++;
                        }
                    }
                }
            }
        }

        answer[1] = cir;
        answer[2] = bar;
        answer[3] = oct;

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3]);

        return answer;
    }

    // 깊이 우선 탐색 함수
    private static void dfs(int val) {
        vertexCnt++;  // 정점 수 증가

        for (int i = 0; i < list[val].size(); i++) {
            edgeCnt++;  // 간선 수 증가

            // 다음 노드 탐색
            if (!visited[list[val].get(i).to]) {
                visited[list[val].get(i).to] = true;
                dfs(list[val].get(i).to);
            }
        }
    }

}
// 도넛 모양 그래프 - n개 정점, n개 간선
// 막대 모양 그래프 - n개 정점, n-1개 간선
// 8자 모양 그래프 - 2n+1 정점, 2n+2 간선
// 간선길이 1000000
// 그래프 수의 합은 2이상