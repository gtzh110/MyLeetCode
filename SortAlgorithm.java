public class SortAlgorithm {
    public static void main(String[] args) {
//        int[] nums = new int[]{10, 8, 4, 5, 1, 2};
        int[] nums = new int[]{1, 1, 3, 4, 50, 6, 7, 2, 10, 66};
//        popSort(nums);
//        chooseSort(nums);
//        insertSort(nums);
//        HeapSort heapSort = new HeapSort(nums);
//        heapSort.heapSort();
        quickSort(0, nums.length - 1, nums);
        for (int num : nums) {
            System.out.printf(num + ",");
        }
    }

    /**
     * 冒泡
     *
     * @param nums
     */
    private static void popSort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isChange = false;//如果某次遍历没有发生交换，证明已经有序，跳出循环
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isChange = true;
                }
            }
            if (!isChange) {
                break;
            }
        }
    }


    /**
     * 选择
     *
     * @param nums
     */
    private static void chooseSort(int[] nums) {
        int temp, index;
        for (int i = 0; i < nums.length - 1; i++) {
            index = chooseMinNum(nums, i);
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    /**
     * 从给定数组中选择一个最小的数
     *
     * @param nums
     * @param start
     * @return
     */
    private static int chooseMinNum(int[] nums, int start) {
        int minIndex = start;
        int minNum = nums[minIndex];
        for (int i = start + 1; i < nums.length; i++) {
            if (minNum > nums[i]) {
                minNum = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    /**
     * 直接插入
     *
     * @param nums
     */
    private static void insertSort(int[] nums) {
        int temp;
        for (int i = 1; i < nums.length; i++) {
            int k = i;
            while (k > 0 && nums[i] < nums[k - 1]) {
                k--;
            }
            temp = nums[i];
            for (int j = i; j > k; j--) {
                nums[j] = nums[j - 1];
            }
            nums[k] = temp;
        }
    }

    //堆排序
    public static class HeapSort {
        int[] nums;//用数组元素表示一颗完全二叉树

        public HeapSort(int[] nums) {
            this.nums = nums;
        }


        private void heapSort() {
            if (nums == null || nums.length == 0) {
                System.out.printf("Error input!");
                return;
            }
            for (int i = nums.length / 2 - 1; i >= 0; i--) {//从最后一个非叶子节点开始遍历
                adjustHeap(nums, i, nums.length);//将给定的完全二叉树初始化为大顶堆
            }
            for (int i = nums.length - 1; i > 0; i--) {
                swap(nums, i, 0);//交换根节点与最后一个节点，最大的元素落到数组尾部，根节点改变后可能会影响大顶堆，所以去除最后的节点，再走一遍调整堆的流程
                adjustHeap(nums, 0, i);
            }

        }

        /**
         * 构建大顶堆
         *
         * @param nums
         * @param index
         */
        private void adjustHeap(int[] nums, int index, int length) {
            for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
                if (i + 1 < length && nums[i] < nums[i + 1]) {//如果左子树比右子树小，则指向右子树，让它与父节点比较
                    i++;
                }
                if (nums[index] < nums[i]) {//如果父节点小于子树，则交换位置，然后index指向那个子树
                    swap(nums, index, i);
                    index = i;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    private static void quickSort(int left, int right, int[] nums) {
        int i = left, j = right, temp, pivot;
        if (i > j) {
            return;
        }
        pivot = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = pivot;
        quickSort(left, i - 1, nums);
        quickSort(i + 1, right, nums);

    }
}
