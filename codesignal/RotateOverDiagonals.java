package Robinhood;

import java.util.Arrays;

public class RotateOverDiagonals {
    public int[][] rotateOverDiagonals(int[][] m, int k) {
        for (int i = 0; i < k; i++) {
            rotate(m);
        }
        return m;
    }
    public void rotate(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                if(i != j || i != -j) {
                    int tmp = m[i][j];
                    m[i][j] = m[n - 1 - j][i];
                    m[n - 1 - j][i] = m[n - 1 - i][n - 1 - j];
                    m[n - 1 - i][n - 1 - j] = m[j][n - 1 - i];
                    m[j][n - 1 - i] = tmp;
                }
            }
        }
    }

}