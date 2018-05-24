import java.util.Arrays;

public class RemoveElement {
//    public static int removeElement(int[] nums, int val) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int left = 0, right = nums.length - 1, length = nums.length;
//        int temp;
//        boolean isChange = false;
//        while (left < right) {
//            while (left < right && nums[left] != val)
//                left++;
//            while (left < right && nums[right] == val)
//                right--;
//            if (left < right) {
//                temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//                isChange = true;
//            }
//
//        }
//        System.out.println("" + left);
//        return left;
//
//    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        System.out.println("" + count);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 3, 2, 2, 2};
        removeElement(nums, 3);
        System.out.printf(Arrays.toString(nums));
    }
}
