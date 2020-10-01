import java.util.*;

class wordWrap {
	public static void main(String[] args){
		String str1 = "His dog chases her cat";
		String str2 = "His sdafhjbgaekfnadf dog chases her cat";
		String str5 = "His sdafhjbgaekfnaf dog chases her cat";
		String str3 = "";
		String str4 = " ";
		System.out.println(reArrange(str1, 15));
		System.out.println(reArrange(str2, 15));
		System.out.println(reArrange(str3, 15));
		System.out.println(reArrange(str4, 15));
		System.out.println(reArrange(str5, 15));
		System.out.println(reArrange(str4, 1));
	} 

	public static String reArrange(String str, int k){
		String[] words = str.split(" ");
		String res = "";
		int curLen = 0;
		for(int i = 0; i < words.length; i++){
			String word = words[i];
			if(curLen == 0 && word.length() > k) return "";
			else if(curLen == 0 && word.length() <= k){
				curLen = word.length();
				res += word;
			}
			else if(curLen > 0 && word.length() + curLen + 1 <= k){
				curLen += word.length();
				res += " " + word;
			}
			else if(curLen > 0 && word.length() + curLen + 1 > k){
				curLen = 0;
				res += "\n";
				i--;
			}
		}
		return res;
	}
}