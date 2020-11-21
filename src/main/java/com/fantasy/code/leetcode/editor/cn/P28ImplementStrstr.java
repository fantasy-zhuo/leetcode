//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 623 👎 0


package com.fantasy.code.leetcode.editor.cn;
//Java：实现 strStr()
public class P28ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        // TO TEST
        int i = solution.strStr("hello", "lo");

        System.out.println("i = " + i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        //得出haystack的长度
        int length = haystack.length();

        //得出needle的长度
        int needleLength = needle.length();

        if (haystack == null ||
                needle == null ||
                length < needleLength)
            return -1;

        //第一次先从0开始截取needleLength来比较
        int index = 0;

        //截取后的字符串
        String subStr;
        boolean flag = false;

        while (!flag) {
            if ((index + needleLength) > length) {
                index = -1;
                break;
            }

            subStr = haystack.substring(index, index + needleLength);

            if (subStr.equals(needle)) {
                flag = true;
            } else {
                index = index + 1;
            }
        }

        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}