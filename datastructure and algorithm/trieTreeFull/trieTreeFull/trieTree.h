//
//  trieTree.h
//  trieTreeFull
//
//  Created by guoskyhero on 15/5/16.
//  Copyright (c) 2015年 guoskyhero. All rights reserved.
//

#ifndef trieTreeFull_trieTree_h
#define trieTreeFull_trieTree_h
#include "trieNode.h"
template<class T>
///字典树，成员变量有根节点地址，词数量记录
class trieTree
{
private:
    trieNode<T>* _Root;
    int wordCount;
    void drawStorageTree(trieNode<T>* node);
public:
    int size() const { return wordCount; }
    trieNode<T>* Root() const { return _Root; }
    void Root(trieNode<T>* val) { _Root = val; }
    trieTree<T>(void);
    ~trieTree<T>(void);
    //void addAWord(T* word,const int size);
    //void addAWord(const T* word,const int &size);
    void insert(const T* word,const int wordSize);    
    void drawStorageTree();
};
//************************************
// Method:    print out every node's value of a tree
// FullName:  dictTree<>::drawStorageTree
// Access:    public
// Returns:   void
//************************************
template<>
void trieTree<char>::drawStorageTree()
{
    drawStorageTree(this->_Root);
}
template<class T>
void trieTree<T>::drawStorageTree(trieNode<T>* node)
{
    printf("%c ",node->getValue());
    if (node->IsEndOfWord())
    {
        printf("\n");
        if(node->getChildrenLength()==0)
            return;
        else
        {
            for(int i=0;i<node->getChildrenLength();++i)
                drawStorageTree(node->childAt(i));
        }
    }else
    {
        for(int i=0;i<node->getChildrenLength();++i)
            drawStorageTree(node->childAt(i));
    }
}



template <class T>
void trieTree<T>::insert(const T* word,const int wordSize) {
    if(wordSize==0)
        return;
    ++this->wordCount;
    trieNode<T>* temp=_Root;
    for(int i=0;i<wordSize;++i)
    {
        temp=temp->addAChild(word[i],i==wordSize-1?true:false);
    }
}

template<class T>
trieTree<T>::trieTree( void )
{
    this->_Root=new trieNode<T>('*',true,false);
    this->wordCount=0;
}
template<class T>
trieTree<T>::~trieTree( void )
{
    _Root->destroy(_Root);
}
#endif
