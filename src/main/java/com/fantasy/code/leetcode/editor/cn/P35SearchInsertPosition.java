//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 758 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

import java.util.Arrays;

@Resolved
//Java：搜索插入位置
public class P35SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        // TO TEST

        int i = solution.searchInsert(new int[]{1,3,5,6}, 7);

        System.out.println("i = " + i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {

        System.err.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        System.err.println("target = " + target);

        Integer index = null;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == target)
                return i;
            else if (num > target){
                if (index == null) {
                    index = i;
                    break;
                }
            }
        }
        return index == null ? nums.length : index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}