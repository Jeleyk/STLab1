package ru.jeleyka.testing.task1;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    private static final double EPSILON = 1e-5;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0.78539816339745",
            "-1, -0.78539816339745",
            "0.5, 0.46364760900081",
            "-0.5, -0.46364760900081",
            "0.95, 0.75976275487577",
            "-0.95, -0.75976275487577"
    })
    void testInsideRange(double x, double expected) {
        assertEquals(Task1.arctg(x), expected, EPSILON);
    }

    @RepeatedTest(1000)
    void testArcsinRandomValues() {
        double x = random.nextDouble(-1, 1);
        assertEquals(Task1.arctg(x), Math.atan(x), EPSILON);
    }

    @Test
    void testInfinity() {
        assertEquals(Task1.arctg(Double.POSITIVE_INFINITY), Math.PI / 2, EPSILON);
        assertEquals(Task1.arctg(Double.NEGATIVE_INFINITY), - Math.PI / 2, EPSILON);
    }

}
