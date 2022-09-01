package com.example.demo_practise.algorithm.dynamic_programming;

/**
 * ClassName: LC121_BuyAndSoldStock
 * Description:
 * date: 2022/7/11 13:11
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class LC121_BuyAndSoldStock {
    /**
     * 题目描述：
     *
     * 给定一个整形数组，其中的第i个元素代表股票第i天的价格。在一开始，你手里有足够的钱，但没有股票。
     * 你仅有一次买股票和一次卖股票的机会（每次只能买/卖1股），或者不买不卖。
     * 输出你可能的最大盈利值。尽量降低程序的时间复杂度。
     *
     * 样例1：
     * [7, 1, 5, 3, 6, 4]，在价格为1的时候买入，在价格为6的时候卖出，可以得到最大盈利值为5。（5 = 6 - 1）
     * 样例2：
     * [7, 6, 5, 4, 3, 2]，选择不买不卖，最大盈利值为0。
     */

    public static int resolve(int stockPrice[]) {
        if(stockPrice.length <= 1) {
            return 0;
        }
        int minPrice = stockPrice[0];
        int res = 0;
        for (int i = 0; i < stockPrice.length; i++) {
            if(stockPrice[i] < minPrice) {
                minPrice = stockPrice[i];
            }
            res = Math.max(res, stockPrice[i] - minPrice);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(resolve(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(resolve(new int[]{7, 6, 5, 4, 3, 2}));
    }

}
