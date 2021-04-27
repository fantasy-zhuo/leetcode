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

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

//Java：Excel表列名称
@Resolved
public class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        // TO TEST
        String s = solution.convertToTitle(702);

        System.out.println("s = " + s);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {

            String[] letters = new String[]{
                    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
            };

            if (n <= 0) {
                return null;
            }

            if (n <= 26 && n > 0) {
                return letters[n - 1];
            }

            StringBuilder builder = new StringBuilder();

            /*
                这里是从后往前推，先求余得出最后一位,把余数减去之后除以26，接着重复第一步直到n <= 0
             */
            while (n > 0) {

                int m = n % 26;
                if (m == 0) {
                    m = 26;
                }
                builder.append(letters[m-1]);
                n = (n - m) / 26;
            }

            return builder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}