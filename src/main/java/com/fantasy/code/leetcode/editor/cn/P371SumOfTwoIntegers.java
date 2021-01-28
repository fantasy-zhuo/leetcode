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

//Java：两整数之和
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
            int result = a^b;
            //判断是否需要进位
            int forward = (a&b) <<1;
            if(forward!=0){
                //如有进位，则将二进制数左移一位，进行递归
                return getSum(result,forward);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}