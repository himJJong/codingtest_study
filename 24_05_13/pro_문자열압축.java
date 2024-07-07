public class pro_문자열압축 {
    class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;
            StringBuilder sb;
            for(int i=1; i<=s.length(); i++){
                // 문자열 자르기 해당 표현대로
                String[] tmp = new String[s.length()/i + 1];

                for(int j=0; j<s.length()/i + 1 ; j++){
                    if(i*j+i >= s.length()){
                        tmp[j] = s.substring(i*j);
                    }
                    else{
                        tmp[j] = s.substring(i*j, i*j+i);
                    }
                }
                sb = new StringBuilder();
                String cur = tmp[0];
                int count = 1;

                if(tmp.length == 1){
                    answer = Math.min(answer, s.length());
                    continue;
                }
                for(int j=1; j<tmp.length; j++){
                    if(cur.equals(tmp[j])){
                        count++;
                    }
                    else{

                        if(count == 1){
                            sb.append(cur);
                            cur = tmp[j];
                        }
                        else{
                            sb.append(count).append(cur);
                            cur = tmp[j];
                            count = 1;
                        }

                        if(j==tmp.length-1){
                            sb.append(cur);
                        }
                    }
                }
                answer = Math.min(answer, sb.toString().length());
                // 길이 체크
            }
            return answer;
        }
    }
}
