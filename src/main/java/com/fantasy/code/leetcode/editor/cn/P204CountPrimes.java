//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 数组 数学 枚举 数论 
// 👍 736 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

import java.util.Arrays;

//Java：计数质数
@Resolved
public class P204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
        // TO TEST

        System.out.println(solution.countPrimes(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {

            int count = 0;

            if (n <= 2) {
                return count;
            }

            int[] primes = new int[n];

            Arrays.fill(primes, 1);

            for (int i = 2; i < n; i++) {

                //从2开始，如果为1就代表是质数
                if (primes[i] == 1) {
                    count++;

                    //如果i的平方大于等于n，代表已经超出n的范围，已经处理完了
                    if ((long) i * i >= n) {
                        continue;
                    }

                    //如果i的倍数在n之内，可以认为他们都不是质数，改值为0
                    for (int j = i * i; j > 0 && j < n; j += i) {
                        primes[j] = 0;
                    }
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}