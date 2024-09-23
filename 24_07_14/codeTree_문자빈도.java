import java.util.*;

public class codeTree_문자빈도 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashMap<String, Integer> map;

        while(N-- >0){
            map = new HashMap<>();
            String[] tmp = sc.next().split("");
            Stack<String> s = new Stack<>();
            for(int i=0; i<tmp.length; i++){
                if(map.containsKey(tmp[i])){
                    map.put(tmp[i], map.get(tmp[i]) + 1);
                }
                else{
                    map.put(tmp[i], 1);
                    s.add(tmp[i]);
                }
            }

            int cnt = 0;
            int max = 0;
            String answer = "";

            while(!s.isEmpty()){
                String cur = s.pop();

                if(map.get(cur) > max){
                    answer = cur;
                    cnt = 1;
                    max = map.get(cur);
                }
                else if(map.get(cur) == max){
                    cnt++;
                }
            }

            if(cnt == 1){
                System.out.println(answer);
            }
            else if( cnt > 1 ) {
                System.out.println("?");
            }
        }
    }
}