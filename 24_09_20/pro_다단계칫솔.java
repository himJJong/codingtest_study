import java.util.*;

class pro_다단계칫솔 {
    static class Node{
        String refer;
        int money;

        Node(String refer, int money){
            this.refer = refer;
            this.money = money;
        }
    }
    static HashMap<String, Node> map = new HashMap<>();;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], new Node(referral[i], 0));
        }

        for(int i=0; i<seller.length; i++){
            int profit = amount[i] * 100;
            String cur = seller[i];

            while(!cur.equals("-")){
                Node sellerNode = map.get(cur);
                int com = profit / 10;
                int sellerProfit = profit - com;

                sellerNode.money += sellerProfit;
                profit = com;

                if(profit<1)    break;

                cur = sellerNode.refer;
            }
        }
        for(int i=0; i<enroll.length; i++){
            answer[i] = map.get(enroll[i]).money;
        }

        return answer;
    }
}