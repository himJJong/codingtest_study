import java.util.*;

public class pro_광물캐기 {
    public static void main(String[] args) {
        int[] picks = {1,3,2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(Solution.solution(picks, minerals));
    }

    static class Solution {
        public static int solution(int[] picks, String[] minerals) {
            int answer = 0;
            int totalPicks = (picks[0] + picks[1] + picks[2]) * 5;
            int len = Math.min(minerals.length, totalPicks);  // 총 캐는 광물의 최대 개수

            // 광물을 5개씩 그룹화
            List<int[]> groups = new ArrayList<>();
            for (int i = 0; i < len; i += 5) {
                int[] group = new int[3];  // 각 그룹에서 다이아, 철, 돌의 개수를 셈
                for (int j = i; j < i + 5 && j < len; j++) {
                    if (minerals[j].equals("diamond")) group[0]++;
                    else if (minerals[j].equals("iron")) group[1]++;
                    else group[2]++;
                }
                groups.add(group);
            }

            // 가장 비싼 그룹부터 처리하기 위해 다이아 > 철 > 돌 기준으로 정렬
            Collections.sort(groups, (a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0];  // 다이아 개수로 내림차순
                if (a[1] != b[1]) return b[1] - a[1];  // 철 개수로 내림차순
                return b[2] - a[2];  // 돌 개수로 내림차순
            });

            // 그룹별로 가장 효율적인 곡괭이 선택
            for (int[] group : groups) {
                if (picks[0] > 0) {  // 다이아 곡괭이로 채굴
                    answer += group[0] * 1 + group[1] * 1 + group[2] * 1;
                    picks[0]--;
                } else if (picks[1] > 0) {  // 철 곡괭이로 채굴
                    answer += group[0] * 5 + group[1] * 1 + group[2] * 1;
                    picks[1]--;
                } else if (picks[2] > 0) {  // 돌 곡괭이로 채굴
                    answer += group[0] * 25 + group[1] * 5 + group[2] * 1;
                    picks[2]--;
                } else {
                    break;  // 사용할 곡괭이가 없으면 중단
                }
            }

            return answer;
        }
    }

}
