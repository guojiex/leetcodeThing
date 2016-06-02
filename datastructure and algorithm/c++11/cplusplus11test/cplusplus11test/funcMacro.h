//
//  funcMacro.h
//  cplusplus11test
//
//  Created by guoskyhero on 16/6/2.
//  Copyright © 2016年 guoskyhero. All rights reserved.
//

#ifndef funcMacro_h
#define funcMacro_h

/**
 *  A namespace that is used to illustrate the usage of macro __func__
 */
namespace FuncMacro{

    const char* Hello() {return __func__;}
    const char* World() {return __func__;}

    void testFuncMacro(){
        std::cout << Hello() << ", " << World() << std::endl;
    }
}
#endif /* funcMacro_h */
