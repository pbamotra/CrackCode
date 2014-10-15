package ImplementStrStr;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/14/14
 * Time: 2:39 PM
 */
public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return null;
        }
        if(needle.length()==0){
            return haystack;
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == needle.length()) {
                return haystack.substring(i - j);
            }
        }
        return null;
    }

    public static void main(String[] args){
        System.out.println(new Solution().strStr("abcab","d"));
    }
}
