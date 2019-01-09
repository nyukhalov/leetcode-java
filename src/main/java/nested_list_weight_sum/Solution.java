package nested_list_weight_sum;

import java.util.*;

// https://leetcode.com/problems/nested-list-weight-sum/


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return sum(nestedList, 1);
    }

    private int sum(List<NestedInteger> nestedList, int level) {
        if (nestedList == null) return 0;
        int s = 0;
        for(NestedInteger i: nestedList) {
            if (i.isInteger()) {
                s += i.getInteger() * level;
            } else {
                s += sum(i.getList(), level + 1);
            }
        }
        return s;
    }
}
