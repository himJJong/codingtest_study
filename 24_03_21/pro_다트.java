public class pro_다트 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("1D2S#10S"));
    }
    static class Solution {
        public static int solution(String dartResult) {
            int answer = 0;
            int[] num = {1,1,1};
            int[] cal = {1,1,1};
            String[] str = new String[3];
            int numIndex = 0;
            int strIndex = 0;

            for(int i=0; i<dartResult.length(); i++){
                char ch = dartResult.charAt(i);

                if(Character.isDigit(ch) && Character.isDigit(dartResult.charAt(i+1))){
                    cal[numIndex] *= 10;
                    numIndex++;
                    i++;
                }
                else if(Character.isDigit(ch)){
                    cal[numIndex] *= Integer.parseInt(Character.toString(ch));
                    numIndex++;
                }
                else if(ch == 'S' || ch == 'D' || ch == 'T'){
                    str[strIndex] = Character.toString(ch);
                    strIndex++;
                }
                else{
                    if(ch == '*'){
                        if(i == 2){
                            num[0] *= 2;
                        }
                        else if(i== 4 || i == 5){
                            num[0] *= 2;
                            num[1] *= 2;
                        }
                        else if(i == 6 || i == 7 || i == 8){
                            num[1] *= 2;
                            num[2] *= 2;
                        }
                    }
                    else if(ch == '#'){
                        num[numIndex-1] *= -1;
                    }
                }
            }

            for(int i=0; i<3 ; i++){
                if(str[i].equals("S")){
                    answer += num[i] * cal[i];
                }
                else if(str[i].equals("D")){
                    answer += num[i] * cal[i] * cal[i];
                }
                else {
                    answer += num[i] * cal[i] * cal[i] * cal[i];
                }
            }

            return answer;
        }
    }

// 3
// 5, 6
// 7, 8, 9
}
