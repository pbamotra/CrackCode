package TwoSum;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/18/13
 * Time: 5:00 PM
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = {1,1};
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if((numbers[i]+numbers[j])==target){
                    result[0]=i+1;
                    result[1]=j+1;
                }
            }
        }
        return result;
    }
}