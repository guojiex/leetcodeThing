//
//  DelegateConstructor.h
//  cplusplus11test
//
//  Created by guoskyhero on 16/6/4.
//  Copyright © 2016年 guoskyhero. All rights reserved.
//

_Pragma("once");
namespace DelegateConstructor {
    class Person{
    public:
        Person(){}
        Person(int newage) : Person() { this->age=newage; }
        Person(char newgender) : Person() { this->gender=newgender; }
        friend std::ostream& operator << (std::ostream& output,const Person person){
            output << person.age << " " << person.gender << std::endl ;
            return output;
        }
    private:
        int age {25};
        char gender {'F'};
    };
    void test(){
        using namespace std;
        printf("\n*** Start testing DelegateConstructor ***\n");
        Person t1;
        cout << t1;
        Person t2(5);
        cout << t2;
        Person t3('M');
        cout << t3;
        printf("*** End of testing DelegateConstructor ***\n");
    }
}


/* DelegateConstructor_h */
