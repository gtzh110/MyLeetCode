import java.util.Collections;
import java.util.HashMap;

/*
* 数组的度 leetCode-697
* */
public class DegreeOfArray {
    private static void findShortestSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.print("error input!");
            return;
        }
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!left.containsKey(arr[i])) {
                left.put(arr[i], i);
            }
            right.put(arr[i], i);
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        int degree = Collections.max(count.values());
        int minLength = Integer.MAX_VALUE;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count.get(arr[i]) == degree) {
//                System.out.print("left: " + left.get(arr[i]));
//                System.out.print(",right: " + right.get(arr[i]));
                length = right.get(arr[i]) - left.get(arr[i]) + 1;
                if (minLength > length) {
                    minLength = length;
                }
            }
        }
        System.out.print("length: " + minLength);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 1};
        findShortestSubArray(arr);
    }
}
