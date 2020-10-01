package Robinhood;

public class DivideKLessThanK {
    public String divide(String num, int k) {
        if (num == null || num.length() <= k) {
            return num;
        }
        return divide(divideByK(num, k), k);
    }

    private String divideByK(String num, int k) {
        String cur;
        int sum = 0;
        for (int i = 0; i < num.length(); i += k) {
            if(i + k > num.length()) {
                cur = num.substring(i);
            } else {
                cur = num.substring(i, i + k);
            }
            int curNum = Integer.parseInt(cur);
            int digit = 0;
            while(curNum != 0) {
                digit += curNum % 10;
                curNum /= 10;
            }
            sum = sum * 10 + digit;
        }
        return Integer.toString(sum);
    }

    public static void main(String[] args) {
        String a = "1111122222";
        System.out.println(new DivideKLessThanK().divide(a, 3));
    }
}
