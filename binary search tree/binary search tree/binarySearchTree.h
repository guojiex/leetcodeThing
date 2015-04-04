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
    binarySearchTree<T>(T rootVal)
    {
        size=0;
        this->push(rootVal);
    };
    binarySearchTreeNode<T>*  push(const T val)
    {
        if(this->root==nullptr)
        {
            root=new binarySearchTreeNode<T>(val);
            ++size;
            return root;
        }else{
            return this->push(val,root);
        }
    };
    binarySearchTreeNode<T>* push(const T val,binarySearchTreeNode<T>* pointer)
    {
        if(val<pointer->getValue())
        {
            if(pointer->hasLeftChild())
                push(val,pointer->getLeftChild());
            else
            {
                ++size;
                return pointer->setLeftChild(new binarySearchTreeNode<T>(val));
            }
        }else if(val > pointer->getValue())
        {
            if(pointer->hasRightChild())
                push(val,pointer->getRightChild());
            else
            {
                ++size;
                return pointer->setRightChild(new binarySearchTreeNode<T>(val));
            }
        }        
        return nullptr;
    };
    
};

#endif /* defined(__binary_search_tree__binarySearchTree__) */
