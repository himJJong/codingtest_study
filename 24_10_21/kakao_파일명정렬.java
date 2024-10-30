import java.util.*;
import java.io.*;

class kakao_파일명정렬 {
    static class Node implements Comparable<Node>{
        String head;
        String num;
        String file;

        Node(String head, String num, String file){
            this.head = head.toUpperCase();
            this.num = num;
            this.file = file;
        }

        @Override
        public int compareTo(Node o){
            int headVal = this.head.compareTo(o.head);
            if (headVal == 0) {
                return Integer.parseInt(this.num) - Integer.parseInt(o.num);
            }
            return headVal;
        }
    }

    public String[] solution(String[] files) {
        List<Node> list = new ArrayList<>();
        String[] answer = new String[files.length];
        StringBuilder headSb;
        StringBuilder numSb;

        for(int i=0; i<files.length; i++){
            headSb = new StringBuilder();
            numSb = new StringBuilder();
            boolean flag = false;
            for(int j=0; j<files[i].length(); j++){
                char currentChar = files[i].charAt(j);
                if (Character.isDigit(currentChar)) {
                    numSb.append(currentChar);
                    if(!flag) flag = true;
                }
                else if (!flag) {
                    headSb.append(currentChar);
                }
                else {
                    break;
                }
            }
            list.add(new Node(headSb.toString(), numSb.toString(), files[i]));
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).file;
        }
        return answer;
    }
}