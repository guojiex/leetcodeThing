//
//  bitmapUnittester.h
//  BITMAP
//
//  Created by guoskyhero on 15/4/24.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#ifndef __BITMAP__bitmapUnittester__
#define __BITMAP__bitmapUnittester__
//#define NDEBUG
#include <stdio.h>
#include "bitmap.h"
#include <string>
#include <assert.h>
class bitmapUnittester
{
private:
    ///the bitmap object
    bitmap test;
    int _left;//=1000000;
    int _right;//=1000012;
    bool testSetAndReset(const int left,const int right)
    {
        assert(left<=right);
        for(int i=left;i<=right;++i)
        {
            if(!test.isNumberIn(i))
            {
                test.set(i);
                //printf("setting number %d\n",i);
                if(!test.isNumberIn(i))
                {
                    printf("fail when setting number:%d\n",i);
                    return false;
                }else
                    printf("success in setting number:%d\n",i);
            }else{
                printf("there has been %d in the bit array?\n",i);
                return false;
            }
        }
        for(int i=left;i<=right;++i)
        {
            if(!test.isNumberIn(i))
            {
                printf("fail:%d should be in bit array but no\n",i);
                return false;
            }else
                printf("successfully add %d into bit array\n",i);
        }

        return true;
    }
    bool testSortedArray()
    {
        printf("start to test sorted array\n");
        int temp[]={10000,234,11,44,45,43,22,78,56,1002};
        int tempsize=10;
        for(int i=0;i<tempsize;++i)
            this->test.set(temp[i]);
        std::vector<int > res=test.sortedArray();
        for(int i=0;i<res.size();++i)
            printf("%d ",res[i]);
        printf("\n");
        return true;
    }
public:
    bitmapUnittester():_left(100000),_right(100012){}
    bool runTest(){
        int success=0;
        int total=0;
        std::string flag="success";
        if(this->testSetAndReset(_left,_right))
        {
            ++success;
            ++total;
        }else{
            ++total;
            flag="fail";
        }
        printf("%s in testing set and reset\n",flag.c_str());
        test.clear();
        if(this->testSortedArray())
        {
            ++total;
            ++success;
        }
        
        printf("success:%d fail:%d total:%d\n",success,total-success,total);
        return total==success?true:false;
    }
    };
#endif /* defined(__BITMAP__bitmapUnittester__) */
