import java.util.*;

class sumOfString {
	public static void main(String[] args){
		sumOfString instance = new sumOfString();
		String s1 = "11";
		String s2 = "9";

		String s3 = "0";
		String s4 = "10";

		String s5 = "";
		String s6 = "";

		String s7 = "0";
		String s8 = "0";
		System.out.println(instance.add(s1, s2));
		System.out.println(instance.add(s3, s4));
		System.out.println(instance.add(s5, s6));
		System.out.println(instance.add(s7, s8));
	}

	public String add(String s1, String s2){
		if(s1 == null || s2 == null) return s1 == null ? s2 : s1;
		int idx1 = s1.length() - 1;
		int idx2 = s2.length() - 1;
		String res = "";
		while(idx1 >= 0 && idx2 >= 0){
			String result = (Integer.parseInt(s1.charAt(idx1) + "") + Integer.parseInt(s2.charAt(idx2) + "")) + "";
			res = result + res;
			idx1--;
			idx2--;
		}
		if(idx1 >= 0) res = s1.substring(0, idx1 + 1) + res;
		else if(idx2 >= 0) res = s2.substring(0, idx2 + 1) + res;
		return res;
	}
}