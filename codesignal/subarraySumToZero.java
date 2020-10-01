import java.util.*;

class subarraySumToZero {
	public static void main(String[] args){
		subarraySumToZero instance = new subarraySumToZero();
		int[] arr1 = new int[]{1, 0, 1, 1, 1, 0, 0};
		int[] arr2 = new int[]{1, 1, 1, 1, 1, 1, 1};
		int[] res = instance.largestSubArray(arr2);
		System.out.println( res[0] + " " + res[1]);
	}

	public int[] largestSubArray(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		int maxLen = -1;
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 0) sum -= 1;
			else sum += 1;
			if(map.containsKey(sum)) {
				if(i - map.get(sum) > maxLen){
					res[0] = map.get(sum)+1;
					res[1] = i;
					maxLen = res[1] - res[0] + 1;
				}
			}
			else map.put(sum, i);
		}
		return res;
	}
}