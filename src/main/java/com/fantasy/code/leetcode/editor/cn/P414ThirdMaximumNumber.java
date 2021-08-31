//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics 数组 排序 
// 👍 242 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

//Java：第三大的数
@Resolved
public class P414ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new P414ThirdMaximumNumber().new Solution();
        // TO TEST

        int[] nums = {-2147483648, 1, 1};
        System.out.println(solution.thirdMax(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {

            //赋值为最小值
            int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

            //判断数组中有没有与最小值相等的值
            boolean isMinValue = false;

            for (int i = 0; i < nums.length; i++) {

                int num = nums[i];

                //第一次进来，如果比第三大，再往下走
                if (num > third) {
                    //如果比第二大，再往下走
                    if (num > second) {
                        //如果比第一大，给第一赋值，同时第一二的值往后推
                        if (num > first) {
                            third = second;
                            second = first;
                            first = num;
                        }
                        //如果只比第二大，给第二赋值，同时第二的值往后推
                        else {
                            //前提是第二的值不等于第一的值
                            if (first != num) {
                                //第三的值也不能等于第二的值
                                if (second != num) {
                                    third = second;
                                }
                                second = num;
                            }
                        }
                    }
                    //如果只比第三大，给第三赋值，但不能等于第二
                    else {
                        if (second != num) {
                            third = num;
                        }
                    }
                }
                //数组中有最小值
                else {
                    isMinValue = num == Integer.MIN_VALUE;
                }
            }

            //isMinValue && third != second 代表数组中有最小值并且有三个最大数
            //third != Integer.MIN_VALUE  代表第三大的数不为最小值
            return (isMinValue && third != second) || (third != Integer.MIN_VALUE) ? third : first;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}