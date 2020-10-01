package Robinhood;

import java.util.Arrays;

public class BooleanDeque {
    public String booleanDeque(int n, String[] oper) {
        if (n == 0) return new String();
        int[] res = new int[n];
        for (int i = 0; i < oper.length; i++) {
            if (oper[i].equals("L")) {
                for (int j = 0; j < oper.length; j++) {
                    if (res[j] == 0) {
                        res[j] = 1;
                        break;
                    }
                }
            } else {
                int digit = oper[i].charAt(1) - '0';
                res[digit] = 0;
            }
        }
        return Arrays.toString(res);
    }
    public String booleanDequeBit(int n, String[] oper) {
        if (n == 0) {
            return new String();
        }
        int res = 0;
        for (int i = 0; i < oper.length; i++) {
            if (oper[i].equals("L")) {
                //find smallest 0 --> 1
                int k = n;
                while (k > 0) {
                    int cur = (res >> k) & 1;
                    if (cur == 1) {
                        k--;
                    } else{
                        res = res | (k << 1);
                        break;
                    }
                }
            } else {
                // find i index --> set 0
                int digit = oper[i].charAt(1) - '0';
                res = res & (~(n - digit));
            }
        }
        return Integer.toBinaryString(res);
    }

    public static void main(String[] args) {
        String[] o = new String[]{"L","L","C0","L","C3"};
        System.out.println(new BooleanDeque().booleanDequeBit(100000,o));
    }
}
