//给定一个正整数 n ，输出外观数列的第 n 项。 
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。 
//
// 你可以将其视作是由递归公式定义的数字字符串序列： 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。 
// 
//
// 前五项如下： 
//
// 
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//第一项是数字 1 
//描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
//描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
//描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
//描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
// 
//
// 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成
//一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。 
//
// 例如，数字字符串 "3322251" 的描述如下图： 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出："1"
//解释：这是一个基本样例。
// 
//
// 示例 2： 
//
// 
//输入：n = 4
//输出："1211"
//解释：
//countAndSay(1) = "1"
//countAndSay(2) = 读 "1" = 一 个 1 = "11"
//countAndSay(3) = 读 "11" = 二 个 1 = "21"
//countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 30 
// 
// Related Topics 字符串 
// 👍 611 👎 0


package com.fantasy.code.leetcode.editor.cn;

import com.fantasy.code.leetcode.editor.cn.annotation.Resolved;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Java：外观数列
@Resolved
public class P38CountAndSay {
    public static void main(String[] args) {
        Solution solution = new P38CountAndSay().new Solution();
        // TO TEST
        String s = solution.countAndSay(8);

        System.out.println("s = " + s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {

            String str = "1";

            if (n == 1)
                return str;

            str = countAndSay(n-1);

            Pattern pattern = Pattern.compile("(.)\\1+|(.)");

            Matcher matcher = pattern.matcher(str);

            boolean matches = matcher.find();

            StringBuilder stringBuilder = new StringBuilder();

            while (matches) {
                String group = matcher.group();
                String substring = matcher.group(1);
                if (null == substring) {
                    substring = group.substring(0, 1);
                }
                stringBuilder.append(group.length());
                stringBuilder.append(substring);
                matches = matcher.find();
            }

            String value = stringBuilder.toString();

            return value;

        }

        public String countList(int n) {
            String str = "1";

            if (n == 1)
                return str;

            if (n == 2) {
                str = "11";
                return str;
            }

            if (n > 2) {
                str = "11";
            }

            /**
             * 从左到右，从第一个字符开始找，
             * 找到不相同的后，记录下来，移动到下一位，继续找
             * 找到相同的继续找，知道遇到不相同的，先记录，接着从不相同的找起
             * 用list存储
             */

            String value = str;

            List<String> list = new ArrayList<>();

            for (int z = 2; z < n; z++) {

                char[] chars = value.toCharArray();

                int length = chars.length;

                int duplicateIndex = 0;

                while (duplicateIndex < length) {
                    int count = 1;

                    char aChar = chars[duplicateIndex];

                    int index = duplicateIndex + 1;

                    while (index < length) {
                        char c = chars[index];

                        if (aChar == c) {
                            count = count + 1;
                            index++;
                        } else {
                            break;
                        }
                    }

                    if (count == 1) {
                        duplicateIndex++;
                    } else {
                        duplicateIndex = index;
                    }

                    list.add(count + "");
                    list.add(aChar + "");
                }

                StringBuilder stringBuilder = new StringBuilder();

                for (String s : list) {

                    stringBuilder.append(s);
                }

                value = stringBuilder.toString();

                list = new ArrayList<>();

            }

            return value;
        }

        public String countMap(int n) {
            String str = "1";

            if (n == 1)
                return str;

            if (n == 2) {
                str = "11";
                return str;
            }

            if (n > 2) {
                str = "11";
            }

            /**
             * 从左到右，从第一个字符开始找，
             * 找到不相同的后，记录下来，移动到下一位，继续找
             * 找到相同的继续找，知道遇到不相同的，先记录，接着从不相同的找起
             * 用map存储，key为下表加字符值，value为数量
             */

            String value = str;

            String sperator = "-";


            for (int z = 2; z < n; z++) {

                char[] chars = value.toCharArray();

                int length = chars.length;

                LinkedHashMap<String, Integer> countMap = new LinkedHashMap<>();

                int duplicateIndex = 0;

                while (duplicateIndex < length) {
                    int count = 1;

                    char aChar = chars[duplicateIndex];

                    int index = duplicateIndex + 1;

                    while (index < length) {
                        char c = chars[index];

                        if (aChar == c) {
                            count = count + 1;
                            index++;
                        } else {
                            break;
                        }
                    }

                    if (count == 1) {
                        duplicateIndex++;
                    } else {
                        duplicateIndex = index;
                    }

                    String key = aChar + sperator + duplicateIndex;

                    countMap.put(key, count);
                }

                StringBuilder stringBuilder = new StringBuilder();

                for (Map.Entry<String, Integer> stringIntegerEntry : countMap.entrySet()) {

                    String key = stringIntegerEntry.getKey();

                    String[] split = key.split(sperator);

                    String s = split[0];

                    Integer entryValue = stringIntegerEntry.getValue();

                    stringBuilder.append(entryValue);
                    stringBuilder.append(s);
                }

                value = stringBuilder.toString();

            }

            return value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}