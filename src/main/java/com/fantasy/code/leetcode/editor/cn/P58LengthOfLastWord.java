//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 263 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

import java.util.regex.Pattern;

@Resolved
//Java：最后一个单词的长度
public class P58LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        // TO TEST
        int length = solution.lengthOfLastWord("a");

        System.out.println(length);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {

            if (s == null || s.length() == 0 || " ".equals(s))
                return 0;

            String[] strings = s.split(" ");

            int index = strings.length-1;

            while (index >= 0) {
                String word = strings[index];

                String regex = "^[a-zA-Z]+$";

                boolean matches = word.matches(regex);

                if (matches)
                    return word.length();
                else
                    return 0;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}