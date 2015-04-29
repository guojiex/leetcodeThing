//
//  doubleLinkedList.h
//  doubleLinkedList
//
//  Created by guoskyhero on 15/4/28.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//
#ifndef doubleLinkedList_doubleLinkedList_h
#define doubleLinkedList_doubleLinkedList_h
#include <vector>
#include "ListNode.h"
namespace guo_data_structure
{
       
    template<class T>
    class doubleLinkedList
    {
    private:
        ListNode<T>* head;
        ListNode<T>* tail;
        int size;
    public:
        doubleLinkedList(){
            head=nullptr;
            tail=nullptr;
            size=0;
        }
        bool empty()const{return size==0;}
        
        std::vector<T> getAllValue()
        {
            std::vector<T> res;
            if(this->empty())
                return res;
            else
            {
                ListNode<T>* iterator=head;
                while(iterator!=nullptr)
                {
                    res.push_back(iterator->get());
                    iterator=iterator->Next();
                }
            }
            return res;
        }
        
        void pop_front()
        {
            if(head)
            {
                ListNode<T>* temp=head;
                head=head->Next();
                delete temp;
                temp=nullptr;
                --size;
            }
        }
        void pop_back()
        {
            if(tail)
            {
                ListNode<T>* temp=tail;
                tail=tail->Parent();
                delete temp;
                temp=nullptr;
                --size;
            }
        }
        ListNode<T>* push_front(const T val)
        {
            ListNode<T>* current=new ListNode<T>(val);
            if(size==0)
            {
                tail=current;
            }else
            {
                current->Next(head);
                head->Parent(current);
            }
            head=current;
            ++size;
            return current;
        }
        ListNode<T>* push_back(const T val)
        {
            ListNode<T>* current;
            if(size==0)
            {
                current=this->push_front(val);
            }else
            {
                current=new ListNode<T>(val);
                tail->Next(current);
                current->Parent(tail);
            }
            tail=current;
            ++size;
            return current;
        }
        ListNode<T>* front()const{return head;}
        ListNode<T>* back()const{return tail;}
        int getSize()const{return size;}
    };
}

#endif
