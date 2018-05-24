import java.util.Arrays;

//要求空间复杂度为1，不能借助于新数组了
public class RotateArray {
    /**
     * 数组长度很长时，这种方法超时了
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int temp = 0;
        while (k > 0) {
            temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void rotateAC(int[] nums, int k) {
        k = k % nums.length;
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private static void reverse(int[] nums, int start, int end) {
        int temp;
        for (int i = start, j = end; i < j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateAC(nums, 3);
        System.out.printf(Arrays.toString(nums));
    }


}
