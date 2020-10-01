import java.util.*;
// ways of remove one char in either string to make S lexicographically less than T
class removeOneChar {
	int numOfWays;

	public static void main(String[] args) {
		removeOneChar instance = new removeOneChar();
		String S1 = "abcefe";
		String T1 = "abcefe";

		String S2 = "";
		String T2 = "";

		String S3 = "ade";
		String T3 = "a";

		String S4 = "a";
		String T4 = "ade";

		String S5 = "ad";
		String T5 = "af";
		instance.numOfWays = 0;
		instance.waysOfRemove(S1, T1);
		System.out.println(instance.numOfWays);
		instance.numOfWays = 0;
		instance.waysOfRemove(S2, T2);
		System.out.println(instance.numOfWays);
		instance.numOfWays = 0;
		instance.waysOfRemove(S3, T3);
		System.out.println(instance.numOfWays);
		instance.numOfWays = 0;
		instance.waysOfRemove(S4, T4);
		System.out.println(instance.numOfWays);
		instance.numOfWays = 0;
		instance.waysOfRemove(S5, T5);
		System.out.println(instance.numOfWays);

	}

	public void waysOfRemove(String S, String T) {
		if(S.length() == 0 && T.length() == 0) return;
		else if(S.length() == 0) numOfWays += T.length();
		else if(T.length() == 0) return;
		else{
			if(isValid(S.substring(1, S.length()), T)) numOfWays += 1;
			if(isValid(S, T.substring(1, T.length()))) numOfWays += 1;
			if(S.charAt(0) <= T.charAt(0)){
				waysOfRemove(S.substring(1, S.length()), T.substring(1, T.length()));
			}
		}
	}

	public boolean isValid(String S, String T){
		int idx = 0;
		while(idx < S.length() && idx < T.length())
		{
			if(S.charAt(idx) < T.charAt(idx))
			{
				return true;
			}
			else if(S.charAt(idx) > T.charAt(idx))
			{
				return false;
			}
			else
			{
				idx++;
			}
		}
		if(idx == S.length() && idx == T.length()) return false;
		else if(idx < S.length()) return false;
		else return true;
	}
}