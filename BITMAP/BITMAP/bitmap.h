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
class bitmap
{
private:
    int a[1+N/BITSPERWORD];
public:
    bitmap(){
        printf("bitmap create with an bit array\n");
    }
    void set(const int i)
    {
        int arrayindex=i>>SHIFT;//which 32 bits it belongs to
        int bit_location=i&MASK;//inside that 32 bits, which bit should be set
        a[arrayindex] |= 1<<bit_location;
    }
    void reset(const int i)
    {
        int arrayindex=i>>SHIFT;//which 32 bits it belongs to
        int bit_location=i&MASK;//inside that 32 bits, which bit should be set
        a[arrayindex] &= !1<<bit_location;//reverse the bit and use and operation to make it 0
    }
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
    
};
#endif /* defined(__BITMAP__bitmap__) */
