package Robinhood;

import java.util.ArrayDeque;
import java.util.Deque;

public class WhoWin {
        public String whoWin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return "Bob";
            }
            Deque<Integer> stack = new ArrayDeque<>();
            int count = 0;
            for (int i : nums) {
                if (stack.isEmpty() || stack.peek() != i) {
                    stack.offerFirst(i);
                } else {
                    stack.pollFirst();
                    count++;
                }
            }
            if (count % 2 == 0) {
                return "Bob";
            }
            return "Alice";
        }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,5,5,6,6};
        System.out.println(new WhoWin().whoWin(a));
    }
}
