package GrayCode;

import Tools.ListTools;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 6:10 PM
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> l = new LinkedList<Integer>();
        Double d = Math.pow(2, n);
        int m = d.intValue();

        for(int i=0;i<m;i++){
            int t = (i>>1)^i;
            l.add(t);
        }

        return l;
    }

    public static void main(String[] args){
        ListTools.PrintIntegerList(new Solution().grayCode(2));
    }
}
