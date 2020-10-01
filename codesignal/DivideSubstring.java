package Robinhood;

public class DivideSubstring {
    public int divideSubstring(int n, int k) {
        // corner case
        if (n == 0 || k == n) {
            return 0;
        }
        // get all substrings
        String str = Integer.toString(n);
        int len = str.length();
        int count = 0;
        for (int i = 0; i <= len - k; i++) {
            if (str.charAt(i) == '0') continue;
            String cur = str.substring(i, i + k);
            if (Integer.parseInt(cur) % k == 0) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new DivideSubstring().divideSubstring(10203, 3));
    }

}
