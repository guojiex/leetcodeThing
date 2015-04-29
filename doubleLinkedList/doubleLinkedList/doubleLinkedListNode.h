//
//  ListNode.h
//  doubleLinkedList
//
//  Created by guoskyhero on 15/4/28.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#ifndef doubleLinkedList_ListNode_h
#define doubleLinkedList_ListNode_h
template<class T>
class ListNode
{
private:
    T value;
    ListNode<T>* parent;
    ListNode<T>* next;
public:
    T get()const{return value;}
    T set(const T val){value=val;}
    ListNode(T val):value(val)
    {
        next=nullptr;
        parent=nullptr;
    }
    void Next(ListNode<T>* next)
    {
        this->next=next;
    }
    void Parent(ListNode<T>* par)
    {
        this->parent=par;
    }
    ListNode* Next()const{return next;}
    ListNode* Parent()const {return parent;}
    
};


#endif
