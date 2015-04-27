##Problem
Binary Tree Preorder Traversal Total Accepted: 62712 Total Submissions: 173169 My Submissions Question Solution 
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
##solution

	//
 	 Definition for binary tree
 	 struct TreeNode {
 	     int val;
 	     TreeNode *left;
 	     TreeNode *right;
 	     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 	 };
 	///
	class Solution {
	public:
    void preorderTraversal(TreeNode* node,vector<int> &res)
    {
        
         if(node)
            res.push_back(node->val);
        else
            return;
        if(node->left)
            preorderTraversal(node->left,res);
       
        if(node->right)
            preorderTraversal(node->right,res);
    }
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> result;
        if(root==NULL)
            return result;
        else
            preorderTraversal(root,result);
        return result;
    }
	};
