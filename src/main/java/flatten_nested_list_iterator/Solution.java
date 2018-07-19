package flatten_nested_list_iterator;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
//https://leetcode.com/problems/flatten-nested-list-iterator/description/
interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
}

public class Solution implements Iterator<Integer> {

    private Stack<Iterator<NestedInteger>> stack = new Stack<>();

    public Solution(List<NestedInteger> nestedList) {
        Iterator<NestedInteger> it = nestedList.iterator();
        if (it.hasNext()) stack.push(it);
    }

    private Integer next = null;

    @Override
    public Integer next() {
        Integer res = next;
        next = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && next == null) {
            Iterator<NestedInteger> it = stack.peek();
            NestedInteger ni = it.next();
            if (!it.hasNext()) stack.pop();
            if (ni.isInteger()) {
                next = ni.getInteger();
            }
            else {
                List<NestedInteger> l = ni.getList();
                Iterator<NestedInteger> iter = l.iterator();
                if (iter.hasNext()) stack.push(iter);
            }
        }

        return next != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
