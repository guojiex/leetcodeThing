package amazon;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 | k == 1)
            return nums;
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        
        for (int i = k; i < nums.length; ++i) {
            res[count] = nums[deque.getFirst()];
            count++;
            while(!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            if(!deque.isEmpty()&&deque.peekFirst()<=(i-k)){
                deque.pollFirst();
            }
            deque.addLast(i);
        }
        res[count] = nums[deque.getFirst()];
        count++;
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,3,-1,-3,5,3,6,7};
        int[] print = maxSlidingWindow(input, 3);
        for (int i : print) {
            System.out.print(i + " ");
        }
    }

}
