//
//  main.cpp
//  doubleLinkedList
//
//  Created by guoskyhero on 15/4/28.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#include <iostream>
#include "doubleLinkedList.h"
#include <vector>
using namespace std;
void test()
{
    guo_doubleLinkedList::doubleLinkedList<int> dList;
    dList.push_front(5);
    dList.push_back(4);
    dList.push_back(32);
    dList.push_front(250);
    dList.push_front(65);
    vector<int> res=dList.getAllValue();
    for(int i=0;i<res.size();++i)
        printf("%d ",res[i]);
    printf("\n");
    guo_doubleLinkedList::iterator<int> iter=dList.begin();
    printf("iter 0:%d\n",iter.getValue());
    ++iter;
    printf("iter 1:%d\n",iter.getValue());
}
int main(int argc, const char * argv[]) {
    // insert code here...
    test();
    std::cout << "Hello, World!\n";
    return 0;
}
