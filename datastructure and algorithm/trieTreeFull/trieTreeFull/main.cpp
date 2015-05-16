//
//  main.cpp
//  trieTreeFull
//
//  Created by guoskyhero on 15/5/16.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#include <iostream>
#include "trieTree.h"

void test()
{
    trieTree<char>* tree=new trieTree<char>();
    tree->insert("string",6);
    tree->insert("strabc",6);
    tree->drawStorageTree();
}
int main(int argc, const char * argv[]) {
    // insert code here...
    test();
    std::cout << "Hello, World!\n";
    return 0;
}
