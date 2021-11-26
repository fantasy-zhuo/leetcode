//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 440 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

@Resolved
//Java：验证回文串
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
        String s = "A man, a plan, a canal: Panama";

        boolean palindrome = solution.isPalindrome(s);

        System.out.println(palindrome);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {

            if ("".equals(s)) {
                return true;
            }

            StringBuilder stringBuilder = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c >= 48 && c <= 57 || c >= 97 && c <= 122) {
                    stringBuilder.append(c);
                }
                //大写转小写
                else if (c >= 65 && c <= 90) {
                    stringBuilder.append((char)(c + 32));
                }
            }

            String string = stringBuilder.toString();



            int length = string.length();
            int left = 0;
            int right = length - 1;

            char[] chars = string.toCharArray();

            while (left < right) {

                if (chars[left] != chars[right]) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}