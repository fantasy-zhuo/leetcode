//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 344 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

//Java：两整数之和
@Resolved
public class P371SumOfTwoIntegers {
    public static void main(String[] args) {

        Solution solution = new P371SumOfTwoIntegers().new Solution();
        // TO TEST
        int sum = solution.getSum(-10, 83);

        System.out.println("sum = " + sum);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            // write your code here
            if ((a & b) == 0)
                return a|b;
            return getSum(a^b,(a&b)<<1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}