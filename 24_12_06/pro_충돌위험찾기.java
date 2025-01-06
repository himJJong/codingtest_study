import java.util.*;

class pro_충돌위험찾기 {
    public static void main(String[] args) {
        int[][] points = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5,2}};
        int[][] routes = {{2,3,4,5}, {1,3,4,5}};
        System.out.println(solution(points, routes));
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toKey() {
            return x + "," + y;
        }
    }

    static List<Node>[] pathList;
    static int maxPathLength = 0;

    public static int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Set<String> set = new HashSet<>(); // points 위치 저장
        Set<String> collisionDetected = new HashSet<>(); // 충돌이 이미 감지된 위치
        pathList = new ArrayList[routes.length];

        for (int i = 0; i < routes.length; i++) {
            pathList[i] = new ArrayList<>();
        }

        List<Node> moveList = new ArrayList<>();
        for (int[] point : points) {
            set.add(point[0] + "," + point[1]);
            moveList.add(new Node(point[0], point[1]));
        }

        for (int i = 0; i < routes.length; i++) {
            int startX = moveList.get(routes[i][0] - 1).x;
            int startY = moveList.get(routes[i][0] - 1).y;
            int steps = 0;
            Set<String> visited = new HashSet<>(); // 중복을 방지하기 위한 방문 기록

            for (int j = 0; j < routes[i].length; j++) {
                int endX = moveList.get(routes[i][j] - 1).x;
                int endY = moveList.get(routes[i][j] - 1).y;

                if (j == 0 || !visited.contains(endX + "," + endY)) {
                    pathList[i].add(new Node(startX, startY));
                    while (startX != endX || startY != endY) {
                        steps++;
                        if (startX > endX) {
                            startX--;
                        } else if (startX < endX) {
                            startX++;
                        } else if (startY > endY) {
                            startY--;
                        } else if (startY < endY) {
                            startY++;
                        }
                        pathList[i].add(new Node(startX, startY));
                    }
                    pathList[i].add(new Node(endX, endY));
                    visited.add(endX + "," + endY); // 방문 좌표 추가
                }
            }
            maxPathLength = Math.max(maxPathLength, steps + 1);
        }

        for (int step = 0; step < maxPathLength; step++) {
            HashMap<String, Integer> map = new HashMap<>();
            for (List<Node> path : pathList) {
                if (step < path.size()) {
                    Node currentNode = path.get(step);
                    String key = currentNode.toKey();
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                if (value >= 2 && !collisionDetected.contains(key)) {
                    answer++;
                    collisionDetected.add(key);
                }
            }
        }

        return answer;
    }
}
