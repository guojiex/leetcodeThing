//
//  main.cpp
//  binary search tree
//
//  Created by guoskyhero on 15/4/3.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#include <iostream>
#include "binarySearchTree.h"
void testBinarySearchTree()
{
    binarySearchTree<int>* tree=new binarySearchTree<int>(15);
    tree->push(25);
    tree->push(10);
    tree->push(2);
    tree->inorderTraversal();
}
int main(int argc, const char * argv[]) {
    // insert code here...
    testBinarySearchTree();
    //std::cout << "Hello, World!\n";
    return 0;
}
