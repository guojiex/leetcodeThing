package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather
        // than a
        // nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds
        // a
        // single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a
        // nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private Iterator<NestedInteger> _nestedListIterator;
    private Stack<Iterator<NestedInteger>> iteratorStack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this._nestedListIterator = nestedList.iterator();
    }

    @Override
    public Integer next() {
        if (this._nestedListIterator.hasNext()) {
            return this.nextHelper();
        } else {
            while(!this.iteratorStack.isEmpty()){
                this._nestedListIterator=iteratorStack.pop();
            }
        }
    }
    
    @Override
    public boolean hasNext() {
        return this._nestedListIterator.hasNext();
    }
}
