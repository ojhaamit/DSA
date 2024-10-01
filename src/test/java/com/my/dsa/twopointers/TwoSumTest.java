package test.java.com.my.dsa.twopointers;


import com.my.dsa.twopointers.TwoSum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TwoSumTest {
    private TwoSum twoSum;

    @BeforeEach
    public void setup() {
        twoSum = new TwoSum();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testBruteForceSolution(int[] expectedSolution, int[] nums, int targetSum) {
        int[] solution = twoSum.twoSumBruteForce(nums, targetSum);

        assertArrayEquals(expectedSolution, solution);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testHashMapSolution(int[] expectedSolution, int[] nums, int targetSum) {
        int[] solution = twoSum.twoSumHashMap(nums, targetSum);

        assertArrayEquals(expectedSolution, solution);
    }

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{0, 1}, new int[]{2, 7, 11, 15}, 9),
                Arguments.of(new int[] {1, 2}, new int[] {3, 2, 4}, 6),
                Arguments.of(new int[] {0, 1}, new int[] {3, 3}, 6),
                Arguments.of(new int[0], new int[] {3, 3}, 7),
                Arguments.of(new int[0], new int[] { }, 1)
        );
    }
}