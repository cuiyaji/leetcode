package Robinhood;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DiagonalsSort {
    public int[][] DiaginalsSort(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = m - 1; i >= 0; i--) {
            int k = i;
            Integer[] res = new Integer[k + 1];
            int index = 0;
            int j = 0;
            while (k >= 0 && j < n) {
                res[index++] = matrix[k][j];
                k--;
                j++;
            }

            //Arrays.sort(res);
            Arrays.sort(res, Collections.reverseOrder());
            //put back
            k = i;
            j = 0;
            index = 0;
            while(k >= 0 && j < n) {
                matrix[k][j] = res[index++];
                k--;
                j++;
            }
        }

        for (int j = 1; j < n; j++) {
            int l = j;
            int i = m - 1;
            Integer[] rr = new Integer[n - l];
            int index = 0;
            while (l < n && i >= 0) {
                rr[index++] = matrix[i][l];
                l++;
                i--;
            }
            //Arrays.sort(rr);
            Arrays.sort(rr, Collections.reverseOrder());

            l = j;
            i = m - 1;
            index = 0;
            while (l < n && i >= 0) {
                matrix[i][l] = rr[index++];
                l++;
                i--;
            }
        }
        for(int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,10,4},
                                {2,5,6},
                                {0,1,2}};
        System.out.println(new DiagonalsSort().DiaginalsSort(a));
    }
}
