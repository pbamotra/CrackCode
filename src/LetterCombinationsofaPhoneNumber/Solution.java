package LetterCombinationsofaPhoneNumber;

import Tools.ListTools;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 12:12 AM
 */
public class Solution {
    String[] mapping = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        int length = digits.length();
        visit(digits, results, new StringBuilder());
        return results;
    }

    public void visit(String digits, List<String> results, StringBuilder result) {
        if (digits.length() == 0) {
            results.add(result.toString());
        } else {
            for (int i = 0; i < mapping[digits.charAt(0) - '0' - 2].length(); i++) {
                visit(digits.substring(1), results, result.append(mapping[digits.charAt(0) - '0' - 2].charAt(i)));
                result.deleteCharAt(result.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        ListTools.PrintStringList(new Solution().letterCombinations("2323"));
    }
}
