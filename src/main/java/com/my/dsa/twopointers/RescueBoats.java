package com.my.dsa.twopointers;

import java.util.Arrays;

public class RescueBoats {

    /**
     * Time complexity: O(nlogn)
     * Space complexity: O(logn)
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }

        // Sort the array to use two pointers
        Arrays.sort(people);
        int left = 0; // Start pointer
        int right = people.length - 1; // End pointer
        int numRescueBoats = 0;

        while (left <= right) {
            // If the lightest and heaviest person can share a boat
            if (people[left] + people[right] <= limit) {
                left++; // Move the lightest pointer up
            }

            // Always move the heaviest pointer down
            right--;
            numRescueBoats++; // A boat is used regardless
        }

        return numRescueBoats;
    }
}
