import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class TwoSum {


    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 10, 20, 60, 80};
        int[] arr2 = new int[]{100, 200, 10, 20, 60, 80};
//        twoSumSortedArr(arr, 3);
//        twoSum(arr2, 300);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode5.right = treeNode6;
        findTarget(treeNode1, 6);

    }

    /*
    * 有序数组中的两个数和等于给定的数,求下标
    * */
    public static int[] twoSumSortedArr(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int left = 0, right = numbers.length - 1;
        int[] arr = null;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                arr = new int[2];
                arr[0] = left + 1;
                arr[1] = right + 1;
                System.out.print("array:" + arr[0] + "," + arr[1]);
                break;
            }
        }
        return arr;
    }

    /*
    * 无序数组中的两个数和等于给定的数,求下标
    * 借助于 HashMap
    * */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(target - numbers[0], 0);
        for (int i = 1; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                System.out.print("array:" + map.get(numbers[i]) + "," + i);
                return new int[]{map.get(numbers[i]), i};
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return null;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    * 给定一个二叉搜索树和一个数，判断是否有两个节点的和等于这个数
    * */
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                arrayList.add(p.val);
                p = p.right;
            }
        }
        int left = 0, right = arrayList.size() - 1;
        boolean result = false;
        while (left < right) {
            if (arrayList.get(left) + arrayList.get(right) > k) {
                right--;
            } else if (arrayList.get(left) + arrayList.get(right) < k) {
                left++;
            } else {
                result = true;
                break;
            }
        }
        System.out.print("result：" + result);
        return result;
    }


}
