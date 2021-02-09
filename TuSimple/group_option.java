package TuSimple;

import java.util.*;

public class group_option {



    public static long backpack(int people, int groups) {
        long[][] dp = new long[people + 1][groups + 1]; 
        dp[0][0] = 1;
        for (int i = 1; i <= people - groups + 1; ++i) {
            for (int j = i; j <= people; ++j) {
                for (int k = 1; k <= groups; ++k) {
                    dp[j][k] += dp[j - i][k - 1];
                }
            }
        }
        return dp[people][groups];
    }



    public static void main(String[] args) {
       
        System.out.println(new group_option().backpack(8, 4));
    }
}