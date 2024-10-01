package com.my.dsa.twopointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    /**
     * Check in nums array using three pointer approach if the sum of any 3 elements is zero or not.
     * The time complexity of the solution is O(n3).
     * The space complexity of the solution is O(n).
     * @param nums
     * @return list of all three numbers that adds up to zero.
     */
    public List<List<Integer>> threeSumBruteForceApproach(int[] nums) {
        if (nums.length <= 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(Integer::compareTo);
                        if (!uniqueTriplets.contains(triplet)) {
                            uniqueTriplets.add(triplet);
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Check in nums array using two pointer approach if the sum of any 3 elements is zero or not.
     * The time complexity of the solution is O(n2).
     * The space complexity of the solution is O(n).
     * @param nums
     * @return list of all three numbers that adds up to zero.
     */
    public List<List<Integer>> threeSumHashMapApproach(int[] nums) {
        // To handle empty or very small arrays
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        // Sort the array to use a two-pointer approach
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Use HashMap to find the pairs
            Map<Integer, Integer> visitedNums = new HashMap<>();

            for (int j = i+1; j < nums.length; j++) {
                int complement = -nums[i] - nums[j];
                if (visitedNums.containsKey(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    triplet.sort(Integer::compareTo);
                    result.add(triplet);

                    // Skip duplicates for the second and third numbers
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
                // Mark the number as visited
                visitedNums.put(nums[j], j);
            }
        }
        return result;
    }
}
