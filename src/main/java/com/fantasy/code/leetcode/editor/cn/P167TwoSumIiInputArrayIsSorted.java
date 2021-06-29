//给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。 
//
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
// < answer[1] <= numbers.length 。 
//
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
// 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 104 
// -1000 <= numbers[i] <= 1000 
// numbers 按 递增顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 531 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

//Java：两数之和 II - 输入有序数组
@Resolved
public class P167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
        // TO TEST

        int[] numbers = new int[]{-3, 3, 4, 90};
        int target = 0;
        int[] ints = solution.twoSum(numbers, target);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {

            return getInt(numbers, target);
        }

        private int[] getInt(int[] numbers, int target) {

            int length = numbers.length;
            int left = 0;
            int right = length - 1;
            int[] result = new int[2];

            while (length > 0) {
                int leftNumber = numbers[left];
                int rightNumber = numbers[right];
                int sum = leftNumber + rightNumber;
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    break;
                }
            }

            return result;
        }

        private int[] getInts(int[] numbers, int target) {
            int[] result = new int[2];

            flag:
            for (int i = 0; i < numbers.length; i++) {

                result[0] = i + 1;

                for (int j = i + 1; j < numbers.length; j++) {

                    if (target == numbers[i] + numbers[j]) {
                        result[1] = j + 1;
                        break flag;
                    }

                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}