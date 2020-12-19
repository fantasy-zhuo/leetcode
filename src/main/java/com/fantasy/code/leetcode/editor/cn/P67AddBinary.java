//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 531 👎 0


package com.fantasy.code.leetcode.editor.cn;

//Java：二进制求和
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
       int i = 13;


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {

            if (a == null || b == null
                    || a.length() == 0 || b.length() == 0
                    || a.length() < 1 || b.length() > (10 << 4))
                return null;

            String regex = "^[01]+$";

            boolean matches = a.matches(regex) && b.matches(regex);

            if (!matches)
                return null;

            //计算a的值
            char[] aList = a.toCharArray();

            int aValue = 0;

            int aReverseIndex = 0;

            for (int i = aList.length; i > 0; i--) {
                if (Integer.valueOf(aList[i] + "") == 1)
                    aValue += 1 << aReverseIndex;

                aReverseIndex++;
            }

            char[] bList = b.toCharArray();

            int bValue = 0;

            int bReverseIndex = 0;

            for (int i = bList.length; i > 0; i--) {
                if (Integer.valueOf(bList[i] + "") == 1)
                    bValue += 1 << bReverseIndex;

                bReverseIndex++;
            }

            int sum = aValue + bValue;

            while (sum > 0){

            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}