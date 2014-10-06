package WordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/5/14
 * Time: 10:06 PM
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    public static void main(String[] args) {
        Set<String> dic = new HashSet<String>();
        dic.add("leet");
        dic.add("code");
        System.out.println(new Solution().wordBreak("leetcode", dic));

        dic.add("aaaa");
        dic.add("aaa");
        System.out.println(new Solution().wordBreak("aaaaaaa", dic));

        dic.add("a");
        dic.add("b");
        dic.add("cd");
        dic.add("abc");
        System.out.println(new Solution().wordBreak("abcd", dic));
    }
}