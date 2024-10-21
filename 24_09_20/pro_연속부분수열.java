import java.util.*;

class pro_연속부분수열 {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int[][] arr = new int[elements.length+1][elements.length+1];

        for(int i=0; i<elements.length; i++){
            arr[1][i] = elements[i];
            //System.out.print(arr[1][i] +" ");
        }
        //System.out.println();

        for(int i=2; i<elements.length; i++){
            for(int j=0; j<elements.length; j++){
                arr[i][j] = arr[i-1][j] + arr[1][(j+i-1) % elements.length];
                //System.out.print(arr[i][j]+" ");
            }
            //System.out.println();
        }

        for(int i=1; i<elements.length; i++){
            for(int j=0; j<elements.length; j++){
                set.add(arr[i][j]);
            }
        }
        return set.size()+1;
    }
}
// [1]
// [2]
// [3]

//  7  9 1   1  4
// 16 10 2   5  11
// 17 11 6  12  22
// 18 15 13 21  21