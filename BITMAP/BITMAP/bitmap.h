//
//  bitmap.h
//  BITMAP
//
//  Created by guoskyhero on 15/4/24.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#ifndef __BITMAP__bitmap__
#define __BITMAP__bitmap__
#define N 10000000
//SHIFT ==5 means that 32 bits is 2^5,so right shift 5 times equals to /32
#define SHIFT 5
#define BITSPERWORD 32
#define MASK 0x1f
#include <stdio.h>
#include <vector>
class bitmap
{
private:
    int a[1+N/BITSPERWORD];
    int size;
public:
    bitmap(){
        printf("bitmap create with an bit array\n");
        size=0;
    }
    void set(const int i)
    {
        int arrayindex=i>>SHIFT;//which 32 bits it belongs to
        if(size<arrayindex)
            size=arrayindex+1;
        int bit_location=i&MASK;//inside that 32 bits, which bit should be set
        a[arrayindex] |= 1<<bit_location;
    }
    void reset(const int i)
    {
        int arrayindex=i>>SHIFT;//which 32 bits it belongs to
        //TODO: add a refresh size function here
        int bit_location=i&MASK;//inside that 32 bits, which bit should be set
        a[arrayindex] &= !1<<bit_location;//reverse the bit and use and operation to make it 0
    }
    int getMaxSize(){return 1+N/BITSPERWORD;}
    bool isNumberIn(const int i)
    {
        int arrayindex=i>>SHIFT;//which 32 bits it belongs to
        int bit_location=i&MASK;//inside that 32 bits, which bit should be set
        //a[arrayindex] &= !1<<bit_location;//reverse the bit and use and operation to make it 0
        return a[arrayindex]>>bit_location&1;
    }
    void autoUnitTest(const int i)
    {
        this->set(i);
        printf("number %d is in:%d\n",i,this->isNumberIn(i)==true?1:0);
        this->reset(i);
        printf("number %d is in:%d\n",i,this->isNumberIn(i)==true?1:0);
    }
    void testSortedArray(int *array,int sizeArray)
    {
        for(int i=0;i<sizeArray;++i)
            this->set(array[i]);
        std::vector<int> test=this->sortedArray();
        for(int i=0;i<test.size();++i)
            printf("%d ",test[i]);
        printf("\n");
    }
    ///clear all the array
    void clear()
    {
        memset(&a, 0, sizeof(int)*(1+N/BITSPERWORD));
    }
    std::vector<int> sortedArray()
    {
        std::vector<int> res;
        int temp=0;
        for(int i=0;i<size;++i)
        {
            if(a[i]!=0)
            {
                for(int j=0;j<32;++j)
                {
                    temp=i*32+j;
                    if(this->isNumberIn(temp))
                        res.push_back(temp);
                }
            }
        }
        return res;
    }
    
};
#endif /* defined(__BITMAP__bitmap__) */
