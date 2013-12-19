package LongestSubstringWithoutRepeatingCharacters;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/18/13
 * Time: 7:20 PM
 * <p/>
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac is 12
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int length = 0;
        int[] bitMap = new int[26];
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (bitMap[c - 'a'] == 0) {
                bitMap[c - 'a']++;
                length++;
                if (length > maxLength) maxLength = length;
            } else {
                while (s.charAt(i) != c) {
                    char cc = s.charAt(i);
                    bitMap[cc - 'a'] = 0;
                    length--;
                    i++;
                }
                i++;
            }
            j++;
        }
        return maxLength;
    }

    static public void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
    }
}
