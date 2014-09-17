package EditDistance;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/16/14
 * Time: 5:46 PM
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int[][] distance = new int[word1.length()][word2.length()];
        distance[0][0] = word1.charAt(0) == word2.charAt(0) ? 1 : 0;
        if (word1.length() > 1)
            distance[1][0] = distance[0][0];
        if (word2.length() > 1)
            distance[0][1] = distance[0][0];
        int max = distance[0][0];
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                int a = word1.charAt(i) == word2.charAt(j) ? 1 : 0;
                int t_max = Math.max(distance[i - 1][j - 1] + a, distance[i - 1][j]);
                t_max = Math.max(t_max, distance[i][j - 1]);
                distance[i][j] = t_max;
                if (t_max > max) {
                    max = t_max;
                }
            }
        }
        return Math.max(word1.length(), word2.length()) - max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("aaa", "aaab"));
        System.out.println(new Solution().minDistance("sea", "ate"));  //3

    }
}
