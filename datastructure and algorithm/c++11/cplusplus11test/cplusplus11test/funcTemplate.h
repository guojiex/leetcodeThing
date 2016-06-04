//
//  funcTemplate.h
//  cplusplus11test
//
//  Created by guoskyhero on 16/6/4.
//  Copyright © 2016年 guoskyhero. All rights reserved.
//

_Pragma("once");

namespace FunctionTemplate {
    template<typename T> void printObject(T t){
        std::cout << t << std::endl;
    }
    /**
     *  A function to test the default template of function
     *
     *  @param t an object that we can print,default value is 0.5
     *
     *  @return void
     */
    template<typename T = double> void defaultPrintObject(T t = 0.5){
        std::cout << t << std::endl;
    }
    
    void test(){
        printf("\n*** Start testing function template ***\n");
        printObject(1.5);
        printObject("1.7");
        defaultPrintObject();
        defaultPrintObject(1);
        printf("*** End of testing function template ***\n");
    }
}




/* funcTemplate_h */
