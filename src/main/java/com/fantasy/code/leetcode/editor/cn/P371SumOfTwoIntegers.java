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
        int sum = solution.getSum(-7, 3);

//        System.out.println("sum = " + sum);

        int a = -5;

        System.err.println("**************原数**************" + a);

        //取反后的原码的值
        int i = ~a;

        String binary = "";

        for (int j = 0; j < 32; j++) {
            binary += "0";
        }

        System.err.println("**************取反后**************" + i);

        char[] chars = binary.toCharArray();

        //计算取反之后的原码
        int num = 0;

        int backup = i;

        while (i != 1 && i > 0) {

            i = i - (2 << num);

            num++;


            if (i <= 1) {

                int value = 1 << num;

                int sub = backup - value;

                if (sub >= 1 || sub == 0) {

                    chars[chars.length - num - 1] = '1';

                    backup = sub;

                    i = backup;

                    num = 0;
                }

            }
        }

        if (backup % 2 == 1) {
            chars[chars.length - 1] = '1';
        }

        //计算取反后原码的反码,并加一
        for (int z = 0; z < chars.length-1; z++) {
            chars[z] = chars[z] == '0' ? '1' : '0';

            //加一
            if (z == chars.length -1){

            }
        }

        System.err.println("***************取反后的二进制*************" + String.valueOf(chars));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {


            if (a < 0)
                a = ~a;
            if (b < 0)
                b = ~b;
            return a ^ b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}