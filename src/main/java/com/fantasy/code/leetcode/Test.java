package com.fantasy.code.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhuo
 * @date 2020-12-23 11:15
 */
public class Test {

    public static void main(String[] args) {

        /*String s = "13692316030";

        boolean matches = s.matches("^[13|15|17|18|19]{9}");

        System.out.println("matches = " + matches);*/

        String a = "111223333233";

        Pattern pattern = Pattern.compile("(.)\\1+|(.)");

        Matcher matcher = pattern.matcher(a);

        boolean matches = matcher.find();

        StringBuilder stringBuilder = new StringBuilder();

        while (matches){
            String group = matcher.group();
            System.out.println("matcher.group() = " + group);

            String substring = matcher.group(1);
            if (null == substring){
                substring = group.substring(0 ,1);
            }
            stringBuilder.append(group.length());
            stringBuilder.append(substring);
            matches = matcher.find();

        }

        System.out.println("stringBuilder.toString() = " + stringBuilder.toString());
    }
}
