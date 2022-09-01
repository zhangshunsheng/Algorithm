package com.example.demo_practise.algorithm.LCHOT100;

public class H_LC042_CatchTheRain {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     */
    public static int trap(int[] height) {
        if(height.length < 2) {
            return 0;
        }
        int lh = height[0];
        int rh = height[height.length - 1];
        int lindex = 0;
        int rindex = height.length - 1;
        int sum = 0;
        while (lindex < rindex) {
            if(lh > rh) {
                rindex--;
                if(rh > height[rindex]) {
                    sum += rh - height[rindex];
                } else {
                    rh = height[rindex];
                }
            } else {
                lindex++;
                if(lh > height[lindex]) {
                    sum += lh - height[lindex];
                } else {
                    lh = height[lindex];
                }
            }
        }
        return sum;
    }

    /**
     * 动态规划解法
     * @param height
     * @return
     */
    public static int resolveByDynamic(int[] height) {
        int[] lhigh = new int[height.length];
        int[] rhigh = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            lhigh[i] = Math.max(lhigh[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            rhigh[i] = Math.max(rhigh[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int low = Math.min(lhigh[i], rhigh[i]);
            if(low > height[i]) {
                sum += low - height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int t[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(t));
        int tt[] = {4,2,0,3,2,5};
        System.out.println(trap(tt));
        System.out.println("动态规划解法");
        System.out.println(resolveByDynamic(t));
        System.out.println(resolveByDynamic(tt));
    }
}
