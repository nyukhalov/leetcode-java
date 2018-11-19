package fruit_into_baskets;

// https://leetcode.com/problems/fruit-into-baskets/
class Solution {
    public int totalFruit(int[] tree) {
        if (tree.length <= 2) return tree.length;
        int maxFruit = 0;
        int curFruit = 2;
        int li = 0;
        int ri = 1;
        for(int i=2; i<tree.length; i++) {
            int t = tree[i];
            int lt = tree[li];
            int rt = tree[ri];
            if (lt == rt || t == lt || t == rt) {
                curFruit++;
                if (lt == rt) {
                    ri = i;
                } else if (lt == t) {
                    li = ri;
                    ri = i;
                }
            } else {
                if (curFruit > maxFruit) maxFruit = curFruit;
                li = ri;
                ri = i;
                curFruit = ri - li + 1;
            }
        }
        if (curFruit > maxFruit) maxFruit = curFruit;
        return maxFruit;
    }
}
