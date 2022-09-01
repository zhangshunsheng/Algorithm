package com.example.demo_practise.algorithm.LCHOT100;

/**
 * ClassName: H_LC004_FindMedianSortedArrays
 * Description:
 * date: 2022/7/29 16:54
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class H_LC004_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int mid = (length1 + length2) >>> 1;
        boolean flag = false;
        boolean cflag = false;
        if ((length1 + length2) % 2 == 0) {
            flag = true;
        } else {
            mid++;
        }
        int res = 0;
        int count = 0;
        int count1 = 0, count2 = 0;
        while (count1 < length1 || count2 < length2) {
            count++;
            int temp = 0;
            if (count1 < length1 && count2 < length2) {
                if (nums1[count1] < nums2[count2]) {
                    temp = nums1[count1];
                    count1++;
                } else {
                    temp = nums2[count2];
                    count2++;
                }
            } else if (count1 < length1) {
                temp = nums1[count1];
                count1++;
            } else {
                temp = nums2[count2];
                count2++;
            }
            if (count == mid) {
                if (flag) {
                    res = temp;
                    flag = false;
                    cflag = true;
                    mid++;
                } else {
                    if (cflag) {
                        double t = res + temp;
                        return t / 2;
                    }
                    return temp;
                }
            }
        }
        return 0.0;
    }
}
