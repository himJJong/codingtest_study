public class ZipString {
    public static void main(String[] args) {

    }
    public int solution(String s){
        int ans = 0;
        for(int i=1; i<=s.length()/2; i++){
            int zip = 1;
            String zipStr = s.substring(0,i);
            StringBuilder sb = new StringBuilder();

            for(int j=i; j<=s.length(); j+=i){
                String next = s.substring(j,j+i>s.length()?s.length():i+j);
                if(zipStr.equals(next)) zip++;
                else{
                    sb.append((zip!=1?zip:"")+zipStr);
                    zipStr = next;
                    zip=1;
                }
            }
            sb.append(zipStr);
            ans = Math.min(ans,sb.length());
        }
        return ans;
    }
}

/**
 * 문제 해석
 * 문자열의 절반까지 반복문을 돌린다.
 * 압축할 문자열을 substring 으로 구한다. (ex: abcabc substring(0,2)이면 zipStr = ab)
 * 자른 문자열이 동일할 경우 하나로 압축 가능, 반복 횟수 증가
 * 다른 문자열이 나오는 순간, 반복횟수+문자를 새로운 문자열에 추가
 * 구한 값의 최소값을 Math.min을 통해 구한다.
 **/