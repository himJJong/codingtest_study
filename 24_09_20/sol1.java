import java.util.*;
import java.io.*;
/*
find -> O(N)
union -> find 2번 -> O(N)
add -> O(1)
getGroupSizes -> O(N^2)
main -> O(M * N)

O(M*N + N^2)
M 연결정보수
N 노드수
 */
public class sol1 {
    static class UnionFind {
        private Map<Integer, Integer> parent = new HashMap<>();
        private Map<Integer, Integer> size = new HashMap<>();

        private int find(int x) {                           // parent 값 찾기
            if (parent.get(x) == x) {
                return x;
            }
            parent.put(x, find(parent.get(x)));
            return find(parent.get(x));
        }


        private void union(int x, int y) {                  // 두 노드가 속한 집합을 합치기
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (size.get(rootX) < size.get(rootY)) {    // 더 작은 집합을 큰 집합에 붙임
                    parent.put(rootX, rootY);
                    size.put(rootY, size.get(rootY) + size.get(rootX));
                } else {
                    parent.put(rootY, rootX);
                    size.put(rootX, size.get(rootX) + size.get(rootY));
                }
            }
        }

        private void add(int x) {                          // 새로운 노드 초기화
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                size.put(x, 1);
            }
        }

        private Map<Integer, Integer> getGroupSizes() {    // 해당 그룹의 크기 가져오기
            Map<Integer, Integer> groupSizes = new HashMap<>();
            for (int node : parent.keySet()) {
                int root = find(node);
                groupSizes.put(root, size.get(root));
            }
            return groupSizes;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        int M = Integer.parseInt(NM[0]);
        int N = Integer.parseInt(NM[1]);
        UnionFind uf = new UnionFind();

        for (int i = 0; i < M; i++) {                              // 연결 정보 union-find
            String[] data = br.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            uf.add(a);
            uf.add(b);
            uf.union(a, b);
        }

        Map<Integer, Integer> groupSizes = uf.getGroupSizes();    // 그룹별 크기
        int result = 0;
        for (int size : groupSizes.values()) {                    // N값 이하의 그룹 크기를 모두 더하기
            if (size <= N) {
                result += size;
            }
        }

        System.out.println(result);                               // N이하의 총 별 개수 출력
    }
}
