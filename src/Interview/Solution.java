package Interview;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/26/14
 * Time: 8:27 PM
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] numbers = line.split(" ");
        int M = Integer.valueOf(numbers[0]);
        int N = Integer.valueOf(numbers[1]);

        char[][] charBox = new char[M][];
        for (int i = 0; i < M; i++) {
            line = br.readLine();
            charBox[i] = line.trim().toCharArray();
        }

        System.out.println(new Solution().calculateWishes(charBox, M, N));
    }
    /**
     * The idea to solve this problem is very straight forward.
     * The goal is to change some columns to get the same rows as many as possible.
     * For each raw, we find the row number we need to flip the row to all P or all T.
     * Then we find the most appears solution. And calculate its counts. This is the final answer
     */
    public int calculateWishes(char[][] box, int M, int N) {
        List<String> columnToFlipList = new ArrayList<String>();
        for (int i = 0; i < M; i++) {
            StringBuilder columnFlipToP = new StringBuilder();
            StringBuilder columnFlipToT = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 'P') {
                    columnFlipToT.append(j);
                } else {
                    columnFlipToP.append(j);
                }
            }
            columnToFlipList.add(columnFlipToP.toString());
            columnToFlipList.add(columnFlipToT.toString());
        }

        HashMap<String, Integer> columnCount = new HashMap<String, Integer>();
        for (String s : columnToFlipList) {
            if (columnCount.containsKey(s)) {
                int count = columnCount.get(s);
                columnCount.put(s, count + 1);
            } else {
                columnCount.put(s, 1);
            }
        }

        int maxCount = 0;

        for (String s : columnCount.keySet()) {
            int count = columnCount.get(s);
            if (count > maxCount) {
                maxCount = count;
            }
        }


        return maxCount;
    }



}