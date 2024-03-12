import java.util.*;

class pro_과제진행 {
    public static void main(String[] args) {
        String[][] plan = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(solution(plan));
    }
    static class Subject implements Comparable<Subject>{
        String name;
        int start, playtime;
        Subject(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Subject s){
            return this.start - s.start; //시작시간 오름차순 정렬
        }
    }


    public static String[] solution(String[][] plans) {
        String[] answer = {};
        //과제를 끝낸 순서대로 이름을 배열에 담아 return
        //새로 시작한 과제 -> 중간에 멈춘 과제

        answer = new String[plans.length];
        int idx = 0;
        PriorityQueue<Subject> q = new PriorityQueue<>((o1, o2)->(o1.start-o2.start)); // 시간순서대로 있는 과제
        for(String[] p:plans){
            q.add(new Subject(p[0], convertTime(p[1]), Integer.parseInt(p[2])));
        }

        // q는 과제 시작 시간 오름차순으로 정렬된 것
        Subject s = q.poll(); // 제일 빠른 과목
        int now = s.start; // 현재 시작 시간

        Stack<Subject> stack = new Stack<>(); // 해야할 과제들
        while(true){
            // 해야할 과제가 있으면서 현재 해야할 과제 시작 + 진행 시간이 다음 해야할 과제의 시작 시간보다 많다면
            // 현재 과제를 중지하고 다음것을 해야해. 그리고 그 동안의 진행할 수 있는 만큼은 진행해야함
            if(!q.isEmpty() && now + s.playtime > q.peek().start){

                //과제 중지
                stack.push(new Subject(s.name, s.start, s.playtime-(q.peek().start-now)));

                now = q.peek().start;

                s = q.poll(); //새로운 과제 시작
            }

            // 동시에 과제가 끝나거나, 다음 시작 시간까지 시간이 여유로워야 하거나 해야할 과제가 없다면
            else{
                //과제 끝냄
                answer[idx++] = s.name;
                now += s.playtime;

                //새로 시작해야 하는 과제가 있고, 끝나자 마자 과제를 시작할 수 있다면
                if(!q.isEmpty() && now==q.peek().start){
                    s = q.poll();
                }
                else if(!stack.isEmpty()){
                    //멈춰둔 과제 다시 시작
                    s = stack.pop();
                }
                else if(!q.isEmpty()){
                    s = q.poll();
                    now = s.start;
                }
                else break;
            }
        }

        return answer;
    }

    public static int convertTime(String t){
        String[] str = t.split(":");
        int min = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
        return min;
    }
}