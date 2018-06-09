package product_of_array_except_self;

// https://leetcode.com/problems/product-of-array-except-self/description/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        // calculate left side product
        int p = 1;
        for (int i=0; i<nums.length; i++) {
            output[i] = p;
            p *= nums[i];
        }

        // calculate right side product
        p = 1;
        for (int i=nums.length - 1; i>=0; i--) {
            output[i] *= p;
            p *= nums[i];
        }

        return output;
    }
}
