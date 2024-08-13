import java.util.*;

public class codeTree_단어삭제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String tmp = sc.next();
        String check = sc.next();

        int count = 0;
        StringBuilder sb;
        int whole = 0;
        Stack<Character> s = new Stack<>();
        while(true){
            count = 0;
            sb = new StringBuilder();
            for(int i=0; i<tmp.length(); i++){
                if(check.length() == 2){
                    if(s.isEmpty()){
                        s.push(tmp.charAt(i));
                    }

                    else{
                        if(s.peek() == check.charAt(0) && tmp.charAt(i) == check.charAt(1)){
                            s.pop();
                            count++;
                        }
                        else{
                            s.push(tmp.charAt(i));
                        }
                    }
                }
                else{
                    if(tmp.charAt(i) != check.charAt(0)){
                        s.push(tmp.charAt(i));
                    }
                    else{
                        count++;
                    }
                }
            }


            if(count == 0){
                if(whole == 0){
                    System.out.println(tmp);
                    break;
                }

                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
                System.out.println(sb);
                break;
            }

            StringBuilder k = new StringBuilder();
            while(!s.isEmpty()){
                k.append(s.pop());
            }
            tmp = String.valueOf(k);
            whole++;
        }
    }
}

// aaaaabbbbb

// 200 198 197


// 앞으로 갈땐 스택 


/*

b
b
b
a
a
a
a
*/