package leetcode;

public class SortedArrayToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0)
            return null;
        return sortArrayToBSTHelper(0,nums.length-1,nums);
    }
    public TreeNode sortArrayToBSTHelper(int start,int end,int[] nums){
        if(start>end)
            return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortArrayToBSTHelper(start,mid-1,nums);
        root.right=sortArrayToBSTHelper(mid+1,end,nums);
        return root;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
