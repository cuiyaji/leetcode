import java.util.*;

public class PrefixPalindrome {
    public String test(String s) {
        if(s.length() == 0) return "";
		String pre = getPrefixPalindrome(s);
		if(pre.length() > 1){
			return test(s.substring(pre.length()));
		} else
            return s;
    }

    private String getPrefixPalindrome(String s){
		String temp = s + '#';
		String str = reverse(s);
		temp += str;
		int n = temp.length();
		
		int []lps = new int[n];
		for(int i = 1; i < n; i++){
			int len = lps[i - 1];
			while (len > 0 && temp.charAt(len) != temp.charAt(i)){
				len = lps[len - 1];
			}
			if (temp.charAt(i) == temp.charAt(len)) len++;
			lps[i] = len;
		}
		return temp.substring(0, lps[n - 1]);
	}
	
	private String reverse(String str){
		char[] a = str.toCharArray();
		int l, r = a.length - 1;
		
		for(l = 0; l < r; l++, r--) {
			char temp = a[l];
			a[l] = a[r];
			a[r] = temp;
		}
		return String.valueOf(a);
	}



    public static void main (String[] args) 
        { 
            // Scanner scanner  = new Scanner(System.in);
            // String s = scanner.nextLine();
            PrefixPalindrome T = new PrefixPalindrome();
            String s1 = "aaacodedoc";
            String s2 = "codesignal";
            String s3 = "";
            String res1 = T.test(s1);
            String res2 = T.test(s2);
            String res3 = T.test(s3);
            System.out.println(res1.equals(""));
            System.out.println(res2.equals("codesignal"));
            System.out.println(res3.equals(""));
        } 

}