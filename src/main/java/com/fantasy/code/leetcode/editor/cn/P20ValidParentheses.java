//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1998 👎 0


package com.fantasy.code.leetcode.editor.cn;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST

//        boolean valid = solution.isValid("[{}[]]");
//        boolean valid = solution.isValid("({{{{}}}))");
        boolean valid = solution.isValid("[{}[]]");


        System.out.println("valid = " + valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            /**
             * 替换字符
             * 若当前字符与上一字符匹配上后,用''代替
             * 最后字符串为''即为有效扩考
             */

            //null直接返回false
            if (s == null || (s != "" && s.length() % 2 != 0))
                return false;

            //空字符串返回true
            if (s == "")
                return true;

            if (!s.startsWith("(") && !s.startsWith("[") && !s.startsWith("{"))
                return false;

            char[] chars = s.toCharArray();

            List<Character> list = new ArrayList<>();

            for (int i = 0; i < chars.length; i++) {
                if (i == 0)
                    continue;

                //当前字符
                char c = chars[i];

                //上一字符
                int index = i - 1;

                char o = ' ';
                while (index >= 0) {
                    o = chars[index];
                    if (o == ' ')
                        index--;
                    else
                        break;
                }

                //左边括号直接跳过
                if (c == '(' || c == '[' || c == '{') {
                    continue;
                }
                //右边括号，判断是否匹配
                else if (c == ')' || c == ']' || c == '}') {
                    if ((o == '(' && c == ')') ||
                            (o == '[' && c == ']') ||
                            (o == '{' && c == '}')
                    ) {
                        chars[index] = ' ';
                        chars[i] = ' ';
                    } else
                        continue;
                }
            }
            System.err.println("chars.toString().length() = " + chars.toString().length());
            System.err.println("chars.toString() = " + Arrays.toString(chars));

            for (char aChar : chars) {
                if (aChar != ' ')
                    return false;
            }
            return true;
        }

        /**
         * 出入栈
         * 把字符一个个推入栈内，当前字符若是与栈顶元素可以组成有效括号即出栈，最终栈为空即为有效
         */
        public boolean stackValid(String s) {

            //null直接返回false
            if (s == null || (s != "" && s.length() % 2 != 0))
                return false;

            //空字符串返回true
            if (s == "")
                return true;

            if (!s.startsWith("(") && !s.startsWith("[") && !s.startsWith("{"))
                return false;

            char[] chars = s.toCharArray();

            Stack stack = new Stack();

            for (int i = 0; i < chars.length; i++) {

                //当前字符
                char c = chars[i];

                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                //栈顶元素
                char o = (char) stack.lastElement();

                //等于左边括号，直接入栈
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }

                //判断当前字符是否能与栈顶字符组成有效括号，若能，pop
                else if (c == ')' || c == ']' || c == '}') {
                    if ((o == '(' && c == ')') ||
                            (o == '[' && c == ']') ||
                            (o == '{' && c == '}')
                    ) {
                        stack.pop();
                    } else
                        stack.push(c);
                }
            }

            return stack.isEmpty();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}