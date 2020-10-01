package Robinhood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteMinimalPeaks {
    public int[] deleteMinPeaks(int[] input) {
        List<Integer> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for (int i : input) {
            arr.add(i);
        }
        //find peaks
        while (res.size() != input.length) {
            findPeak(arr, res);
        }

        // convert list ot array
        int[] result = new int[res.size()];
        int index = 0;
        for (int i : res) {
            result[index++] = i;
        }
        return result;

    }
    private void findPeak(List<Integer> arr, List<Integer> res) {
        int min = Integer.MAX_VALUE;
        if (arr.size() == 1) {
            res.add(arr.get(0));
            return;
        }
        //first
        if (arr.get(0) > arr.get(1)) {
            min = Math.min(min, arr.get(0));
        }
        //last
        if (arr.get(arr.size() - 1) > arr.get(arr.size() - 2)) {
            min = Math.min(min, arr.get(arr.size() - 1));
        }
        //medium
        for(int i = 0; i < arr.size() - 2; i++) {
            if (arr.get(i) < arr.get(i + 1) && arr.get(i + 1) > arr.get(i + 2)) {
                min = Math.min(min, arr.get(i + 1));
            }
        }
           res.add(arr.remove(arr.indexOf(min)));
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 6, 4, 5, 10};
        int[] b = new int[]{2,7,8,5,1,6,3,9,4};
        System.out.println(Arrays.toString(new DeleteMinimalPeaks().deleteMinPeaks(b)));
    }
}
