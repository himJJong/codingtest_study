class pro_연속숫자 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = sequence.length - 1;
        int right = sequence.length - 1;

        int check = 0;
        int answerSize = Integer.MAX_VALUE;

        while (left >= 0) {
            if (check < k && right >= 0) {
                check += sequence[right--];
            }
            else if (check >= k) {
                if (check == k && answerSize >= (left - right)) {
                    answer[0] = right + 1;
                    answer[1] = left;
                    answerSize = left - right;
                }
                check -= sequence[left--];
            }
            else {
                break;
            }
        }

        return answer;
    }
}

// 투포인터
