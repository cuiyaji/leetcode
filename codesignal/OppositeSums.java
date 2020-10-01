package Robinhood;

import java.util.*;

public class OppositeSums {
    public int oppo(int[] input) {
        if (input == null || input.length == 0) return 0;

        Map<Integer, Integer> pairsNum = new HashMap<>();
        for (int j : input) {
            int curRev = reverse(j);
            int key = j - curRev;
            int count = pairsNum.getOrDefault(key, 0) + 1;
            pairsNum.put(key, count);
        }
        //check pairs
        int sum = 0;
        Set<Integer> set = pairsNum.keySet();
        for (int i : set) {
           int cur = pairsNum.get(i);
           if (cur > 1) sum += factorial(cur);
        }
        return sum;
    }

    private long factorial(int a) {
        if (a <= 1) {
            return 1;
        }
        return a * factorial(a - 1);
    }

    private int reverse(int a) {
        String str = Integer.toString(a);
        char[] chars = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
        return Integer.parseInt(new String(chars));

    }
    private void swap(char[] str, int i ,int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{123, 321, 543};
        System.out.println(new OppositeSums().oppo(a));
    }
}