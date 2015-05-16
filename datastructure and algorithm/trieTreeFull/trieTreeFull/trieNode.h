//
//  trieNode.h
//  trieTreeFull
//
//  Created by guoskyhero on 15/5/16.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#ifndef trieTreeFull_trieNode_h
#define trieTreeFull_trieNode_h
#include <vector>

template <class T>
class trieNode
{
private:
    std::vector<trieNode<T>*> children;
    bool isRoot;
    T ch;
    bool isEndOfWord;
public:
    void destroy(trieNode<T>* node);
    bool IsEndOfWord() const { return isEndOfWord; }
    void IsEndOfWord(bool val) { isEndOfWord = val; }
    bool IsRoot() const { return isRoot; }
    void IsRoot(bool val) { isRoot = val; }
    int getChildrenLength(){return children.size();}
    trieNode<T>* childAt(const int index)const
    {
        return this->children[index];
    }
    T getValue()const{return ch;}
    trieNode<T>(T ch,bool isRoot,bool isEndOfWord)
    :ch(ch),isRoot(isRoot),isEndOfWord(isEndOfWord){
    }
    trieNode<T>* addAChild(T ch,bool isEnd);
    ~trieNode(void);
};

template<class T>
void trieNode<T>::destroy(trieNode<T>* node)
{
    if(node==nullptr)
        return;
    if(!node->children.empty())
    {
        for (int i=0;i<node->getChildrenLength();++i)
        {
            destroy(node->children[i]);
            node->children[i]=nullptr;
        }
    }
    delete node;
}

template <class T>
trieNode<T>* trieNode<T>::addAChild(T ch,bool isEnd) {
    int size=children.size();
    for(int i=0;i<size;++i)
        if(children[i]->getValue()==ch)
            return children[i];
    trieNode<T>* temp=new trieNode<T>(ch,false,isEnd);
    this->children.push_back(temp);
    return temp;
}
template <class T>
trieNode<T>::~trieNode( void )
{
    
}
#endif
