package com.example.demo_practise.algorithm.dynamic_programming;

import java.sql.Array;
import java.util.Arrays;

/**
 * ClassName: Fibonacci
 * Description:
 * date: 2022/7/11 10:28
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Fibonacci {
    /**
     * 斐波那契数列求解
     */

    /**
     * 时间复杂度O（n）, 空间复杂度O（n）
     * @param n
     * @return
     */
    public int resolve(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1 || n==2) {
            return 1;
        }
        // 空间复杂度为 O(n)
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        for(int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * 空间复杂度 O（3）
     * @param n
     * @return
     */
    public int resolve2(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1 || n==2) {
            return 1;
        }
        int bef1 = 1;
        int bef2 = 1;
        int res = -1;
        for(int i = 3; i <= n; i++) {
            res = bef1 + bef2;
            bef1 = bef2;
            bef2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().resolve(39));
        System.out.println(new Fibonacci().resolve2(39));
    }

}
