import java.util.*;

public class ReverseBeforeZero {
    public int[] test(int[] arr) {
        int[] res = new int[arr.length];
        int i = 0;
        for(int a : arr) {
            StringBuilder sb = new StringBuilder();
            while(a > 0) {
                sb.append(a % 10);
                a /= 10;
            }
            String s = sb.toString();
            int cur = 0;
            int count = 0;
            for(char c : s.toCharArray()) {
                int temp = cur * 10 + (c - '0');
                if (temp > cur) {
                    count++;
                }
                cur = temp;
            } 

            while(count++ < s.length()) {
                cur *= 10;

            }
            res[i] = cur;
            i++;
        }
        return res;
    }



    public static void main (String[] args) 
        { 
            // Scanner scanner  = new Scanner(System.in);
            // String s = scanner.nextLine();
            ReverseBeforeZero T = new ReverseBeforeZero();
            int[] arr = new int[]{7, 234, 58100};
            int[] res = T.test(arr);
            for(int i : res) {
                System.out.println(i);
            }
            
        } 

}