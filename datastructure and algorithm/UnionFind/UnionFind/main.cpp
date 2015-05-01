//  并查集算法
//  main.cpp
//  UnionFind
//
//  Created by guoskyhero on 15/4/29.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#include <iostream>
#include "unionFind.h"
void test()
{
    unionFind<int> test;
    test.push_item(15);
    test.push_item(25);
    test.push_item(35);
    test.join(15,25);
    //test.join(25,35);
    test.printAllItems_Int();
    //printf("%d %d %d\n",test.find(15),test.find(25),test.find(35));
}
int main(int argc, const char * argv[]) {
    // insert code here...
    test();
    std::cout << "Hello, World!\n";
    return 0;
}
