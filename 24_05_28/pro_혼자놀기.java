import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class pro_혼자놀기 {
    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(Solution.solution(cards));
    }
    static class Solution {

        public static int solution(int[] cards) {

            boolean[] visited = new boolean[cards.length];
            List<Integer> group = new ArrayList<>();

            for (int i = 0; i < cards.length; i++) {
                int cnt = 0;
                int k = i;
                while (true) {
                    if (!visited[k]) {
                        visited[k] = true;
                        k = cards[k] - 1;
                        cnt++;
                    } else {
                        group.add(cnt);
                        break;
                    }
                }
            }

            List<Integer> answer = group.stream().filter(i -> i != 0).collect(Collectors.toList());

            if (answer.size() == 1) {
                return 0;
            }
            answer.sort((o1, o2) -> o2-o1);
            return answer.get(0) * answer.get(1);


        }

    }
}
