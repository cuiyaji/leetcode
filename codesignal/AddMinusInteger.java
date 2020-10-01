package Robinhood;


public class AddMinusInteger {
    public int addMinusInt(int num) {
        if (num == 0) {
            return 0;
        }
        int n = Integer.toString(num).length();
        int count = 0;
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            count++;
            if (count % 2 == n % 2){
                sum += digit;
            } else {
                sum -= digit;
            }
            num /= 10;
        }
        return sum;
    }
    public int addMinusIntStr(int num) {
        if (num == 0) {
            return 0;
        }
        String a = Integer.toString(num);
        char[] b = a.toCharArray();
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            if (i % 2 == 0) {
                sum += b[i] - '0';
            } else {
                sum -= b[i] - '0';
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int a = 5334;
        System.out.println(new AddMinusInteger().addMinusIntStr(a));
    }
}
