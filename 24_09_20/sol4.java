import java.util.*;
import java.io.*;

public class sol4 {
    static char[] oddCharList = {'b', 'd', 'g', 'n', 'p', 'r', 's', 't'};
    static char[] evenCharList = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] hintWords = new String[n];
        int[] correct = new int[n];
        int[] halfCorrect = new int[n];

        for (int i = 0; i < n; i++) {
            String[] hint = br.readLine().split(" ");
            hintWords[i] = hint[0];
            correct[i] = Integer.parseInt(hint[1]);
            halfCorrect[i] = Integer.parseInt(hint[2]);
        }

        List<String> totalWords = new ArrayList<>();     // 가능한 모든 4글자 단어 생성
        for (char c1 : oddCharList) {
            for (char v1 : evenCharList) {
                for (char c2 : oddCharList) {
                    if (c1 != c2) {                         // 첫번째와 세번째 글자는 서로 달라야 함
                        for (char v2 : evenCharList) {
                            if (v1 != v2) {                 // 두번째와 네번째 글자는 서로 달라야 함
                                totalWords.add("" + c1 + v1 + c2 + v2);
                            }
                        }
                    }
                }
            }
        }

        List<String> answerList = new ArrayList<>();
        for (String curWord : totalWords) {
            boolean check = true;
            for (int i = 0; i < n; i++) {   // 조건에 따른 check 결정
                if (!isHintSatisfied(curWord, hintWords[i], correct[i], halfCorrect[i])) {
                    check = false;
                    break;
                }
            }
            if (check) {                    // 정답리스트에 추가
                answerList.add(curWord);
                if(answerList.size() >= 2){ // 만약 정답 리스트가 2 이상이면 더이상 진행하지 않음
                    break;
                }
            }
        }

        if (answerList.size() == 1) {
            System.out.println(answerList.get(0));
        } else {
            System.out.println("x");
        }
    }

    private static boolean isHintSatisfied(String curWord, String hintWord, int correct, int halfCorrect) {
        int exact = 0;
        int partial = 0;
        boolean[] checkCurWord = new boolean[4];
        boolean[] checkHintWord = new boolean[4];

        for (int i = 0; i < 4; i++) {           // 글자 위치와 문자가 같은지 확인
            if (curWord.charAt(i) == hintWord.charAt(i)) {
                exact++;
                checkCurWord[i] = true;
                checkHintWord[i] = true;
            }
        }

        for (int i = 0; i < 4; i++) {           // 위치가 다르지만 포함된 글자 수 계산
            if (!checkHintWord[i]) {            // 앞 for문에서 true처리 되지 않은 것만
                for (int j = 0; j < 4; j++) {
                    if (!checkCurWord[j] && (curWord.charAt(j) == hintWord.charAt(i))) {
                        partial++;
                        checkCurWord[j] = true;
                        break;
                    }
                }
            }
        }
        // 힌트와 비교하여 일치 여부 반환
        return (exact == correct) && (partial == halfCorrect);
    }
}
