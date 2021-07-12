//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1102 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

import java.util.Arrays;

//Java：移动零
@Resolved
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
        int[] nums = new int[]{0, 1, 0, 0, 3, 12};

        System.out.println("原======:" + Arrays.toString(nums));

        solution.moveZeroes(nums);

        System.out.println("后======:" + Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {

            int zeroNum = 0;//用来计算0的个数
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {//如果nums[i]=0,zeroNum个数加一
                    zeroNum++;
                } else if (zeroNum != 0) {//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                    nums[i - zeroNum] = nums[i];
                    nums[i] = 0;
                }
            }
        }


        /**
         * 思路：
         * 循环，如果当前述等于0，则与下一个不为0的数交换位置，一直交换到最后一个
         *
         * @param nums
         */
        private void firstVersion(int[] nums) {
            int length = nums.length;
            int currentIndex = 0;

            while (currentIndex < length) {
                int num = nums[currentIndex];

                if (num == 0) {
                    int nextIndex = currentIndex + 1;
                    //找到下一个不为0的数
                    int nextNum = 0;
                    while (nextNum == 0 && nextIndex <= length - 1) {
                        nextNum = nums[nextIndex];
                        if (nextNum != 0)
                            break;
                        else
                            nextIndex++;
                    }

                    //交换位置
                    if (nextIndex < length) {
                        nums[currentIndex] = nextNum;
                        nums[nextIndex] = num;
                    }
                }

                currentIndex++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}