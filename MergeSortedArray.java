import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < temp.length; i++) {
            if (index1 < m && index2 < n && nums1[index1] <= nums2[index2]) {
                temp[i] = nums1[index1++];
                continue;
            } else if (index1 < m && index2 < n && nums1[index1] > nums2[index2]) {
                temp[i] = nums2[index2++];
                continue;
            }
            if (index1 == m && index2 < n) {
                temp[i] = nums2[index2];
                index2++;
            }
            if (index2 == n && index1 < m) {
                temp[i] = nums1[index1];
                index1++;
            }
        }
        nums1 = temp;
        System.out.printf(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
}
