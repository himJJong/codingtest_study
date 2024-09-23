import java.util.*;

class pro_베스트셀러 {
    static class Node {
        int totalPlay;
        PriorityQueue<Song> pq;

        Node(int totalPlay) {
            this.totalPlay = totalPlay;
            this.pq = new PriorityQueue<>();
        }
    }

    static class Song implements Comparable<Song> {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                return this.index - o.index;
            }
            return o.play - this.play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별로 총 재생 수와 곡 정보를 저장할 HashMap 생성
        HashMap<String, Node> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 해당 장르가 처음 나오는 경우 새로운 Node 생성
            if (!map.containsKey(genre)) {
                Node node = new Node(play); // 새로운 Node 생성, 재생 수를 현재 곡의 재생 수로 설정
                node.pq.offer(new Song(i, play)); // 우선순위 큐에 현재 곡 추가
                map.put(genre, node); // 해시맵에 추가
            } else {
                // 해당 장르가 이미 존재하는 경우
                Node node = map.get(genre);
                node.totalPlay += play; // 기존 총 재생 수에 현재 곡의 재생 수 더함
                node.pq.offer(new Song(i, play)); // 우선순위 큐에 곡 추가
            }
        }

        // 2. 장르별 총 재생 수를 기준으로 정렬하기 위해 리스트로 변환
        List<Map.Entry<String, Node>> genreList = new ArrayList<>(map.entrySet());

        // 총 재생 수를 기준으로 장르 정렬
        Collections.sort(genreList, new Comparator<Map.Entry<String, Node>>() {
            @Override
            public int compare(Map.Entry<String, Node> o1, Map.Entry<String, Node> o2) {
                return o2.getValue().totalPlay - o1.getValue().totalPlay; // 총 재생 수가 큰 순서대로 정렬
            }
        });

        // 3. 정렬된 장르별로 상위 2곡씩 선택
        List<Integer> resultList = new ArrayList<>();

        for (Map.Entry<String, Node> entry : genreList) {
            Node node = entry.getValue(); // 각 장르에 해당하는 Node 가져오기
            int count = 0; // 상위 2곡까지만 선택하기 위한 카운터

            // 우선순위 큐에서 상위 곡들을 꺼내서 결과 리스트에 추가
            while (!node.pq.isEmpty() && count < 2) {
                resultList.add(node.pq.poll().index); // 우선순위 큐에서 곡을 하나 꺼내고 인덱스를 결과 리스트에 추가
                count++; // 선택한 곡 수 증가
            }
        }

        // 4. 리스트를 배열로 변환하여 반환
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}
