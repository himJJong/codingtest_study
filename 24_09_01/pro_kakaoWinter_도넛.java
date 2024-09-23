import java.util.*;
class Solution {
    static class Node{
        int from;
        int to;
        Node(int from, int to){
            this.from = from;
            this.to = to;
        }
    }
    static ArrayList<Node>[] list;
    static int nodeCnt =0;
    static int[] degree;
    static int size= 0;
    static int vertex;
    static boolean[] visited;
    static int vertexCnt = 0;
    static int edgeCnt = 0;
    static int bar = 0;
    static int oct = 0;
    static int cir = 0;
    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        for(int i=0; i<edges.length; i++){
            nodeCnt = Math.max(nodeCnt, Math.max(edges[i][0], edges[i][1]));
        }
        list = new ArrayList[nodeCnt+1];
        visited = new boolean[nodeCnt+1];
        degree = new int[nodeCnt+1];
        for(int i=1; i<=nodeCnt; i++){
            list[i] = new ArrayList<>();  // 초기화 수정
        }

        for(int i=0; i<edges.length; i++){
            list[edges[i][0]].add(new Node(edges[i][0],edges[i][1]));
            degree[edges[i][1]]++;
        }

        for(int i=1; i<=nodeCnt; i++){
            if(degree[i] == 0 && list[i].size() >= 2){
                vertex = i;
                answer[0] = vertex;
                break;
            }
        }

        for(int i=0; i<list[vertex].size(); i++){
            if(!visited[list[vertex].get(i).to]){
                Arrays.fill(visited, false);
                vertexCnt = 0;
                edgeCnt = 0;
                size = 0;
                visited[list[vertex].get(i).to] = true;
                dfs(list[vertex].get(i).to);

                if(vertexCnt == edgeCnt){
                    cir++;
                }
                else if(vertexCnt > edgeCnt && vertexCnt - edgeCnt == 1){
                    bar++;
                }
                else if(vertexCnt % 2 == 1){
                    int octSize = (vertexCnt - 1) / 2;
                    if(octSize * 2 + 1 == vertexCnt && octSize * 2 + 2 == edgeCnt) {
                        oct++;
                    }
                }
            }
        }
        answer[1] = cir;
        answer[2] = bar;
        answer[3] = oct;

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3]);
        // 도넛 모양 그래프 - n개 정점, n개 간선
        // 막대 모양 그래프 - n개 정점, n-1개 간선
        // 8자 모양 그래프 - 2n+1 정점, 2n+2 간선
        return answer;
    }
    private static void dfs(int val){
        vertexCnt++;
        for(int i=0; i<list[val].size(); i++){
            if(!visited[list[val].get(i).from]) {
                size++;
                visited[list[val].get(i).from] = true;
            }
            edgeCnt++;
            if(!visited[list[val].get(i).to]){
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