//
//  binarySearchTree.cpp
//  binary search tree
//
//  Created by guoskyhero on 15/4/3.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#include "binarySearchTree.h"
template<class T>
void binarySearchTree<T>::push(T val)
{
  if(this->root==nullptr)
  {
      root=new binarySearchTreeNode<T>(val);
      ++size;
  }else{
      
  }
};
