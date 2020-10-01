package Robinhood;

import java.util.Arrays;

public class MaxKOccurrences {
    public int[] maxKOccurrences(String sequence, String[] words) {
        int[] res = new int[words.length];
        int index = 0;
        // check each word
        for(String word : words) {
            res[index++] = helper(sequence, word);
        }
        return res;
    }
    // count each word occurrence
    private int helper(String seq, String word) {
        //find the max k occurrence of word
        // check one by one
            int count = 0;
            int res = 0;
            int i = 0;
            while(i <= seq.length() - word.length()) {
                if(substring(seq, word, i)) {
                    count++;
                    res = Math.max(count, res);
                    i += word.length();
                } else {
                    count = 0;
                    i++;
                }
            }
        return res;
    }

    // only check substring starting at certain index
    private boolean substring(String seq, String word, int k) {
        for(int i = 0; i < word.length(); i++) {
            if(seq.charAt(i + k) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String seq = "ababcbabc";
        String[] words = new String[]{"ab","babc","bca"};
        System.out.println(Arrays.toString(new MaxKOccurrences().maxKOccurrences(seq,words)));
    }
}
