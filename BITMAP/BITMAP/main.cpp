//
//  main.cpp
//  BITMAP
//
//  Created by guoskyhero on 15/4/24.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#include <iostream>
#include "bitmap.h"
void test()
{
    bitmap test;
    test.autoUnitTest(10000);
    test.autoUnitTest(1000000);
}
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    test();
    return 0;
}
