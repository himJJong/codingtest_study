import java.util.*;
public class MaximizeFormula {
    public static void main(String[] args) {

    }
    public static long solution(String expression){
        long ans = Long.MIN_VALUE;

        // 만들 수 있는 연산자 조합
        String op[][] = {{"+","-","*"},{"+","*","-"},{"-","*","+"},
                {"-","+","*"},{"*","-","+"},{"*","+","-"}};
        ArrayList<String> list = new ArrayList<String>();
        int start = 0;


        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '+'){
                list.add(expression.substring(start,i));
                list.add(expression.charAt(i)+"");
                start = i+1;
            }
        }
        list.add(expression.substring(start));

        for(int i=0; i<op.length; i++){
            ArrayList<String> sub_list = new ArrayList<>(list);
            for(int k=0; k<3; k++){
                for(int j=0; j<sub_list.size(); j++){
                    if(op[i][k].equals(sub_list.get(j))){
                        sub_list.set(j-1, calc(sub_list.get(j-1), sub_list.get(j),sub_list.get(j+1)));
                        sub_list.remove(j);
                        sub_list.remove(j);
                        j--;
                    }
                }
            }
            ans = Math.max(ans, Math.abs(Long.parseLong(sub_list.get(0))));
        }
        return ans;
    }
    private static String calc(String num1, String op, String num2){
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
        if(op.equals("+"))
            return n1+n2+"";
        else if(op.equals("-"))
            return n1-n2+"";
        else return n1*n2+"";
    }
}

/**
 * 문제 해석
 * 주어진 *,+,- 연산으로 만들 수 있는 조합을 OP 배열에 저장한다.
 * expression을 확인하여 연산자가 포함되어 있으면, 연산자 전,후를 나눈다.
 * 주어진 연산자에 해당한다면, 해당 계산을 calc를 통해 진행한다.
 * 이후, 계산된 값을 변수 ans에 넣고, 다른 경우에도 계산된 값의 절댓값과 비교하여, 더 큰 값을 반ㅏㄴ한다.
 **/