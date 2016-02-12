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
    ListNode<int> *temp=dList.front();
    dList.push_back(4);
    dList.push_back(32);
    dList.push_front(250);
    dList.push_front(65);
    dList.pop_node(temp);
    vector<int> res=dList.getAllValue();
    for(int i=0;i<res.size();++i)
        printf("%d ",res[i]);
    printf("\n");
    while(dList.getSize()>0){
        printf("%d ",dList.front()->get());
        dList.pop_front();
    }
//    guo_doubleLinkedList::iterator<int> iter=dList.begin();
//    int count=1;
//    while(!iter==dList.end())
//    {
//    printf("iter %d:%d\n",count,*iter);
//        ++iter;
//        ++count;
//    }
}
int main(int argc, const char * argv[]) {
    // insert code here...
    test();
    std::cout << "Hello, World!\n";
    return 0;
}
