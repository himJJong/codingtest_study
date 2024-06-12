import java.util.*;

public class pro_다단계칫솔 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Solution.solution(enroll, referral, seller, amount));

    }

    static class Solution {
        public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            HashMap<String, String> data = new HashMap<>();
            HashMap<String, Integer> money = new HashMap<>();

            for(int i=0; i<enroll.length; i++){
                data.put(enroll[i], referral[i]);
                money.put(enroll[i], 0);
            }

            for(int i=0; i<seller.length; i++){
                int benefit = amount[i] * 100;  // 본인의 이익
                String check = seller[i];   //본인의 이름
                while(true){
                    if(data.get(check).equals("-")){    // 최상위 부모 자식일때

                        int upSide = (int) (benefit * 0.1);
                        int my = benefit - upSide;

                        if(upSide < 1){ //본인이 모두 가짐
                            money.put(check, money.get(check) + benefit);
                        }
                        else{ // 내꺼와 위로 올릴 것 체크
                            if(check.equals("mary")){
                                System.out.println(money.get("mary"));
                            }
                            money.put(check, money.get(check) + my);
                        }
                        break;
                    }
                    else{   // 그 아래일때
                        int upSide = (int) (benefit * 0.1);
                        int my = benefit - upSide;
                        if(check.equals("mary")){
                            System.out.println(money.get("mary"));
                        }

                        if(upSide < 1){ //본인이 모두 가짐
                            money.put(check, money.get(check) + benefit);
                            break;
                        }
                        else{ // 내꺼와 위로 올릴 것 체크
                            money.put(check, money.get(check) + my);
                        }
                        benefit = upSide;
                        check = data.get(check);
                    }
                }
            }


            int[] answer = new int[enroll.length];
            for(int i=0; i<enroll.length; i++){
                answer[i] = money.get(enroll[i]);
            }


            return answer;
        }
    }
// 연결 -> 어떻게? (해시맵)
// seller 정보에 따라 이익 분배
// 1. 해당 노드를 선택해서 상위로 올라가며 이익 배분
// 연결 -> 어떻게? (해시맵)
// seller 정보에 따라 이익 분배
// 1. 해당 노드를 선택해서 상위로 올라가며 이익 배분
}
