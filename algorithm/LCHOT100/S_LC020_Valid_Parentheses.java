package com.example.demo_practise.algorithm.LCHOT100;

import java.util.*;

/**
 * ClassName: S_LC020_Valid_Parentheses
 * Description:
 * date: 2022/7/14 9:51
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class S_LC020_Valid_Parentheses {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     */
    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        List<Character> left = new ArrayList<Character>(){{add('{');add('[');add('(');}};
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        //        List<Character> right = Arrays.asList('}',']',')');
        for (int i = 0; i < s.length(); i++) {
            if(left.contains(s.charAt(i))) {
                charStack.push(s.charAt(i));
            } else if(charStack.empty() || (!map.get(charStack.pop()).equals(s.charAt(i)))) {
                return false;
            }
        }
        return charStack.empty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
