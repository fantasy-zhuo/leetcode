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

//        boolean valid = solution.isValid("[{}[]]");
        boolean valid = solution.isValid("({{{{}}}))");
//        boolean valid = solution.isValid("(){}}{");


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

            first:
            while (currentIndex < length) {

                char startChar = chars[currentIndex];

                //如果是括号的开头，则从后往前找直到遇到自己
                if (startChar == '(' || startChar == '[' || startChar == '{') {

                    int startIndex = currentIndex;

                    int endIndex = length;

                    while (startIndex < endIndex) {

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

                        //如果找到一个匹配的就跳出这次的循环
                        if (flag) {
                            currentIndex++;
                            if (endIndex == length)
                                length--;
                            continue first;
                        }
                        //如果从后往前找直到遇到自己都找不到，直接返回false，因为有一个找不到匹配就是不符合的
                        else if (((length - 1) == startIndex) && flag == false) {
                            break first;
                        }
                        //如果没匹配到就再往前找
                        else {
                            endIndex--;
                        }
                    }
                }
                //如果是括号的结尾，则从前完后找直到遇到自己
                else if (startChar == ')' || startChar == ']' || startChar == '}') {

                    int startIndex = 0;

                    int endIndex = currentIndex;

                    while (startIndex < endIndex) {

                        //求余，余数相等的为false
                        int start = startIndex % 2;

                        int end = endIndex % 2;

                        if (start == end) {
                            startIndex++;
                            continue;
                        }

                        char endChar = chars[startIndex];

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

                        //如果找到一个匹配的就跳出这次的循环
                        if (flag) {
                            currentIndex++;
                            continue first;
                        }
                        //如果从前往后直到遇到自己都找不到，直接返回false，因为有一个找不到匹配就是不符合的
                        else if (((length - 1) == startIndex) && flag == false) {
                            break first;
                        }
                        //如果没匹配到就再往后找
                        else {
                            startIndex++;
                        }
                    }
                }

                //如果匹配完都没有找到合适的，直接跳出
                if ((length == currentIndex) && flag == false) {
                    break;
                }

                //如果匹配完flag还是true，说明目前都是可以匹配到的，继续往下匹配
                currentIndex++;
            }

            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}