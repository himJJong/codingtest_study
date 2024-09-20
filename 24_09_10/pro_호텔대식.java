import java.util.*;
class pro_호텔대식 {
    static class Node implements Comparable<Node>{
        int s;
        int e;

        Node(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node o){
            return this.s - o.s;
        }
    }
    public int solution(String[][] book_time) {
        List<Integer> rooms = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int answer = 0;
        for(int i=0; i<book_time.length; i++){
            String[] tmp1 = book_time[i][0].split(":");
            String[] tmp2 = book_time[i][1].split(":");

            int num1 = Integer.parseInt(tmp1[0]) * 100 + Integer.parseInt(tmp1[1]);
            int num2 = Integer.parseInt(tmp2[0]) * 100 + Integer.parseInt(tmp2[1]);

            pq.add(new Node(num1, num2));
        }

        while(!pq.isEmpty()){
            if(rooms.size() == 0){
                rooms.add(pq.poll().e);
                continue;
            }
            boolean flag = false;
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i=0; i<rooms.size(); i++){
                int adjustedRoomTime = change(rooms.get(i) + 10);

                if(pq.peek().s >= adjustedRoomTime && pq.peek().s - adjustedRoomTime < min){
                    min = pq.peek().s - adjustedRoomTime;
                    index = i;
                    flag = true;
                }
            }

            if(!flag){
                rooms.add(pq.poll().e);
            }
            else{
                rooms.set(index, pq.poll().e);
            }
        }



        return rooms.size();
    }
    private int change(int time) {
        int hours = time / 100;
        int minutes = time % 100;

        if(minutes >= 60){
            hours += 1;
            minutes -= 60;
        }

        return hours * 100 + minutes;
    }
}

//우선순위 큐
// 빨리 입실하는 순서대로 정렬하고
// 그다음 입실 시간 중 현재 방을 이용하고 있는 사람들 중 퇴실 시간을 체크 후 
// 나와야한다면, 빼고 그 방에 넣고, 넣을데가 없다면 새로 방 생성

// 1개 입실 기준 오름차순 정렬과
// 배열리스트로 하나의 공간이 방으로 생각하고, 어차피 하나씩 들어가고, 해당을 시간으로 보지말고
// 18:20 -> 1820, 어차피 숫자는 커지는 것으로 생각하면 될듯

// List<Integer> list = new Arr