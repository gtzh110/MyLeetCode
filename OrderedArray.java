/*
* 给定一个数组和一个下标值，从0到下标和从下标+1到数组尾部的两部分分别有序，使数组整体有序
* 1.空间复杂度为O(n)
* 2.空间复杂度为O(1)
* */
public class OrderedArray {
    static int[] arr = {1, 5, 7, 10, 20, 40, 60, 80, 100};

    public static void main(String[] args) {
//        sortSpaceN(arr, 3);
        sortSpace1(arr, 3);

    }

    //空间复杂度为O(n)，时间复杂度为O(n)
    private static void sortSpaceN(int[] arr, int index) {
        int[] result = new int[arr.length];
        int formerIndex = 0, latterIndex = index + 1;
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (formerIndex > index) {
                result[i] = arr[latterIndex++];
            } else if (latterIndex > arr.length - 1) {
                result[i] = arr[formerIndex++];
            } else {
                if (arr[formerIndex] <= arr[latterIndex]) {
                    result[i] = arr[formerIndex];
                    formerIndex++;
                } else {
                    result[i] = arr[latterIndex];
                    latterIndex++;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    //空间复杂度为O(1)，插入排序
    private static void sortSpace1(int[] arr, int index) {

        int temp;
        for (int i = index + 1; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] <= arr[pre]) {
                pre--;
            }
            temp = arr[i];
            for (int j = i; j > pre + 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[pre + 1] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }


}
