package com.example.demo_practise.algorithm.LCHOT100;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: M_LC003_FindNoRepatSubString
 * Description: 25分钟，两次过
 * date: 2022/7/12 10:39
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC003_FindNoRepatSubString {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        int fromIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) != null) {
                count = Math.max(count, i - fromIndex);
                int index = map.get(s.charAt(i));
                for (int j = fromIndex; j <= index; j++) {
                    map.remove(s.charAt(j));
                }
                fromIndex = index + 1;
            }
            map.put(s.charAt(i), i);
        }
        return Math.max(count, s.length() - fromIndex);
    }

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
//
//    public static void dev(String[] args) {
//        String s = "dev";
//        System.out.dev(lengthOfLongestSubstring(s));
//    }
}
