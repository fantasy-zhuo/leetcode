//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 138 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：键盘行
@Resolved
public class P500KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new P500KeyboardRow().new Solution();
        // TO TEST
        String[] words = new String[]{"Aasdfghjkl", "Qwertyuiop", "zZxcvbnm"};

        System.out.println(Arrays.toString(solution.findWords(words)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            return simple(words);
        }

        public String[] simple(String[] words) {
            String first = "qwertyuiop";
            String second = "asdfghjkl";
            String third = "zxcvbnm";

            List<String> list = new ArrayList<>();

            for (String word : words) {

                boolean hasAll = true;
                boolean allFirst = false;
                boolean allSecond = false;
                boolean allThird = false;

                String[] split = word.split("");
                String s;
                for (int i = 0; i < split.length; i++) {

                    s = split[i];

                    if (i == 0) {
                        if (first.contains(s.toLowerCase())) {
                            allFirst = true;
                        } else if (second.contains(s.toLowerCase())) {
                            allSecond = true;
                        } else if (third.contains(s.toLowerCase())) {
                            allThird = true;
                        }
                    } else {
                        if (allFirst && !first.contains(s.toLowerCase())) {
                            hasAll = false;
                            break;
                        } else if (allSecond && !second.contains(s.toLowerCase())) {
                            hasAll = false;
                            break;
                        } else if (allThird && !third.contains(s.toLowerCase())) {
                            hasAll = false;
                            break;
                        }
                    }
                }

                if (hasAll) {
                    list.add(word);
                }
            }

            String[] result = new String[list.size()];

            list.toArray(result);

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}