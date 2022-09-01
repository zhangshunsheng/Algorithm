package com.example.demo_practise.algorithm.LCHOT100;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName: M_LC031_GetNextArrayArange
 * Description:
 * date: 2022/7/13 17:05
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC031_GetNextArrayArange {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i - 1 >= 0 && nums[i] > nums[i - 1]) {
                swap(nums, i - 1, getIndex(nums, i, nums[i - 1]));
                reverse(nums, i);
                break;
            } else if(i - 1 < 0) {
                reverse(nums, 0);
                break;
            }
        }
        System.out.println(nums);
    }

    public int getIndex(int[] nums, int index, int num) {
        for(int i = index; i < nums.length; i++) {
            if(i + 1 < nums.length && nums[i] > num && nums[i + 1] <= num) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int index) {
        int end = (nums.length - 1 + index) / 2;
        if((nums.length - 1 + index) % 2 != 0) {
            end++;
        }
        for(int i = index; i < end; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 + index - i];
            nums[nums.length - 1 + index - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] temp = {1,3,2};
        new M_LC031_GetNextArrayArange().nextPermutation(temp);
    }
}
