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
    binarySearchTreeNode<T>* left;
    binarySearchTreeNode<T>* right;
    binarySearchTreeNode<T>* parent;
    T value;
public:
    binarySearchTreeNode(T val):value(val){};
    T getValue(){return this->value;};
    void setValue(T val){this->value=val;};
    binarySearchTreeNode<T>* getLeftChild(){return left;};
    binarySearchTreeNode<T>* getRightChild(){return right;};
    binarySearchTreeNode<T>* setLeftChild(binarySearchTreeNode<T>* pointer)
    {
        if(pointer!=nullptr)
            this->left=pointer;
        return this->left;
    };
    binarySearchTreeNode<T>* setRightChild(binarySearchTreeNode<T>* pointer)
    {
        if(pointer!=nullptr)
            this->right=pointer;
        return this->right;
    };
    bool hasLeftChild(){return this->left!=nullptr;};
    bool hasRightChild(){return this->right!=nullptr;};
    
};

#endif
