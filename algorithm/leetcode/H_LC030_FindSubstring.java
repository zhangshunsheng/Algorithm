package com.example.demo_practise.algorithm.leetcode;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: H_LC030_FindSubstring
 * Description:
 * date: 2022/7/14 17:33
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class H_LC030_FindSubstring {
    /**
     * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     *
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
     *
     * 示例 1：
     * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     */

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0 || words.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        generateMap(map, words);
        int step = words[0].length();
        for (int i = 0; i < s.length(); i++) {
            if(i + step <= s.length() && map.get(s.substring(i, i + step)) != null && checkSubString(s, words, i) != -1) {
                res.add(i);
            }
        }
        return res;
    }

    private void generateMap (HashMap<String, Integer> map, String[] words)  {
        for (int i = 0; i < words.length; i++) {
            if(map.get(words[i]) == null) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
    }

    private int checkSubString(String s, String[] words, int begin) {
        HashMap<String, Integer> map = new HashMap<>();
        generateMap(map, words);
        int stringLength = words[0].length();
        int keyLength = words.length;
        for(int i = 0; i < keyLength; i++) {
            int startIndex = begin + i * stringLength;
            if(startIndex > s.length() - stringLength) {
                return -1;
            } else {
                String compareString = s.substring(startIndex, startIndex + stringLength);
                if(map.get(compareString) == null) {
                    return -1;
                } else if(map.get(compareString) > 1) {
                    map.put(compareString, map.get(compareString) - 1);
                } else {
                    map.remove(compareString);
                }
            }
        }
        return 1;
    }

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 99.53%
     * 的用户
     * 内存消耗：
     * 41.5 MB
     * , 在所有 Java 提交中击败了
     * 99.13%
     * 的用户
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        Map<String, Integer> idMap = new HashMap<>();
        for (String word : words) {
            idMap.putIfAbsent(word, idMap.size());
        }
        int[] cntMap = new int[idMap.size()];
        for (String word : words) {
            cntMap[idMap.get(word)]++;
        }
        char[] chs = s.toCharArray();
        int m = chs.length, n = words.length;
        int wordLen = words[0].length(), totalLen = n * wordLen;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < wordLen; i++) {
            for (int j = i; j <= m - totalLen; j += wordLen) {
                int[] window = new int[idMap.size()];
                for (int idx = n - 1; idx >= 0; idx--) {
                    int begin = j + idx * wordLen;
                    String word = new String(chs, begin, wordLen);
                    Integer id = idMap.get(word);
                    if (id == null || window[id]++ == cntMap[id]) {
                        j = begin;
                        break;
                    }
                    if (idx == 0) {
                        indices.add(j);
                    }
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        String s = "barfoobdarthedffoobarbarman";
        String[] words = new String[]{"foo","bar","bar"};
        System.out.println(new H_LC030_FindSubstring().findSubstring2(s, words));
    }
}
