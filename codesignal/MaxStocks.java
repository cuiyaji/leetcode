package Robinhood;

public class MaxStocks {
    public int maxStocks(int[] prices, int[] algo, int k) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // initial calculate the revenue
        int revenue = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i < k) {
                revenue += prices[i];
            } else {
                if (algo[i] == 1) {
                    revenue += prices[i];
                } else {
                    revenue -= prices[i];
                }
            }
        }
        // sliding window
        //i.e  2  4  1  5  2  6  7
        //     0  1  0  0  1  0  0
        //     ==========
        //        ==========
        int l = 1;
        int cur = revenue;
        while (l <= prices.length - k) {
            if (algo[l - 1] == 0) {
                cur -= 2 * prices[l - 1];
            }
            if (algo[l + k - 1] == 0) {
                cur += 2 * prices[l + k - 1];
            }
            revenue = Math.max(revenue, cur);
            System.out.println(revenue);
            l++;
        }
        return revenue;
    }

    public static void main(String[] args) {
        int[] p = new int[]{2,4,1,5,2,6,7};
        int[] a = new int[]{0,1,0,0,1,0,0};
        System.out.println(new MaxStocks().maxStocks(p,a,4));
    }
}
