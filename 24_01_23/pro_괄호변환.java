import java.util.Stack;

public class pro_괄호변환 {
    public static void main(String[] args) {
        String p = "()))((()";
        System.out.println(Solution(p));
    }

    private static String Solution(String p) {
        if(p.equals("")){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] tmp = splitString(p);
        String u = tmp[0];
        String v = tmp[1];

        if(check(u)){
            sb.append(u).append(Solution(v));
        }
        else{
            sb.append('(').append(Solution(v)).append(')').append(convert(u));
        }
        return sb.toString();
    }


    private static String convert(String u) {
        u = u.substring(1);
        u = u.substring(0, u.length() - 1);
        if (u.equals("")) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }

    private static boolean check(String u) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);

            if (c == '(') {
                s.push(c);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                s.pop();
            }
        }

        return s.isEmpty();
    }

    private static String[] splitString(String p) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                String u = p.substring(0, i + 1);
                String v = "";
                if (p.length() >= i + 1) {
                    v = p.substring(i + 1);
                }
                return new String[] {u, v};
            }
        }
        return new String[] {"", ""};
    }
}
