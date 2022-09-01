package com.example.demo_practise.algorithm.LCHOT100;

import java.util.Stack;

/**
 * ClassName: H_LC032_Longest_Valid_Parentheses
 * Description:
 * date: 2022/7/14 10:56
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class H_LC032_Longest_Valid_Parentheses {
    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     */

    /**
     * 解法一：动态规划
     * 每两个遍历，状态数组记录当前下标字符所形成的合法的最长字符串
     *
     * 我们定义 \textit{dp}[i]dp[i] 表示以下标 ii 字符结尾的最长有效括号的长度。我们将 \textit{dp}dp 数组全部初始化为 00 。显然有效的子串一定以 \text{‘)’}‘)’ 结尾，因此我们可以知道以 \text{‘(’}‘(’ 结尾的子串对应的 \textit{dp}dp 值必定为 00 ，我们只需要求解 \text{‘)’}‘)’ 在 \textit{dp}dp 数组中对应位置的值。
     *
     * 我们从前往后遍历字符串求解 \textit{dp}dp 值，我们每两个字符检查一次：
     *
     * s[i] = \text{‘)’}s[i]=‘)’ 且 s[i - 1] = \text{‘(’}s[i−1]=‘(’，也就是字符串形如 “……()”“……()”，我们可以推出：
     *
     * \textit{dp}[i]=\textit{dp}[i-2]+2
     * dp[i]=dp[i−2]+2
     *
     * 我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 22 。
     *
     * s[i] = \text{‘)’}s[i]=‘)’ 且 s[i - 1] = \text{‘)’}s[i−1]=‘)’，也就是字符串形如 “……))”“……))”，我们可以推出：
     * 如果 s[i - \textit{dp}[i - 1] - 1] = \text{‘(’}s[i−dp[i−1]−1]=‘(’，那么
     *
     * \textit{dp}[i]=\textit{dp}[i-1]+\textit{dp}[i-\textit{dp}[i-1]-2]+2
     * dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     *
     * 我们考虑如果倒数第二个 \text{‘)’}‘)’ 是一个有效子字符串的一部分（记作 sub_ssub
     * s
     * ​
     *  ），对于最后一个 \text{‘)’}‘)’ ，如果它是一个更长子字符串的一部分，那么它一定有一个对应的 \text{‘(’}‘(’ ，且它的位置在倒数第二个 \text{‘)’}‘)’ 所在的有效子字符串的前面（也就是 sub_ssub
     * s
     * ​
     *   的前面）。因此，如果子字符串 sub_ssub
     * s
     * ​
     *   的前面恰好是 \text{‘(’}‘(’ ，那么我们就用 22 加上 sub_ssub
     * s
     * ​
     *   的长度（\textit{dp}[i-1]dp[i−1]）去更新 \textit{dp}[i]dp[i]。同时，我们也会把有效子串 “(sub_s)”“(sub
     * s
     * ​
     *  )” 之前的有效子串的长度也加上，也就是再加上 \textit{dp}[i-\textit{dp}[i-1]-2]dp[i−dp[i−1]−2]。
     *
     * 最后的答案即为 \textit{dp}dp 数组中的最大值。
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesByDP(String s) {
        int maxLen = 0;
        int[] dpLen = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                dpLen[i] = 2;
                if(i - 2 >= 0) {
                    dpLen[i] += dpLen[i - 2];
                }
            } else if (s.charAt(i - 1) == ')' && s.charAt(i) == ')' && i - dpLen[i - 1] - 1 >= 0) {
                if (s.charAt(i - dpLen[i - 1] - 1) == '(') {
                    dpLen[i] = dpLen[i - 1] + 2;
                    if(i - dpLen[i - 1] - 2 >= 0) {
                        dpLen[i] += dpLen[i - dpLen[i - 1] - 2];
                    }
                }

            }
            maxLen = Math.max(dpLen[i], maxLen);
        }
        return maxLen;
    }

    /**
     * 解法二：辅助栈解法一（'('存储正下标，‘）’存储负下标）
     * @param s
     * @return
     */
    public int longestValidParenthesesByStack(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        if(s.length() > 0 && s.charAt(0) == ')') {
            start = 1;
        }
        for (int i = start; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.empty() && stack.peek() >= 0){
                stack.pop();
                int index = stack.empty() ? start == 1 ? 0 : -1 : Math.abs(stack.peek());
                maxLen = Math.max(maxLen, i - index);
            } else {
                stack.push(-i);
            }
        }
        return maxLen;
    }

    /**
     * 解法二：辅助栈解法二（栈底存储未匹配的‘）’）
     * 做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
     *
     * 对于遇到的每个 \text{‘(’}‘(’ ，我们将它的下标放入栈中
     * 对于遇到的每个 \text{‘)’}‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
     * 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
     * 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     * 我们从前往后遍历字符串并更新答案即可。
     *
     * 需要注意的是，如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，这样就不满足提及的「最后一个没有被匹配的右括号的下标」，为了保持统一，我们在一开始的时候往栈中放入一个值为 -1−1 的元素。
     * @param s
     * @return
     */
    public int longestValidParenthesesByStackTwo(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, stack.peek());
                }

            }
        }
        return maxLen;
    }

    /**
     * 解法三：双指针解法
     * @param s
     * @return
     */
    public int longestValidParenthesesByDoublePoint(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right && left > 0) {
                maxLen = Math.max(maxLen, left);
            } else if(right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right && left > 0) {
                maxLen = Math.max(maxLen, left);
            } else if(right < left) {
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String  s = ")()())";
        System.out.println(new H_LC032_Longest_Valid_Parentheses().longestValidParenthesesByDP(s));
        System.out.println(new H_LC032_Longest_Valid_Parentheses().longestValidParenthesesByStack(s));
        System.out.println(new H_LC032_Longest_Valid_Parentheses().longestValidParenthesesByDoublePoint(s));
    }
}
