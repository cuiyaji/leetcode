package Robinhood;

public class Occur024 {
    public int countOccurrence(int n ) {
        if (n == 0) {
            return 1;
        }
        int count = 1;
        for (int i = 1; i <= n; i++) {
            int cur = i;
            while ( cur != 0) {
                int digit = cur % 10;
                if (digit == 0 || digit == 2 || digit == 4) {
                    count++;
                }
                cur /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Occur024().countOccurrence(65535));
    }
}
