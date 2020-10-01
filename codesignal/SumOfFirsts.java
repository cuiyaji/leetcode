package Robinhood;

public class SumOfFirsts {
    public int sumOfFirsts(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int x = 0;;
        for (int i = 0; i < num.length; i++) {
            // find the leftmost non-zero element
            int cur = num[i];
            if (cur != 0) {
                //start i go to right
                for(int j = i; j < num.length; j++) {
                    if (num[j] - cur>= 0) {
                        num[j] -= cur;
                    } else {
                        break;
                    }
                }
                x += cur;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,3,5,2,3};
        System.out.println(new SumOfFirsts().sumOfFirsts(a));
    }
}
