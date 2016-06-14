//
//  main.cpp
//  cplusplus11test
//
//  Created by guoskyhero on 16/6/2.
//  Copyright © 2016年 guoskyhero. All rights reserved.
//
#include <iostream>
#include "funcMacro.h"
#include "funcTemplate.h"
#include "DelegateConstructor.h"
#include "DecltypeTest.h"

int main(int argc, const char * argv[]) {
    /**
     *  测试 __func__ 宏定义
     */
    FuncMacro::testFuncMacro();
    FunctionTemplate::test();
    DelegateConstructor::test();
    DecltypeTest::test();
    return 0;
}
