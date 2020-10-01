package Robinhood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubarrayCheck {
    // b belongs to c
    // find the longest subarray X in a which elements is from c(dp)
    //check X == b ?
    public boolean longestSubarrayCheck(int[] a, int[] b, int[] c) {
        //put all c element into a set
        Set<Integer> cSet = new HashSet<>();
        for(int i : c) {
            cSet.add(i);
        }
        // check if all element in b belongs to c
        for(int i : b) {
            if (!cSet.contains(i)) {
                return false;
            }
        }
        // find longest contiguous subarray in a
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < a.length; i++) {
            if (cSet.contains(a[i])) {
                res.add(a[i]);
            } else {
                res.clear();
            }
        }
        //check if b == res
        if (b.length != res.size()) {
            return false;
        }
        for (int i = 0; i < b.length; i++) {
            if(b[i] != res.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,6,1,1,1};
        int[] b = new int[]{1,1,1};
        int[] c = new int[]{2,1};
        System.out.println(new LongestSubarrayCheck().longestSubarrayCheck(a,b,c));
    }
}
