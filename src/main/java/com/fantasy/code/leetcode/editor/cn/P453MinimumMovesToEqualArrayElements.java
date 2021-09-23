//给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。 
//
// 
//
// 示例： 
//
// 
//输入：
//[1,2,3]
//输出：
//3
//解释：
//只需要3次操作（注意每次操作会增加两个元素的值）：
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
// 
// Related Topics 数组 数学 
// 👍 252 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

import java.util.Arrays;

//Java：最小操作次数使数组元素相等
@Resolved
public class P453MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        Solution solution = new P453MinimumMovesToEqualArrayElements().new Solution();
        // TO TEST
        int[] nums = new int[]{5, 6, 8, 8, 5};
        System.out.println(solution.minMoves(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves(int[] nums) {

            Arrays.sort(nums);

            int min = nums[0];

            int count = 0;

            for (int num : nums) {
                count += num - min;
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}