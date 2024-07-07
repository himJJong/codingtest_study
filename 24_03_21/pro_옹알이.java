import java.util.*;

public class pro_옹알이 {
    class Solution {
        public int solution(String[] babbling) {
            HashSet<String> hs = new HashSet<>();

            hs.add("aya");
            hs.add("woo");
            hs.add("ye");
            hs.add("ma");

            int answer = 0;

            for(int i=0; i<babbling.length; i++){
                String[] tmp = babbling[i].split("");
                String memory = "";
                boolean flag = true;
                String index = "";
                for(int j=0; j<tmp.length; j++){
                    memory += tmp[j];
                    if(memory.length() >= 4){
                        flag = false;
                        break;
                    }
                    if(hs.contains(memory) && !index.equals(memory)){
                        index = memory;
                        memory = "";
                    }
                }
                if(!memory.equals("")){
                    continue;
                }
                if(flag)    {
                    answer++;
                }
            }
            return answer;
        }
    }
}
