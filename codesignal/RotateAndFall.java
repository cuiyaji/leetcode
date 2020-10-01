package Robinhood;

import java.util.Arrays;

public class RotateAndFall {
    public char[][] rotateAndFall(char[][] m) {
        int row = m.length;
        int col = m[0].length;
        // move # to the right
        for (int i = 0; i < row; i++) {
            int j = 0;
            int slow = 0;
            while (j < col) {
                if (m[i][j] == '.') {
                    swap (m[i], slow, j);
                    slow++;
                    j++;
                } else if (m[i][j] == '*') {
                    j++;
                    slow = j;
                } else {
                    j++;
                }
            }
        }
        // rotate matrix
        System.out.println(Arrays.deepToString(m));
        return rotate(m);
    }
    private void swap(char[] array, int a, int b) {
        char tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    private char[][] rotate(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
          char[][] a = new char[][]{{'.','#','.','.','.','.','.'},
                                    {'#','.','#','*','.','#','.'},
                                    {'#','.','#','*','.','#','.'}};
        System.out.println(Arrays.deepToString(new RotateAndFall().rotateAndFall(a)));
    }
}
