import java.util.*;
public class pro_우박수열 {
    class Solution {
        public double[] solution(int s, int[][] ranges) {
            double[] answer = new double[ranges.length];


            List<Double> list = new ArrayList<>();
            int cnt = 0;
            double k = s;

            while(k != 1){
                cnt++;
                list.add(k);
                if(k % 2 == 0){
                    k /= 2;
                }
                else{
                    k = (k * 3)+1;
                }
            }
            list.add(k);
            for(int i=0;i<ranges.length; i++){
                if(ranges[i][1] <= 0){
                    ranges[i][1] = list.size() - 1 + ranges[i][1];
                }
                System.out.print("비교 : " +ranges[i][1] +" ");
            }


            Double[] area = new Double[cnt+1];  // 6

            for(int i=0; i<cnt; i++){
                if(list.get(i) < list.get(i+1)){
                    area[i+1] = (list.get(i+1) - (list.get(i+1) - list.get(i))/2);
                }
                else{
                    area[i+1] = (list.get(i) - (list.get(i)-list.get(i+1))/2);
                }
            }

            double[] sum = new double[cnt+1];

            sum[1] = area[1];
            for(int i=2; i<cnt+1; i++){
                sum[i] += sum[i-1] + area[i];
            }

            for(int i=0; i<ranges.length; i++){
                int st = ranges[i][0];
                int e = ranges[i][1];



                if(e > st){
                    double val = sum[e] - sum[st];
                    String str = String.format("%.1f", val);
                    answer[i] = (Double.parseDouble(str));
                }else if(st > e){
                    answer[i] = -1.0;
                }else{
                    answer[i] = 0.0;
                }

            }

            return answer;
        }
    }
}
