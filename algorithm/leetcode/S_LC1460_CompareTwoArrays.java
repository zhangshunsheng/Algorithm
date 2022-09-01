package com.example.demo_practise.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName: S_LC1460_CompareTwoArrays
 * Description:
 * date: 2022/7/20 15:49
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class S_LC1460_CompareTwoArrays {
    public static boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            Integer count = map.getOrDefault(target[i], 0);
            map.put(target[i], ++count);
        }
        for(int i = 0; i < arr.length; i++) {
            Integer count = map.getOrDefault(arr[i], 0);
            if(map.getOrDefault(arr[i], 0) == 0) {
                return false;
            } else {
                map.put(arr[i], --count);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] target = new int[]{1,2,3,4};
        int[] arr = new int[]{2,4,1,3};
        System.out.println(canBeEqual(target, arr));
    }
}
