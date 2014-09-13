package Anagrams;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/12/14
 * Time: 1:38 PM
 */
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> l = new LinkedList<String>();
        for (String s : strs) {
            if (isAnagram(s)) {
                l.add(s);
            }
        }

        return l;
    }

    public boolean isAnagram(String s) {
        int length = s.length();
        if (length == 0) return false;
        if (length == 1) return true;
        if (length % 2 == 0) {
            for (int i = 0; i < length / 2; i++) {
                if (s.charAt(i) != s.charAt(length - i - 1)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i <= length / 2; i++) {
                if (s.charAt(i) != s.charAt(length - i - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("121"));
        System.out.println(new Solution().isAnagram("1221"));
        System.out.println(new Solution().isAnagram("123"));

    }
}