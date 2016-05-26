package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    Queue<TreeNode> queue=new LinkedList<>();
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        preOrderTree(root);
        TreeNode cur=queue.poll();
        while(!queue.isEmpty()){
            cur.left=null;
            cur.right=queue.peek();
            cur=queue.poll();
        }
        
    }
    private void preOrderTree(TreeNode root){
        if(root==null)
            return;
        queue.add(root);
        if(root.left!=null)
            preOrderTree(root.left);
        if(root.right!=null)
            preOrderTree(root.right);
    }
}
