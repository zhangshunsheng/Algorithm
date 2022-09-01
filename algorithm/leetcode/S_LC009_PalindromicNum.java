package com.example.demo_practise.algorithm.leetcode;

/**
 * ClassName: S_LC009_PalindromicNum
 * Description:
 * date: 2022/7/13 13:03
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class S_LC009_PalindromicNum {
    public static boolean isPalindrome(int x) {
        String s = x + "";
        String s1 = s.substring(0, s.length() / 2);
        String s2 = "";
        if(s.length() % 2 == 0) {
            s2 = s.substring(s.length() / 2, s.length());
        } else {
            s2 = s.substring(s.length() / 2 + 1, s.length());
        }
        return s1.equals(new StringBuffer(s2).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(11));
    }
}
