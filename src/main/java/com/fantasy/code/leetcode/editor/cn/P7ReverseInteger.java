//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2359 👎 0


package com.fantasy.code.leetcode.editor.cn;

//Java：整数反转
public class P7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST

        int reverse = solution.reverse(-123);

        System.out.println("reverse = " + reverse);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {

            int maxValue = Integer.MAX_VALUE;
            int minValue = Integer.MIN_VALUE;

            if (x > maxValue || x < minValue)
                return 0;

            String s = String.valueOf(x);

            if (s.length() == 1)
                return x;

            StringBuilder stringBuilder = new StringBuilder(s);
            String reverse = stringBuilder.reverse().toString();

            if (reverse.endsWith("-")) {
                reverse = "-" + reverse.substring(0, reverse.length() - 1);
            }

            int i;

            try {
                i = Integer.valueOf(reverse).intValue();

                if (i > maxValue || i < minValue)
                    return 0;

                return i;
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}