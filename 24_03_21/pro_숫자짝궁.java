import java.util.*;

public class pro_숫자짝궁 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("100", "203045"));
    }
    static class Solution {
        public static String solution(String X, String Y) {
            String answer = "";
            HashMap<Character,Integer> xSet = new HashMap<>();
            HashMap<Character,Integer> ySet = new HashMap<>();

            for(int i=0;i<X.length(); i++){
                xSet.put(X.charAt(i), xSet.getOrDefault(X.charAt(i), 0)+1);
            }

            for(int i=0;i<Y.length(); i++){
                ySet.put(Y.charAt(i), ySet.getOrDefault(Y.charAt(i), 0)+1);
            }
            StringBuilder sb = new StringBuilder();
            for(int i=9; i>=0; i--){
                char x = Character.forDigit(i , 10);
                if(!xSet.containsKey(x) || !ySet.containsKey(x))   continue;
                if(xSet.get(x) != 0 && ySet.get(x) != 0){
                    int k = Math.min(xSet.get(x), ySet.get(x));

                    while(k-- > 0){
                        sb.append(i);
                    }
                }

            }
            return sb.toString();
        }
    }
// 3403
//13233

//5525
//1255
}
