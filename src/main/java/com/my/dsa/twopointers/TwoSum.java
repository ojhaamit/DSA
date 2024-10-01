package com.my.dsa.twopointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Below is the brute force solution.
     * Here, we are using two pointers (slow and fast) approach to iterate the loop, and
     * see if the sum is matching the target sum or not.
     * The time complexity of the solution is O(n2).
     * The space complexity of the solution is O(1).
     * @param nums
     * @param target
     * @return {i, j} the index of numbers that are adding up to target sum.
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        if (nums.length == 0) {
            // Return an empty array if no solution is found
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        // Return an empty array if no solution is found
        return new int[0];
    }

    /**
     * Below is the hash map solution.
     * Here, we are storing elements into hash table and also checking if the compliment of the solution exists or not.
     * The time complexity of the solution is O(n).
     * The space complexity of the solution is O(n).
     * @param nums
     * @param target
     * @return {i, j} the index of numbers that are adding up to target sum.
     */
    public int[] twoSumHashMap(int[] nums, int target) {
        if (nums.length == 0) {
            // Return an empty array if no solution is found
            return new int[0];
        }

        Map<Integer, Integer> visitedNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (visitedNums.containsKey(complement)) {
                return new int[] {visitedNums.get(complement), i};
            }

            visitedNums.put(nums[i], i);
        }

        // Return an empty array if no solution is found
        return new int[0];
    }
}
