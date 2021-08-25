//给定一个无重复元素的有序整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 num
//s 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 示例 3： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：["-1"]
// 
//
// 示例 5： 
//
// 
//输入：nums = [0]
//输出：["0"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -231 <= nums[i] <= 231 - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
// Related Topics 数组 
// 👍 170 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

import java.util.ArrayList;
import java.util.List;

//Java：汇总区间
@Resolved
public class P228SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new P228SummaryRanges().new Solution();
        // TO TEST

        int[] nums = new int[]{0,1,2,4,5,7};

        System.out.println("solution.summaryRanges(nums) = " + solution.summaryRanges(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {

            List<String> result = new ArrayList<>();

            Integer startNum = null;
            Integer endNum = null;
            Integer prevNum = null;
            StringBuilder builder = new StringBuilder();
            String section = null;

            for (int i = 0; i < nums.length; i++) {

                int num = nums[i];

                //第一次，记录区间开始值
                if (null == startNum) {
                    startNum = num;
                }

                //连续，记录区间结尾值
                else if (num == prevNum + 1){
                    endNum = num;
                }

                //不连续，形成区间
                else if (num > prevNum + 1) {
                    builder = new StringBuilder();
                    section = null == endNum ? builder.append(startNum).toString(): builder.append(startNum).append("->").append(endNum).toString();
                    result.add(section);
                    startNum = num;
                    endNum = null;
                }

                //记录当前值为前一个值
                prevNum = num;

                //最后一个值，不管有没有区间都放到列表里
                if (i == nums.length-1){
                    builder = new StringBuilder();
                    section = null == endNum ? builder.append(startNum).toString() : builder.append(startNum).append("->").append(endNum).toString();
                    result.add(section);
                }
            }

            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}