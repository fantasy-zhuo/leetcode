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

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST

        boolean valid = solution.isValid("([])");

        System.out.println("valid = " + valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            //null直接返回false
            if (s == null || (s != "" && s.length() % 2 != 0))
                return false;

            //空字符串返回true
            if (s == "")
                return true;

            if (!s.startsWith("(") && !s.startsWith("[") && !s.startsWith("{"))
                return false;

            char[] chars = s.toCharArray();

            int currentIndex = 0;

            int length = chars.length - 1;

            boolean flag = true;

            while (currentIndex < length) {

                char startChar = chars[currentIndex];

                //如果是括号的开头，则从后往前找直到遇到自己
                if (startChar == '(' || startChar == '[' || startChar == '{'){

                    int startIndex = currentIndex;

                    int endIndex = length;

                    while (startIndex < endIndex){

                        //求余，余数相等的为false
                        int start = startIndex % 2;

                        int end = endIndex % 2;

                        if (start == end) {
                            endIndex--;
                            continue;
                        }

                        char endChar = chars[endIndex];

                        switch (startChar) {
                            case '(':
                                flag = endChar == ')';
                                break;
                            case '[':
                                flag = endChar == ']';
                                break;
                            case '{':
                                flag = endChar == '}';
                                break;
                        }

                        if (flag) {
                            startIndex++;
                            length = chars.length - 1;
                        } else if (((length - 1) == currentIndex) && flag == false) {
                            break;
                        } else {
                            length--;
                        }
                    }
                }
                //如果是括号的结尾，则从前完后找直到遇到自己
                else if (startChar == ')' || startChar == ']' || startChar == '}'){

                    int startIndex = 0;

                    int endIndex = currentIndex;

                    while (startIndex < endIndex){

                        //求余，余数相等的为false
                        int start = startIndex % 2;

                        int end = endIndex % 2;

                        if (start == end) {
                            endIndex--;
                            continue;
                        }

                        char endChar = chars[endIndex];

                        switch (startChar) {
                            case ')':
                                flag = endChar == '(';
                                break;
                            case ']':
                                flag = endChar == '[';
                                break;
                            case '}':
                                flag = endChar == '{';
                                break;
                        }
                    }
                }


                if (flag) {
                    currentIndex++;
                    length = chars.length - 1;
                } else if (((length - 1) == currentIndex) && flag == false) {
                    break;
                } else {
                    length--;
                }

            }

            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}