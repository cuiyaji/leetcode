package Robinhood;

import java.util.Arrays;

public class IsSubmatrixFull {
    public boolean[] isSubmatrixFull(int[][] numbers) {
        //corner case
        if (numbers.length < 3 || numbers[0].length < 3) {
            return new boolean[]{false};
        }
        //
        int row = numbers.length;
        int col = numbers[0].length;
        // get all sum of cols
        int[] colSum = new int[col];
        for(int j = 0; j < col; j++) {
            int curSum = 0;
            for (int i = 0; i < row; i++) {
                curSum += numbers[i][j];
            }
            colSum[j] = curSum;
        }
        // check all the square: if the sum of three col == 45 true
        boolean[] res = new boolean[col - 2];
        for (int i = 0; i < col - 2; i++) {
            int count = 0;
            int curSqSum = 0;
            while (count < 3) {
                curSqSum += colSum[i + count++];
            }
            res[i] = (curSqSum == 45);
        }
         return res;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3,2,5,7},{4,5,6,1,7,6},{7,8,9,4,8,3}};
        System.out.println(Arrays.toString(new IsSubmatrixFull().isSubmatrixFull(a)));
    }
}
