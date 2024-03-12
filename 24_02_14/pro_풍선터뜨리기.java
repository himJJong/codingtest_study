public class pro_풍선터뜨리기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] a) {
                int answer = 2;

                int[] left = new int[a.length];
                int[] right = new int[a.length];

                left[0] = a[0];
                right[a.length-1] = a[a.length-1];

                for(int i=1; i<a.length; i++){
                    left[i] = Math.min(left[i-1],a[i]);
                }

                for(int i=a.length-2; i>=0; i--){
                    right[i] = Math.min(right[i+1],a[i]);
                }

                for(int i=1; i<a.length-1; i++){
                    if(left[i] == a[i] || right[i] == a[i]){
                        answer++;
                    }
                }
                return answer;
            }
        }

// -16, 27, 65, -2, 58, -92, -71, -68, -61 ,-33
// -16, -16, -17, -16, -16, -92, -92, -92, -92, -92
// -92 ,-92, -92 ,-92, -92 ,-92 ,-71 ,-68 ,-61 ,-33


// 9,4, 3, 2, -1,-5



// 1 -> 1
// 2 -> 2
// 3 -> 3
// 4 -> 4
// 5 -> 5
// 6 ->
// 10 -> 6
    }
}
