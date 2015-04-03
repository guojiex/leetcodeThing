//
//  binaryTreeNode.h
//  binary search tree
//
//  Created by guoskyhero on 15/4/3.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#ifndef binary_search_tree_binaryTreeNode_h
#define binary_search_tree_binaryTreeNode_h
template<class T>
class binarySearchTreeNode
{
private:
    binarySearchTreeNode* left;
    binarySearchTreeNode* right;
    T value;
public:
    binarySearchTreeNode(T val):value(val){};
};

#endif
