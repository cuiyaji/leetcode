import java.util.*;

class distinctTriplets {
	public static void main(String[] args){
		distinctTriplets instance = new distinctTriplets();
		String str = "abcabcabcccc";
		System.out.println(instance.countTriplets(str));
	}

	public int countTriplets(String str){
		int p1 = 0;
		int[] counter = new int[26];
		int res = 0;
		for(int i = 0; i < str.length(); i++){
			if(i - p1 == 3) {
				res++;
				counter[str.charAt(p1) - 'a']--;
				p1++;
			}
			counter[str.charAt(i) - 'a']++;
			if(counter[str.charAt(i) - 'a'] > 1){
				while(str.charAt(i) != str.charAt(p1)){
					counter[str.charAt(p1)- 'a']--;
					p1++;
				}
				counter[str.charAt(p1)- 'a']--;
				p1++;
			}
		}
		return res;
	}
}