package Anagrams;

import Tools.ListTools;

import java.util.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/12/14
 * Time: 1:38 PM
 */
public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> sortedMap = new HashMap<String, List<String>>();
        List<String> result = new LinkedList<String>();

        for (String s : strs) {
            String sortedString = sort(s);
            if (sortedMap.containsKey(sortedString)) {
                List<String> l = sortedMap.get(sortedString);
                l.add(s);
            } else {
                List<String> l = new LinkedList<String>();
                l.add(s);
                sortedMap.put(sortedString, l);
            }
        }

        for (String s : sortedMap.keySet()) {
            if (sortedMap.get(s).size() > 1)
                result.addAll(sortedMap.get(s));
        }
        return result;
    }

    public String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String result = new String(chars);
        return result;
    }


    public static void main(String[] args) {
        ListTools.PrintStringList(new Solution().anagrams(new String[]{"", ""}));
        ListTools.PrintStringList(new Solution().anagrams(new String[]{"a", "ab", "ba"}));

    }
}