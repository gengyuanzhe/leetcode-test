package learning.leetcode;

public class Q1144MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }

        int countOdd = 0;
        int countEven = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                
                countEven += Math.max(0, nums[i] - getMinNeighbor(nums, i) + 1);
            } else {
                countOdd += Math.max(0, nums[i] - getMinNeighbor(nums, i) + 1);
            }
        }
        return Math.min(countEven, countOdd);
    }

    int getMinNeighbor(int[] nums, int i) {
        if (i == 0) {
            return nums[i + 1];
        } else if (i == nums.length - 1) {
            return nums[i - 1];
        } else {
            return Math.min(nums[i - 1], nums[i + 1]);
        }
    }
}