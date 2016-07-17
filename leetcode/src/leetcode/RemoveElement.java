package leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= 0 && nums[right] == val) {
            right--;
        }
        int length = 0;
        while (right >= 0 && left <= right && left < nums.length) {
            if (nums[left] != val) {
                left++;
                length++;
            } else {
                nums[left] = nums[right--];
                while (right >= 0 && nums[right] == val) {
                    right--;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }
}
