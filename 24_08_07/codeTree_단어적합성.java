import java.util.*;

public class codeTree_단어적합성 {
    static char[] mo = {'a','i','o','u','e'};
    static HashMap<Character, Integer> map;
    static HashMap<Character, Integer> map2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new HashMap<>();
        map2 = new HashMap<>();

        for(int i=0; i<5; i++){
            map.put(mo[i],0);
        }
        char a = mo[0];
        for(int i=0; i<26; i++){
            if(!map.containsKey((char)(a+i))){
                char s = (char)(a+i);
                map2.put(s, 0);
            }
        }
        while(N-- >0){
            String tmp = sc.next();
            if(!check(tmp) || !checkThree(tmp) || !checkTwice(tmp)){
                System.out.println(0);
            }

            else{
                System.out.println(1);
            }
        }
    }
    private static boolean checkTwice(String cur){
        String[] tmp = cur.split("");
        for(int i=0; i<tmp.length-1; i++){
            if(tmp[i].equals(tmp[i+1])){
                if(tmp[i].equals("o") || tmp[i].equals("e")){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkThree(String cur){
        for(int i=0; i<cur.length()-2; i++){
            int m = 0;
            int ja = 0;

            for(int j=i; j<3+i; j++){
                if(map.containsKey(cur.charAt(j))){
                    m++;
                }
            }
            ja = 3-m;

            if(ja == 3 || m == 3){
                return false;
            }
        }
        return true;
    }

    private static boolean check(String cur){
        String[] tmp = cur.split("");
        for(int i=0; i<tmp.length; i++){
            for(int j=0; j<5; j++){
                if(tmp[i].equals(String.valueOf(mo[j]))){
                    return true;
                }
            }
        }

        return false;
    }
}

// 1. 모음 1개를 포함(aioue)
// 2. 모음, 자음이 연속 3개를 가지면 안됨
// 3. ee, oo를 제외하고 같은 글자 연속 2번 등장하면 안됨

// 1. 모음 1개가 있는지 체크
// 2. 모음, 자음이 연속 3개를 가지는지 체크
// 3. 같은 글자가 연속 2번 등장하는지