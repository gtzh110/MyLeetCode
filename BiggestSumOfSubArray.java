
public class BiggestSumOfSubArray {
    /*
    * 求给定数组的最长子序列及最大和
    * 时间O(n)
    * */
    private static void getSumAndIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.print("error input!");
            return;
        }
        int sum = 0, maxSum = Integer.MIN_VALUE, left = 0, right = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum <= 0) {
                sum = arr[i];
                left = i;
            } else {
                sum += arr[i];
            }
            if (maxSum < sum) {
                maxSum = sum;
                right = i;
            }
        }
        if (left > right) {
            left = right;
        }
        System.out.print("最大子序列的和为：" + maxSum + "，left：" + left + "，right：" + right);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-10, -2, -3, 7, -5, 60};
        getSumAndIndex(arr);
    }


}
