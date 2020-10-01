package Robinhood;

import java.util.Arrays;

public class ReverseDigitInPairs {
    private int reverseDigitInPairs(int n) {
        if (n <= 10) {
            return n;
        }
        String str = Integer.toString(n);
        char[] array = str.toCharArray();
        int i = 0;
        while (i < array.length - 1) {
            swap(array, i, i + 1);
            i += 2;
        }
        String res = new String(array);
        return Integer.parseInt(res);
    }
    private void swap (char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int a = 1245678;
        System.out.println(new ReverseDigitInPairs().reverseDigitInPairs(a));

    }
}
