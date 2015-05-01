//
//  unionFind.h
//  UnionFind
//
//  Created by guoskyhero on 15/4/29.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#ifndef __UnionFind__unionFind__
#define __UnionFind__unionFind__

#include <stdio.h>
#include <vector>

template <class T>
class unionFind {
    int size;
    int itemLen;
    std::vector<int> index;
    std::vector<T> item;
public:
    unionFind():size(0){}
    void push_item(const T it)
    {
        index.push_back(index.size());
        item.push_back(it);
    }
    int find(const T it)const {
        for(int i=0;i<itemLen;++i)
            if(it==item[i])
               return index[i];
        return -1;
    }
    ///only works for integer type
    void printAllItems_Int()const
    {
        for(int i=0;i<index.size();++i)
            printf("index:%d item:%d\n",index[i],item[i]);
        printf("\n");
    }
    void join(const T left,const T right)
    {
        int leftIndex=find(left);
        int rightIndex=find(right);
        //printf("left %d right %d\n",index[leftIndex],index[rightIndex]);
        if(index[leftIndex]==index[rightIndex])
            return;
        index[rightIndex]=index[leftIndex];
        //printf("left %d right %d\n",index[leftIndex],index[rightIndex]);
    }
};
#endif /* defined(__UnionFind__unionFind__) */
