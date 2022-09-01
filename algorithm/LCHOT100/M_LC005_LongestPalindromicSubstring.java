package com.example.demo_practise.algorithm.LCHOT100;

/**
 * ClassName: M_LC005_LongestPalindromicSubstring
 * Description: 5次提交
 * date: 2022/7/13 10:18
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC005_LongestPalindromicSubstring {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     */

    public String longestPalindromeMyself(String s) {
        if(s.length() < 2) {
            return s;
        }
        String res = s.charAt(0) + "";
        for (int i = 0; i < s.length() - 1; i++) {
            String temp = judge(s, i);
            if(res.length() < temp.length()) {
                res = temp;
            }
        }
        return res;
    }

    public String judge(String s, int index) {
        int left = index - 1;
        int right = index + 1;
        int resOddLeftLen = 0;
        int resEvenLeftLen = 0;
        while (left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) {
                break;
            } else {
                left--;
                right++;
                resOddLeftLen++;
            }
        }
        left = index;
        right = index + 1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            } else {
                left--;
                right++;
                resEvenLeftLen++;
            }
        }
        if(resOddLeftLen >= resEvenLeftLen) {
            return s.substring(index - resOddLeftLen, index + resOddLeftLen + 1);
        } else {
            return s.substring(index - resEvenLeftLen + 1, index + resEvenLeftLen + 1);
        }
    }

    public String resolveByDP(String s) {
        if(s.length() < 2) {
            return s;
        }
        int dp[][] = new int[s.length() + 1][s.length() + 1];
        String sr = new StringBuffer(s).reverse().toString();
        int length = 0;
        int indexX = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if(s.charAt(i - 1) == sr.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > length && s.length() + 1 - j + dp[i][j] - 1 == i) {
                        length = dp[i][j];
                        indexX = i;
                    }
                }
            }
        }
        return s.substring(indexX - length, indexX);
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(new M_LC005_LongestPalindromicSubstring().longestPalindromeMyself(s));
        System.out.println(new M_LC005_LongestPalindromicSubstring().resolveByDP(s));
        String ss = "bbf";
        System.out.println(new M_LC005_LongestPalindromicSubstring().longestPalindromeMyself(ss));
        System.out.println(new M_LC005_LongestPalindromicSubstring().resolveByDP(ss));
        String sss = "bff";
        System.out.println(new M_LC005_LongestPalindromicSubstring().longestPalindromeMyself(sss));
        System.out.println(new M_LC005_LongestPalindromicSubstring().resolveByDP(sss));
        String ssss = "berbsdbreb";
        System.out.println(new M_LC005_LongestPalindromicSubstring().longestPalindromeMyself(ssss));
        System.out.println(new M_LC005_LongestPalindromicSubstring().resolveByDP(ssss));
        String sssss = "adcdfdssdgsg";
        System.out.println(new M_LC005_LongestPalindromicSubstring().longestPalindromeMyself(sssss));
        System.out.println(new M_LC005_LongestPalindromicSubstring().resolveByDP(sssss));
    }
}
