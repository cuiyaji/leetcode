import java.util.*;

public class ArithmeticMean {
    public int test(int[] arr) {
       if(arr == null || arr.length == 0) return 0;
       int res = 0;
       for(int i = 0; i < arr.length; i++) {
           int prev = i == 0 ? 0 : arr[i - 1];
           int post = i == arr.length - 1 ? 0 : arr[i + 1];
           if(prev + post == 2 * arr[i]) res++;
       }
        return res;
    }



    public static void main (String[] args) 
        { 
            // Scanner scanner  = new Scanner(System.in);
            // String s = scanner.nextLine();
            ArithmeticMean T = new ArithmeticMean();
            int[] arr = new int[]{2, 4, 6, 6, 3};
            int res = T.test(arr);
            System.out.println(res);
        } 

}