import java.util.*;

public class ThrottlingGateWay {
    public static int sum(int[] requestTime) {
        int ans = 0 ;
        Arrays.sort(requestTime);
        for(int i = 0; i < requestTime.length; i++){

            if(i > 2 && requestTime[i] == requestTime[i-3]){
                ans++;
            } else if(i > 19 && (requestTime[i] - requestTime[i-20]) <10){
                ans++;
            } else if( i > 59 && (requestTime[i] - requestTime[i-60]) <60 ){
                ans++;
            }
        }
        return ans;
    }




    public static void main (String[] args) 
        { 
            // Scanner scanner  = new Scanner(System.in);
            // String s = scanner.nextLine();
            int[] requestTime1 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 11, 11, 11, 6, 6, 6, 5, 5, 5};
            int[] requestTime2 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
            int[] requestTime3 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9,
                10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 14, 16, 16, 16, 16, 16,
                16, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20};
            ThrottlingGateWay test = new ThrottlingGateWay();
            int res = test.sum(requestTime1);
            System.out.println(res);
        } 

    }