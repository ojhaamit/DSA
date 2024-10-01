package test.java.com.my.dsa.twopointers;

import com.my.dsa.twopointers.RescueBoats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RescueBoatsTest {
    private RescueBoats rescueBoats;

    @BeforeEach
    public void setup() {
        rescueBoats = new RescueBoats();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testRescueBoatsGreedySolution(int expectedSolution, int[] people, int limit) {
        // Measure the latency
        long startTime = System.nanoTime();
        int solution = rescueBoats.numRescueBoats(people, limit);
        long endTime = System.nanoTime();

        // Calculate time taken in milliseconds
        long duration = (endTime - startTime) / 1000000; // converting to milliseconds
        System.out.println("Execution Time: " + duration + " ms");

        assertEquals(expectedSolution, solution);
    }

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(1, new int[] {1, 2}, 3),
                Arguments.of(3, new int[] {3, 2, 2, 1}, 3),
                Arguments.of(4, new int[] {3, 5, 3, 4}, 5)
        );
    }
}
