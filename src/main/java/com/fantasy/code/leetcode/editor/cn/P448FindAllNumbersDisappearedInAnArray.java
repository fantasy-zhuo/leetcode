//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 
// 👍 800 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

import java.util.*;

//Java：找到所有数组中消失的数字
@Resolved
public class P448FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
        // TO TEST

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(nums);

        System.out.println(Arrays.toString(disappearedNumbers.toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {

            return simple(nums);
        }

        public List<Integer> simple(int[] nums) {

            int length = nums.length;

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < length; i++) {
                map.put(nums[i], 0);
            }

            List<Integer> list = new ArrayList<>();

            for (int i = 1; i <= length; i++) {

                if (!map.containsKey(i)) {
                    list.add(i);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}