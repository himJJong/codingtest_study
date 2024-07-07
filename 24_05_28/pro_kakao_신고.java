import java.util.*;
public class pro_kakao_신고 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Solution.solution(id_list, report, k));
    }
    static class Solution {
        public static int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            int[] count = new int[id_list.length];

            List<String> person = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            List<HashSet<String>> list = new ArrayList<>();

            for(int i=0; i<id_list.length; i++){
                list.add(new HashSet<>());
            }

            for(int i=0;i<id_list.length; i++){
                map.put(id_list[i], i);
            }

            for(int i=0; i<report.length; i++){
                String[] tmp = report[i].split(" ");
                int index = map.get(tmp[0]);

                if(!list.get(index).contains(tmp[1])){
                    count[index]++;
                    list.get(index).add(tmp[1]);
                }
            }
            for(int i=0; i<id_list.length; i++){
                if(count[i] >= k){
                    person.add(id_list[i]);
                }
            }

            for(int i=0; i<list.size(); i++){
                int sum = 0;
                for(int j=0; j<person.size(); j++){
                    if(list.get(i).contains(person.get(j))){
                        sum++;
                    }
                }
                answer[i] = sum;
            }
            return answer;
        }
    }
}
