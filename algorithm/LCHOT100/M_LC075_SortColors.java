package com.example.demo_practise.algorithm.LCHOT100;

/**
 * ClassName: M_LC075_SortColors
 * Description:
 * date: 2022/7/29 10:33
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC075_SortColors {
    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 必须在不使用库的sort函数的情况下解决这个问题。
     *
     *  进阶要求
     * 你可以不使用代码库中的排序函数来解决这道题吗？
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     *
     * 示例 1：
     *
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     *
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 快排 （nlogn）
     * @param nums
     */
    public void sortColors(int[] nums) {
        if(nums.length < 2) {
            return;
        }
        fastSort(nums, 0, nums.length - 1);
        System.out.println(nums.toString());
    }
    public void fastSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int temp = nums[start];
        int index = start;
        int right = end;
        while(index < right) {
            if (nums[right] < temp) {
                nums[index] = nums[right];
                index++;
                nums[right] = nums[index];
            } else {
                right--;
            }
        }
        nums[index] = temp;
        fastSort(nums, start, index - 1);
        fastSort(nums, index + 1, end);
    }

    /**
     * 快排加聚簇记录 一次遍历
     * @param nums
     */
    public void sortColors2(int[] nums) {
        if(nums.length < 2) {
            return;
        }
        int temp = nums[0];
        int start = 0, end = 0, right = nums.length - 1;

        while(end < right) {
            switch(nums[right]) {
                case 2:
                    right--;
                    break;
                case 1:
                    swap(nums, ++end, right);
                    break;
                case 0:
                    nums[start] = nums[right];
                    nums[right] = nums[++end];
                    nums[end] = nums[++start];
                    break;
                default:
                    return;
            }
        }
        nums[start] = temp;
        if(temp == 2) {
            swap(nums, start, end);
        }

    }

    /**
     * 一次遍历加区间端点
     * @param nums
     */
    public void sortColors3(int[] nums) {
        if(nums.length < 2) {
            return;
        }
        int zero = 0;
        int two = nums.length;
        int i = zero;
        while (i < two) {
            switch(nums[i]) {
                case 2:
                    two--;
                    swap(nums, i, two);
                    break;
                case 1:
                    i++;
                    break;
                case 0:
                    swap(nums, i, zero);
                    zero++;
                    i++;
                    break;
                default:
                    return;
            }
        }
    }

    public void swap(int nums[], int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new M_LC075_SortColors().sortColors3(nums);
    }

}
