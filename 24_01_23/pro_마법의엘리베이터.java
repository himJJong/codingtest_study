import java.util.Deque;
import java.util.LinkedList;

public class pro_마법의엘리베이터 {
    public static void main(String[] args) {
        System.out.println(solution(75));
    }

    public static int solution(int storey) {
        int answer = 0;

        Deque<Integer> q = new LinkedList<>();
        String[] tmp = String.valueOf(storey).split("");

        for(int i=0; i<tmp.length; i++){
            q.addLast(Integer.parseInt(tmp[i]));
        }

        boolean flag = false;
        while(!q.isEmpty()){
            int cur = q.pollLast();
            if(flag)    cur++;
            if(flag && cur == 10 && q.isEmpty()){
                answer++;
                break;
            }
            else if(flag && cur == 10){
                continue;
            }

            if(cur <=4){
                answer += cur;
                flag = false;
            }
            else if(cur == 5){
                if(!q.isEmpty()){
                    if(q.peekLast() <= 4){
                        answer += 5;
                        flag = false;
                    }
                    else{
                        answer += 5;
                        flag = true;
                    }
                }
                else{
                    answer += 5;
                    flag = false;
                }
            }
            else{
                answer += 10 -cur;
                if(q.isEmpty()) {
                    q.addLast(1);
                    flag = false;
                    continue;
                }
                flag = true;
            }
        }


        return answer;
    }
}
