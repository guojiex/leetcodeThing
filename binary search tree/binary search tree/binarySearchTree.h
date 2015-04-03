//
//  binarySearchTree.h
//  binary search tree
//
//  Created by guoskyhero on 15/4/3.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#ifndef __binary_search_tree__binarySearchTree__
#define __binary_search_tree__binarySearchTree__

#include <stdio.h>
#include "binaryTreeNode.h"
template<class T>
class binarySearchTree
{
private:
    int size;
    binarySearchTreeNode<T>* root;
public:
    binarySearchTree()
    {
        size=0;
        root=NULL;
    };
    void push(T val);
    
};

#endif /* defined(__binary_search_tree__binarySearchTree__) */
