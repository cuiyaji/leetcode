import java.util.*;

public class PowerOfTwo {
    public int test(int[] arr) {
        // int res = 0;

        // for(int i = 0; i < arr.length; i++) {

        //     for(int j = i; j < arr.length; j++) {
        //         if(isPowerTwo(arr[i] + arr[j])) {
        //             res++;
        //         }
        //     }
            
        // }
        // return res;
        int n = arr.length;
        int[] a = arr;
        // To keep the element in sorted order
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++)
        {
            map.put(a[i], 1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int item = entry.getKey();
            if(item < 1){
                break;
            }
            int cur = 1;
            while(cur <= item * 2){
                if(map.containsKey(cur - item)){
                    count ++;
                }
                cur *= 2;
            }
        }
        return count;
      
    }

    private boolean isPowerTwo(int a) {
        if(a == 0) return false;
        long cur = (long)a;
        return (cur & (cur - 1)) == 0;
    }



    public static void main (String[] args) 
        { 
            // Scanner scanner  = new Scanner(System.in);
            // String s = scanner.nextLine();
            PowerOfTwo T = new PowerOfTwo();
            int[] arr = new int[]{1, -1, 2, 3};
            int res = T.test(arr);
            System.out.println(res);
        } 

}