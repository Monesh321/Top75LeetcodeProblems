package org.example;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {


    public static int maxProfitold(int[] prices) {
        int profit = 0;
        int maxprofit = 0;
        int i = 0;
        int j = 1;
        while (i < prices.length) {
            if (j < prices.length) {

                profit = prices[j] - prices[i];

                if (profit > maxprofit) {
                    maxprofit = profit;
                }
                j++;
            }else {
                i++;
                j=i+1;
            }
        }
        return maxprofit;
    }

    public static int maxProfit(int[] prices) {

        int buyinprice = Integer.MAX_VALUE;
        int maxprofit=Integer.MIN_VALUE;

        for (int price:prices) {
            if (price<buyinprice){
                buyinprice=price;
            }
            int profit=price-buyinprice;
            if (profit>maxprofit){
                maxprofit=profit;
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int maximumProfit = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        int[] arr=new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println(maximumProfit);
    }
}
