package ru.jeleyka.testing.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Task2Test {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    @ParameterizedTest
    @MethodSource("randomArrays")
    void testHeapSort(int[] array) {
        testArray(array);
    }

    @Test
    void testNull() {
        assertThrows(NullPointerException.class, () -> Task2.sort(null));
    }

    @Test
    void testEdgeCases() {
        testArray(new int[] {1, 2, 3, 4, 5, 6});
        testArray(new int[] {0, 0, 0, 0, 0, 0});
        testArray(new int[] {0, 0, 1, 0, 0, 0});
        testArray(new int[] {1, 0, 0, 0, 0, 0});
        testArray(new int[] {0, 0, 0, 0, 0, 1});
        testArray(new int[0]);
    }

    private static void testArray(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);

        Task2.sort(array);
        Arrays.sort(arrayCopy);

        assertArrayEquals(array, arrayCopy);
    }

    private static Stream<int[]> randomArrays() {
        Stream.Builder<int[]> builder = Stream.builder();

        for (int i = 0; i < 100; i++) {
            builder.add(random.ints().limit(random.nextInt(20)).toArray());
        }

        return builder.build();
    };
}
