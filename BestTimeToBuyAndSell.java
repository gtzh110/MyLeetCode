/*
* LeetCode-121. Best Time to Buy and Sell Stock
* */
public class BestTimeToBuyAndSell {
    private static void getMaxProfit(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.print("error input!");
            return;
        }
        int minBuyPrice = arr[0], maxProfit = 0, buyDay = 0, sellDay = 1;
        for (int i = 1; i < arr.length; i++) {
            if (maxProfit < arr[i] - minBuyPrice) {
                maxProfit = arr[i] - minBuyPrice;
                sellDay = i;
            }
            if (arr[i] < minBuyPrice) {
                minBuyPrice = arr[i];
                buyDay = i;
            }
        }
        if (maxProfit == 0) {
            System.out.print("无最大利润");
            return;
        }
        System.out.print("最大利润为：" + maxProfit + "，买入日期：" + buyDay + "，卖出日期：" + sellDay);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 2};
        getMaxProfit(arr);
    }
}
