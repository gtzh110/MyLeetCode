public class ContainerWithMostWater {

    private static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(Math.min(height[left], height[right]) * (right - left), maxArea);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.print(maxArea);
        return maxArea;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 4, 10, 8};
        maxArea(arr);
    }
}
