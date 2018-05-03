package maximum_product_of_three_numbers;

// https://leetcode.com/problems/maximum-product-of-three-numbers/description/
class Solution {
    public int maximumProduct(int[] nums) {
        int[] min2 = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] max3 = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i=0; i<nums.length; i++) {
            int n = nums[i];
            updateMin2(min2, n);
            updateMax3(max3, n);
        }

        return Math.max(
                min2[0] * min2[1] * max3[2],
                max3[0] * max3[1] * max3[2]
        );
    }

    private void updateMin2(int[] nums, int n) {
        // insersion sort
        // nums has normal ordering (-3...0)
        int i = 0;
        while(i < nums.length && nums[i] <= n) i++;
        for (int j=i; j<nums.length-1; j++) {
            nums[j+1] = nums[j];
        }
        if (i < nums.length) nums[i] = n;
    }

    private void updateMax3(int[] nums, int n) {
        // insersion sort
        // nums has normal ordering (0...5)
        int i = nums.length - 1;
        while(i >= 0 && nums[i] >= n) i--;
        for (int j=0; j<i; j++) {
            nums[j] = nums[j+1];
        }
        if (i >= 0) nums[i] = n;
    }
}
