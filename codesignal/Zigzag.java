package Robinhood;

import java.util.Arrays;

public class Zigzag {
    public int[] isZigzag (int[] numbers) {
        //corner case
        if (numbers.length < 3) {
            return new int[0];
        }
        int[] res = new int[numbers.length - 2];
        for (int i = 0; i < numbers.length - 2; i++) {
            int a = numbers[i];
            int b = numbers[i + 1];
            int c = numbers[i + 2];
            if ((a < b && b > c) || (a > b && b < c)) {
                res[i] = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(new Zigzag().isZigzag(a)));
    }

}
