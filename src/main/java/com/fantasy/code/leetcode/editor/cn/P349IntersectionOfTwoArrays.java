//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 388 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

import java.util.*;

//Java：两个数组的交集
@Resolved
public class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST

        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};

        System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            Set<Integer> source = new HashSet<>() , resultSet = new HashSet<>();

            for (int i : nums1) {
                source.add(i);
            }

            for (int i : nums2) {
                if (source.contains(i)){
                    resultSet.add(i);
                }
            }

            int[] result = new int[resultSet.size()];
            int index = 0;

            for (Integer integer : resultSet) {
                result[index++] = integer;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}