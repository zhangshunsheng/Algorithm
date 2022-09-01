package com.example.demo_practise.algorithm.dynamic_programming;

/**
 * ClassName: SubarraySumEqualsK
 * Description:
 * date: 2022/7/11 14:06
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class SubarraySumEqualsK {
    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的子数组。如果存在该子数组返回true，否则返回false。
     * 输入输出：
     * input：{3， 34， 4, 12，5, 2}, 9
     * output：true
     */

    public static boolean resolveByRecursion(int[] arr, int index, int sum) {
        if(sum == 0) {
            return true;
        }
        if(index < 0) {
            return false;
        }
        boolean res = false;
        if(sum - arr[index] >= 0) {
            res = resolveByRecursion(arr, index-1, sum - arr[index]);
        }
        return  res == true ? res : resolveByRecursion(arr, index-1, sum);
    }

    private static boolean resolveByDynamic(int arr[], int sum) {
        if(sum < 1 || arr.length < 1) {
            return false;
        }
        // 设置状态转移方程
        int dpStatus[][] = new int[arr.length][sum + 1];
        for (int i = 0; i < dpStatus.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if(i == 0) {
                    if(j == arr[i]) {
                        dpStatus[i][j] = 1;
                    }
                } else {
                    if(j - arr[i] > 0) {
                        dpStatus[i][j] = Math.max(dpStatus[i - 1][j - arr[i]], dpStatus[i - 1][j]);
                    } else if(j - arr[i] == 0) {
                        dpStatus[i][j] = 1;
                    } else {
                        dpStatus[i][j] = dpStatus[i - 1][j];
                    }
                }
            }
        }
        return dpStatus[arr.length - 1][sum] == 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12,5, 2};
        System.out.println(resolveByRecursion(arr, arr.length - 1, 9));
        System.out.println(resolveByRecursion(arr, arr.length - 1, 10));
        System.out.println(resolveByRecursion(arr, arr.length - 1, 11));
        System.out.println(resolveByRecursion(arr, arr.length - 1, 12));
        System.out.println(resolveByRecursion(arr, arr.length - 1, 31));

        System.out.println(resolveByDynamic(arr, 9));
        System.out.println(resolveByDynamic(arr, 10));
        System.out.println(resolveByDynamic(arr, 11));
        System.out.println(resolveByDynamic(arr, 12));
        System.out.println(resolveByDynamic(arr, 31));
    }
}
