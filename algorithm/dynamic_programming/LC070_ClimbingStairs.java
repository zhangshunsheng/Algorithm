package com.example.demo_practise.algorithm.dynamic_programming;

/**
 * ClassName: LC070_ClimbingStairs
 * Description:
 * date: 2022/7/11 16:57
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class LC070_ClimbingStairs {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Note: Given n will be a positive integer.
     * @param n
     * @return
     */
    public static int resolve(int n) {
        if(n < 1) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int res2 = 1;
        int res1 = 2;
        int res = 0;
        for(int i = 3; i <= n; i++) {
            res = res1 + res2;
            res2 = res1;
            res1 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(resolve(4));
    }
}

