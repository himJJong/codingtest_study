public class 기출복기1 {

    public static int maxSatisfied(int[][] preferences) {
        int n = preferences.length;  // 사람의 수
        int m = preferences[0].length;  // 토핑의 수
        int maxSatisfiedCount = 0;

        // 모든 반쪽의 토핑 조합을 탐색 (각 반쪽은 2^m 가지 경우가 존재)
        for (int half1 = 0; half1 < (1 << m); half1++) {
            for (int half2 = 0; half2 < (1 << m); half2++) {
                int satisfiedCount = 0;

                System.out.println("Checking combination: half1 = " + Integer.toBinaryString(half1) + ", half2 = " + Integer.toBinaryString(half2));

                // 각 사람마다 만족도를 체크
                for (int j = 0; j < n; j++) {
                    int[] person = preferences[j];
                    boolean satisfiedHalf1 = true;
                    boolean satisfiedHalf2 = true;

                    // 첫 번째 반쪽에 대해 만족 여부를 확인
                    for (int i = 0; i < m; i++) {
                        if (person[i] == 1 && (half1 & (1 << i)) == 0) { // 해당 토핑을 만족해야 하는데, 없으니까? false
                            satisfiedHalf1 = false;
                        }
                        if (person[i] == -1 && (half1 & (1 << i)) != 0) { // 해당 토핑을 불만족해야 하는데, 있으니까? false
                            satisfiedHalf1 = false;
                        }
                    }

                    // 두 번째 반쪽에 대해 만족 여부를 확인
                    for (int i = 0; i < m; i++) {
                        if (person[i] == 1 && (half2 & (1 << i)) == 0) { // 해당 토핑을 만족해야 하는데, 없으니까? false
                            satisfiedHalf2 = false;
                        }
                        if (person[i] == -1 && (half2 & (1 << i)) != 0) { // 해당 토핑을 불만족해야 하는데, 있으니까? false
                            satisfiedHalf2 = false;
                        }
                    }

                    // 각 사람의 만족 여부 출력
                    System.out.println("Person " + (j + 1) + " with preferences " + java.util.Arrays.toString(person) +
                            " - satisfiedHalf1: " + satisfiedHalf1 + ", satisfiedHalf2: " + satisfiedHalf2);

                    // 두 반쪽 중 하나라도 만족하면 해당 사람은 만족
                    if (satisfiedHalf1 || satisfiedHalf2) {
                        satisfiedCount++;
                    }
                }

                // 최대 만족 인원수를 갱신
                maxSatisfiedCount = Math.max(maxSatisfiedCount, satisfiedCount);

                System.out.println("Satisfied count for this combination: " + satisfiedCount);
                System.out.println();
            }
        }

        return maxSatisfiedCount;
    }

    public static void main(String[] args) {
        int[][] preferences = {
                {1, 0},  // 사람 1의 선호도: 토핑 1을 선호하고, 토핑 2는 상관없음
                {-1, 1}  // 사람 2의 선호도: 토핑 1을 싫어하고, 토핑 2를 선호함
        };
        System.out.println("Maximum satisfied count: " + maxSatisfied(preferences));  // Expected: 1

        // 테스트 케이스 1
        int[][] preferences1 = {
                {1, 1, 0, -1},
                {0, 1, 1, -1},
                {1, 0, -1, -1},
                {1, 0, 0, 1}
        };
        System.out.println("Maximum satisfied count: " + maxSatisfied(preferences1));  // Expected: 3

        // 테스트 케이스 2
        int[][] preferences2 = {
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1},
                {-1, -1, -1, -1, 0},
                {0, -1, -1, -1, -1}
        };
        System.out.println("Maximum satisfied count: " + maxSatisfied(preferences2));  // Expected: 5

        // 테스트 케이스 3
        int[][] preferences3 = {
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1}
        };
        System.out.println("Maximum satisfied count: " + maxSatisfied(preferences3));  // Expected: 2

        // 테스트 케이스 4
        int[][] preferences4 = {
                {0, 1, 1, 0},
                {1, 1, -1, -1},
                {-1, 0, 1, 1},
                {-1, -1, -1, 1},
                {1, 1, 0, -1}
        };
        System.out.println("Maximum satisfied count: " + maxSatisfied(preferences4));  // Expected: 4
    }
}
