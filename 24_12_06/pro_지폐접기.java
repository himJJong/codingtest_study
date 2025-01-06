public class pro_지폐접기 {
    class Solution {
        public int solution(int[] wallet, int[] bill) {
            int cnt = 0;
            while(true){
                if(bill[0] <= wallet[0] && bill[1] <= wallet[1]){
                    break;
                }
                if(bill[1] <= wallet[0] && bill[0] <= wallet[1]){
                    break;
                }
                cnt++;

                if(bill[0] > bill[1]){
                    bill[0] = bill[0] / 2;
                }
                else if(bill[1] > bill[0]){
                    bill[1] = bill[1] / 2;
                }
                else{
                    bill[0] = bill[0] / 2;
                }
            }

            return cnt;
        }
    }
}
