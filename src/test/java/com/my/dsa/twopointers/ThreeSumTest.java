package test.java.com.my.dsa.twopointers;

import com.my.dsa.twopointers.ThreeSum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeSumTest {
    private ThreeSum threeSum;

    @BeforeEach
    public void setup() {
        threeSum = new ThreeSum();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testThreeSumBruteForceSolution(List<List<Integer>> expectedSolution, int[] nums) {
        // Measure the latency
        long startTime = System.nanoTime();
        List<List<Integer>> solution = threeSum.threeSumBruteForceApproach(nums);
        long endTime = System.nanoTime();

        // Calculate time taken in milliseconds
        long duration = (endTime - startTime) / 1000000; // converting to milliseconds
        System.out.println("Execution Time: " + duration + " ms");

        assertEquals(expectedSolution, solution);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testThreeSumHashMapSolution(List<List<Integer>> expectedSolution, int[] nums) {
        // Measure the latency
        long startTime = System.nanoTime();
        List<List<Integer>> solution = threeSum.threeSumHashMapApproach(nums);
        long endTime = System.nanoTime();

        // Calculate time taken in milliseconds
        long duration = (endTime - startTime) / 1000000; // converting to milliseconds
        System.out.println("Execution Time: " + duration + " ms");

        assertEquals(expectedSolution, solution);
    }

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2)), new int[] {-1, 0, 1, 2, -1, -4}),
                Arguments.of(Collections.emptyList(), new int[] {0, 1, 1}),
                Arguments.of(Collections.singletonList(Arrays.asList(0, 0, 0)), new int[] {0, 0, 0})
        );
    }
}
