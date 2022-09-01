package com.example.demo_practise.algorithm.LCHOT100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: M_LC017_GetPhoneNumString
 * Description:
 * date: 2022/7/14 14:52
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC017_GetPhoneNumString {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     */

    /**
     * 解法一：使用队列
     * @param digits
     * @return
     */
    public List<String> letterCombinationsByQueue(String digits) {
        Queue<String> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() < 1) {
            return res;
        }
        HashMap<Character, String[]> map = new HashMap(){{
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};

        for (int i = 0; i < digits.length(); i++) {
            changeQueue(queue, map.get(digits.charAt(i)));
        }

        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }

        return res;
    }

    private void changeQueue(Queue<String> queue, String[] chars) {
        if(queue.size() == 0) {
            for (int i = 0; i < chars.length; i++) {
                queue.add(chars[i]);
            }
        } else {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                String s = queue.poll();
                for (int i1 = 0; i1 < chars.length; i1++) {
                    queue.add(s + chars[i1]);
                }
            }
        }
    }

    /**
     * 解法一：使用回溯 TODO 深度回溯未吸收（电话号码）
     * @param digits
     * @return
     */
    public List<String> letterCombinationsByDfs(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }



    public static void main(String[] args) {
        String s = "234";
        System.out.println(new M_LC017_GetPhoneNumString().letterCombinationsByQueue(s));
    }
}
