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

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

//Java：二进制求和
@Resolved
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST

//        System.out.println("binary = " + binary);

        String test = solution.addBinary("1011", "11");

        System.out.println("test = " + test);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if (a == null || b == null
                    || a.length() == 0 || b.length() == 0
                    || a.length() < 1 || b.length() > (10 << 4)
                    || ("0".equals(a) && "0".equals(b)))
                return "0";

            String regex = "^[01]+$";

            boolean matches = a.matches(regex) && b.matches(regex);

            if (!matches)
                return null;

            int aLength = a.length();
            int bLength = b.length();

            boolean longer = aLength > bLength;

            int maxLength, minLength, sub;
            char[] maxChars, minChars;

            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();

            //如果a比b大
            if (longer) {
                maxLength = aLength;
                minLength = bLength;
                maxChars = aChars;
                minChars = bChars;
                sub = aLength - bLength;
            } else {
                maxLength = bLength;
                minLength = aLength;
                maxChars = bChars;
                minChars = aChars;
                sub = bLength - aLength;
            }

            String valueStr = "";
            for (int i = 0; i < maxLength + 2; i++) {
                valueStr += "0";
            }

            char[] value = valueStr.toCharArray();

            for (int i = maxLength - 1; i >= 0; i--) {
                if (minLength == 0) {
                    if (value[i + 2] == '1' && maxChars[i] == '1') {
                        value[i + 1] = '1';
                        value[i + 2] = '0';
                    } else {
                        if (value[i + 2] != '1')
                            value[i + 2] = maxChars[i];
                    }
                    continue;
                }

                Integer minValue = Integer.valueOf(minChars[i - sub > 0 ? i - sub : 0] + "");
                Integer maxValue = Integer.valueOf(maxChars[i] + "");
                int v = minValue ^ maxValue;

                //异或结果 两者相同为0 ，不同为1
                if (v == 0) {
                    if (minValue == 1 && maxValue == 1) {
                        if (value[i + 1] == '1') {
                            value[i] = '1';
                            value[i + 1] = '0';
                        } else {
                            value[i + 1] = '1';
                            if (value[i + 2] != '1') value[i + 2] = '0';
                        }
                    }
                } else {
                    if (value[i + 2] == '1') {
                        value[i + 1] = '1';
                        value[i + 2] = '0';
                    } else {
                        value[i + 2] = '1';
                    }
                }
                minLength--;
            }

            String binary = String.valueOf(value);

            while (binary.startsWith("0")) {
                binary = binary.substring(1);
            }

            return binary;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}