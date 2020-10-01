package Robinhood;

public class CountSubSegment {
    private int countSubSegment(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int subi = subSum(arr, 0, i);
            for (int j = i + 1; j < arr.length; j++) {
                int subj = subSum(arr, i, j);
                int subk = subSum(arr, j, arr.length);
                if(subi <= subj && subj <= subk) {
                    count++;
                }
            }
        }
        return count;
    }
    private int subSum(int[] arr, int a, int b) {
        int sum = 0;
        for (int i = a; i < b; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,2,2,5,0};
        System.out.println(new CountSubSegment().countSubSegment(a));
    }
}
