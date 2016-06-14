//
//  funcMacro.h
//  cplusplus11test
//
//  Created by guoskyhero on 16/6/2.
//  Copyright © 2016年 guoskyhero. All rights reserved.
//

/**
 *  take the place of #progrma once
 */
_Pragma("once");

/**
 *  A namespace that is used to illustrate the usage of macro __func__
 */
namespace FuncMacro{
    class TestClass{
    private:
        const char* name;
    public:
        TestClass():name(__func__){
            
        }
        const char* getName(){
            return name;
        }
    };
    const char* Hello() {return __func__;}
    const char* World() {return __func__;}
    
    void testFuncMacro(){
        printf("\n*** Start testing __func__ macro ***\n");
        printf("name of function Hello(): %s\n",Hello());
        std::cout << "name of function World(): " << World() << std::endl;
        TestClass* test=new TestClass();
        printf("test of using __func__ as default value for a class variable: %s\n"
               ,test->getName());
        printf("*** End of testing __func__ macro ***\n");
    }
}