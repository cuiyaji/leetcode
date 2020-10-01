import java.util.*;

public class BestSquare {
    public int test(int[][] m, int k) {
       if(m == null || m.length == 0 || k == 0) return 0;
       int max = Integer.MIN_VALUE;
       HashSet<Integer> set = new HashSet<>();
       for(int i = 0; i < m.length - k + 1; i++) {
           for(int j = 0; j < m[0].length - k + 1; j++) {
               int tempSum = 0;
               HashSet<Integer> tempSet = new HashSet<>();
               for(int p = i; p < i + k; p++) {
                   for(int q = j; q < j + k; q++) {
                        tempSum += m[p][q];
                        tempSet.add(m[p][q]);
                   }
               }
               if(tempSum > max) {
                   max = tempSum;
                   set = new HashSet(tempSet);
               } else if( tempSum == max) {
                   for(int s : tempSet) {
                       set.add(s);
                   }
               }
           }
       }
       int res = 0;
       for(int s : set) {
            res += s;
       }
        return res;
    }



    public static void main (String[] args) 
        { 
            // Scanner scanner  = new Scanner(System.in);
            // String s = scanner.nextLine();
            BestSquare T = new BestSquare();
            int[][] m = new int[][]{{1, 0, 1, 5, 6}, {3, 3, 0, 3, 3}, {2, 9, 2, 1, 2}, {0, 2, 4, 2, 0}};
            int k = 2;
            int res = T.test(m, k);
            System.out.println(res);
        } 

}