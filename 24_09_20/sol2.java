import java.io.*;
import java.util.*;

/*
Trie 문자열 탐색
조건이 있음. 소문자 대문자 거나 문자열 길이가 길면 메모리 사용량이 많아짐.
containsSubstring 메서드를 호출하는데, 이때 시간 복잡도는 O(N^2)입니다.
insert 메서드를 호출하는데, 시간 복잡도는 O(M)입니다.
단어의 개수가 n이므로 전체 시간 복잡도는 최악의 경우 O(n * (N^2))
*/
class sol2 {
    static class TrieNode {
        Map<Character, TrieNode> childTrieNode = new HashMap<>();
        boolean check = false;
    }

    static class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;              // 현재 노드를 루트에서 시작
            for (char c : word.toCharArray()) {   // current 위치를 타면서 입력 단어의 각 문자에 대해 반복
                // currnet에서 현재 문자에 해당하는 Char 없으면 추가 생성
                current = current.childTrieNode.computeIfAbsent(c, plusKey -> new TrieNode());
            }
            current.check = true; // 단어의 끝임을 표시

        }

        public boolean containsSubstring(String word) {
            for (int i = 0; i < word.length(); i++) {
                TrieNode current = root;
                for (int j = i; j < word.length(); j++) {   // word 길이만큼
                    char c = word.charAt(j);
                    current = current.childTrieNode.get(c); // current에서 현재 문자 c검색

                    if (current == null) break;             // 문자가 없으면 종료
                    if (current.check) {                    // 현재 노드가 단어의 끝이면
                        return true;                        // 부분 문자열이 Trie에 존재함
                    }
                }
            }
            return false; // 모든 부분 문자열을 탐색했으나 발견하지 못함
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (trie.containsSubstring(word)) { // 현재 단어가 Trie에 있는지 확인
                results.add(word);              // 이전 단어가 포함된 경우 결과 리스트에 추가
            }
            trie.insert(word);                  // 현재 단어를 Trie에 삽입
        }

        for (String result : results) {
            System.out.println(result);         // 결과 리스트에 있는 단어 출력
        }
    }
}
