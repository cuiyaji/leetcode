import java.util.*;

class degreeOfArray {
	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 1, 2, 1, 2, 3, 2};
		int[] arr2 = new int[]{1, 2, 3, 4, 5, 6};
		int[] arr3 = new int[]{};
		System.out.println(minLen(arr1));
		System.out.println(minLen(arr2));
		System.out.println(minLen(arr3));
	}

	public static int minLen(int[] arr) {
		HashMap<Integer, Integer[]> counter = new HashMap<>();
		int degree = 0;
		int minLen = arr.length;
		for(int i = 0; i < arr.length; i++){
			int num = arr[i];
			if(!counter.containsKey(num)){
				counter.put(num, new Integer[3]);
				Integer[] info = counter.get(num);
				info[1] = i;
				info[0] = 0;
			}
			Integer[] info = counter.get(num);
			info[2] = i;
			info[0] += 1;
			degree = Math.max(degree, info[0]);
		}


		for(int num: arr){
			Integer[] info = counter.get(num);
			if(info[0] == degree){
				minLen = Math.min(minLen, info[2] - info[1] + 1);
			}
		}
		return minLen;
	}
}