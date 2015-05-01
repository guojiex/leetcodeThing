//
//  kmp.cpp
//  kmp
//
//  Created by guoskyhero on 15/4/25.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#include "kmp.h"
using namespace std;
vector<int> kmp::getNextArray(const string str)
{
    vector<int> next;
    next.resize(str.length());
    next[0]=next[1]=0;
    int j=0;
    //i is the index in str
    for(int i=0;i<str.length();++i)
    {
        while (j>0&&str[i]!=str[j]) {
            //use str[i] as the substring head
            //j is the next same substring head that has equal char in head
            j=next[j];
        }
        if (str[i]==str[j]) {
            ++j;
        }
        next[i+1]=j;
    }
    return next;
};