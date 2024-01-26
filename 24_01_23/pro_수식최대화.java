import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pro_수식최대화 {
    public static void main(String[] args) {
        String expression = "10*50*30*40";
        System.out.println(solution(expression));
    }

    public static long solution(String expression) {
        String[][] tmp = {{"*","+","-"},{"+", "*","-"}, {"+", "-", "*"}, {"*", "-", "+"},{"-","*","+"},{"-","+","*"}};
        Long max = Long.MIN_VALUE;
        List<String> tokens = tokenize(expression);

        for(int i=0; i<tmp.length; i++){
            Stack<String> s = new Stack<>();
            List<String> val = tokens;
            for(int j=0; j<3; j++){
                if(j==0){
                    for(int k=0; k<val.size(); k++){
                        if(val.get(k).equals(tmp[i][j])){
                            if(tmp[i][j].equals("*")){
                                long sum = Long.parseLong(s.pop()) * Long.parseLong(val.get(k+1));
                                k++;
                                s.add(String.valueOf(sum));
                            }
                            else if(tmp[i][j].equals("+")){
                                long sum = Long.parseLong(s.pop()) + Long.parseLong(val.get(k+1));
                                k++;
                                s.add(String.valueOf(sum));
                            }
                            else if(tmp[i][j].equals("-")){
                                long sum = Long.parseLong(s.pop()) - Long.parseLong(val.get(k+1));
                                k++;
                                s.add(String.valueOf(sum));
                            }
                        }
                        else{
                            s.add(val.get(k));
                        }
                    }
                }
                else{
                    Stack<String> s1 = new Stack<>();
                    while(!s.isEmpty()){
                        s1.add(s.pop());
                    }
                    int size = s1.size();
                    for(int k=0; k<size; k++){
                        if(s1.peek().equals(tmp[i][j])){
                            if(tmp[i][j].equals("*")){
                                s1.pop();
                                long sum = Long.parseLong(s1.pop()) * Long.parseLong(s.pop());
                                k++;
                                s.add(String.valueOf(sum));
                            }
                            else if(tmp[i][j].equals("+")){
                                s1.pop();
                                long sum = Long.parseLong(s1.pop()) + Long.parseLong(s.pop());
                                k++;
                                s.add(String.valueOf(sum));
                            }
                            else if(tmp[i][j].equals("-")){
                                s1.pop();
                                long sum = Long.parseLong(s.pop()) - Long.parseLong(s1.pop());
                                k++;
                                s.add(String.valueOf(sum));
                            }
                        }
                        else{
                            s.add(s1.pop());
                        }
                    }
                }

            }
            max = Math.max(max, Math.abs(Long.parseLong(s.pop())));
        }

        return max;
    }

    public static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        String pattern = "([0-9]+|[-+*/])";
        Matcher matcher = Pattern.compile(pattern).matcher(input);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}
