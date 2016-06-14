//
//  DecltypeTest.h
//  cplusplus11test
//
//  Created by guoskyhero on 16/6/10.
//  Copyright © 2016年 guoskyhero. All rights reserved.
//

_Pragma("once");

namespace DecltypeTest {
    void helpWithUsing(){
        using size_t = decltype(sizeof(0));
        size_t test = 50;
        using namespace std;
        using nullptr_t = decltype(nullptr);
        cout << test << endl;
        /*nullptr_t test2;
        cout << test2 << endl;*/
    }
    void test(){
        DecltypeTest::helpWithUsing();
    }
}




/* DecltypeTest_h */
