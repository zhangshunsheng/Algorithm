package com.example.demo_practise.algorithm.dynamic_programming;

/**
 * ClassName: Skip_steps
 * Description: 跳台阶问题
 * date: 2022/7/11 12:50
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Skip_steps {
    /**
     * 一只青蛙每次只能跳一个或者两个台阶，问他跳到第n个台阶有几种方法
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
        int res1 = 1;
        int res2 = 2;
        int res = 0;
        for(int i = 0; i <= n; i++) {
            res = Math.max(res1 + 1, res2 + 1);
            res1 = res;
            res2 = res1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(resolve(15));
    }
}
