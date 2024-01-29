import java.util.Stack;
public class ChangeBracket {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
    }
    public static String solution(String p) {
        if(check(p)) return p;
        else return dfs(p);
    }

    private static boolean check(String p){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            if(c=='(') st.add(c);
            else{
                if(st.isEmpty()) return false;
                else st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        else return true;
    }

    private static String dfs(String p){
        // 1.
        if(p.isEmpty()) return p;

        // 2.
        String u = "", v= "";
        int idx1=0, idx2=0;
        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            if(c=='(') idx1++;
            else idx2++;

            if(((idx1 > 0) && (idx2>0)) && (idx1==idx2)){
                u = p.substring(0,i+1);
                if(i<p.length()-1) v = p.substring(i+1);
                break;
            }
        }

        // 3.
        if(check(u)) return u+dfs(v);
        // 4.
        else{
            StringBuilder sb = new StringBuilder();
            String tmp = "(" + dfs(v)+")";
            u = u.substring(1,u.length()-1);
            u = u.replace("(",".");
            u = u.replace(")","(");
            u = u.replace(".",")");
            sb.append(tmp);
            sb.append(u);
            return sb.toString();
        }
    }
}

/**
 * 문제 해석
 * 주어진 p가 올바른 괄호 문자열인지 확인한다.
 * 올바른 괄호 문자열이라면 그대로 반환하고 아니라면, dfs()의 과정을 통해 값을 가져온다.
 * dfs()는 주어진 과정을 그대로 옮겨 담은 것이다.
 * 1. 입력이 빈 문자열일 경우 (=p.isEmpty()), 빈 문자열을 반환. (=return p)
 * 2. 문자열을 두 "균형잡힌 괄호 문자열" u,v로 분리. 단, u는 더 이상 분리를 할 수 없어야 함.
 * '('의 인덱스 idx1, ')'의 인덱스 idx2로 변수를 놓는다.
 * 문자열 p에서 '('가 존재하면 idx1의 값이 증가하고, ')'이 존재하면 idx2의 값이 증가한다.
 * idx1, idx2의 값이 0보다 클 때, 두 값이 같다면 '('와 ')'의 갯수가 같은 것이므로 "균형잡힌 괄호 문자열"이 된다.
 * 해당 인덱스까지 substring을 통해 u에 넣고, 나머지 값을 v에 넣는다.
 * 3. u가 "올바른 괄호 문자열"이라면(=check(u)==true) v에 대해서 1단계부터 다시 진행한다.(=dfs(v))
 * 3-1. 수행한 결과를 문자열 u에 이어 붙인 후 반환(=return u+dfs(v))
 * 4. u가 "올바른 괄호 문자열"이 아니라면(=check(u)==false), 아래 과정을 수행
 * 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙임. (String tmp = "(")
 * 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과를 이어 붙임(=tmp+dfs(v))
 * 4-3. ')'를 다시 이어 붙임(=tmp+')') (4.1 ~ 4.3 : tmp = "("+dfs(v)+")")
 * 4-4. u의 첫 번째 문자와 마지막 문자를 제거(=u.substring(1,u.length()-1)),
 * 나머지 문자열의 괄호 방향을 뒤집는다.'(' -> ')', ')'->'('로 변경
 * 4-5. 생성된 문자열을 반환(=return)
 **/

/**
 * 놓친 점
 * 초기에도 주어진 p가 올바른 괄호 문자열인지를 판단하는 것이 필요함.
 * 때문에 올바른 괄호 문자열인지 판단하는 check()함수를 만들어 4번 과정에도 사용하였다.
 **/


