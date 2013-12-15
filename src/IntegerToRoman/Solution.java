package IntegerToRoman;


/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/15/13
 * Time: 1:15 PM
 */
public class Solution {
    public String intToRoman(int num) {
        String result = "";
        int[] number = {10, 50, 100, 500, 1000};
        int[] list = new int[number.length];
        String string = "XLCDM";
        for (int i = number.length - 1; i >= 0; i--) {
            list[i] = num / number[i];
            num = num % number[i];
        }
        for (int i = number.length - 1; i >= 0; i--) {
            result += repeat(string.charAt(i), list[i]);
        }
        switch (num) {
            case 0:
                break;
            case 1:
                result += "I";
                break;
            case 2:
                result += "II";
                break;
            case 3:
                result += "III";
                break;
            case 4:
                result += "IV";
                break;
            case 5:
                result += "V";
                break;
            case 6:
                result += "VI";
                break;
            case 7:
                result += "VII";
                break;
            case 8:
                result += "VIII";
                break;
            case 9:
                result += "IX";
                break;
        }
        return result;
    }

    public String repeat(char c, int t) {
        String s = "";
        for (int i = 0; i < t; i++) {
            s += c;
        }
        return s;
    }

    static public void main(String[] args) {
        System.out.println(new Solution().intToRoman(40));
    }
}
