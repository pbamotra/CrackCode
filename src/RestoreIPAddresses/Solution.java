package RestoreIPAddresses;

import Tools.ListTools;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/16/14
 * Time: 9:21 PM
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<String>();
        if(s.length()>12) return result;
        for (int i = 1; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                for (int k = j + 1; k < s.length(); k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k, s.length());
                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        result.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return result;
    }

    public boolean isValid(String s) {
        if (Integer.valueOf(s) > 255) return false;
        if (s.startsWith("0") && s.length() >= 2) return false;

        return true;
    }

    public static void main(String[] args){
        ListTools.PrintStringList(new Solution().restoreIpAddresses("25525511135"));
        ListTools.PrintStringList(new Solution().restoreIpAddresses("010101"));
        ListTools.PrintStringList(new Solution().restoreIpAddresses("923123123123"));

    }
}
