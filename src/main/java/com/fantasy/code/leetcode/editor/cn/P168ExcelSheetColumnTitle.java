//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 306 👎 0


package com.fantasy.code.leetcode.editor.cn;

//Java：Excel表列名称
public class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        // TO TEST

        String result = "";

        int n = 701;

        System.out.println("(char)(1+64) = " + (char) (2 + 64));

        System.out.println("Math.pow(26,0) = " + Math.pow(26, 1));

        String[] letters = new String[]{
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };

        String s = "";
        while (n > 0) {
            int m = n % 26;
            if (m == 0) {
                //说明n = 26的倍数，那么这块就应该转换成Z
                m = 26;
            }
            s = (char) (m + 64) + s;//大写A的ASCII码值为65,m[1,26]

            n = (n - m) / 26;
        }

        result = s;

        System.out.println("result = " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {

            String[] letters = new String[]{
                    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
            };


            int num = 0;//位数

            while (n / 26 > 26) {
                num++;
                n = n / 26;
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}