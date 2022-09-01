package com.example.demo_practise.algorithm.LCHOT100;

/**
 * ClassName: M_LC011_HoldTheMostWater
 * Description:
 * date: 2022/7/12 11:23
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC011_HoldTheMostWater {
    /**
     * fail
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     */
    // 双指针解法
    public static int maxArea(int[] height) {
        int lIndex = 0;
        int rIndex = height.length - 1;
        int maxArea = 0;
        while (lIndex != rIndex) {
            maxArea = Math.max((rIndex - lIndex) * Math.min(height[lIndex], height[rIndex]), maxArea);
            if(height[lIndex] > height[rIndex]) {
                rIndex--;
            } else {
                lIndex++;
            }
        }
        return maxArea;
    }

    // 动态规划解法
    public int maxAreaByDP(int[] height) {
        int maxArea = 0;
        int lh[] = new int[height.length];
        lh[0] = height[0];
        int rh[] = new int[height.length];
        rh[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            lh[i] = Math.max(lh[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            rh[i] = Math.max(rh[i + 1], height[i + 1]);
        }

        int maxAreaArr[] = new int[height.length - 1];
        for (int i = 0; i < maxAreaArr.length; i++) {
            if(lh[i] < height[i]) {
                maxAreaArr[i] = Math.min(height[i], rh[i]);
            } else {
                maxAreaArr[i] = Math.min(lh[i], rh[i]);
            }
        }
        fastSort(maxAreaArr, 0, maxAreaArr.length - 1);
        for (int i = 0; i < maxAreaArr.length; i++) {
            int area = maxAreaArr[i];
            maxArea = Math.max(maxArea, (maxAreaArr.length - i) * area);
            while (i < maxAreaArr.length && maxAreaArr[i] != area) {
                i++;
            }
        }
        return maxArea;
    }

    public void fastSort(int[] arr, int start, int end) {
        if(start >= end || arr.length < 2 || end > arr.length - 1 || start < 0) {
            return;
        }
        int compare = arr[start];
        int base = start;
        int finanIndex = end;
        while (base < finanIndex) {
            if (arr[finanIndex] < compare) {
                arr[base] = arr[finanIndex];
                arr[finanIndex] = arr[++base];
            } else {
                finanIndex--;
            }
        }
        arr[base] = compare;
        fastSort(arr, start, base);
        fastSort(arr, base + 1, end);
    }

    public void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

    public static void main(String[] args) {
        int[] height = {1,7};
        System.out.println(maxArea(height));
        System.out.println(new M_LC011_HoldTheMostWater().maxAreaByDP(height));
    }
}
