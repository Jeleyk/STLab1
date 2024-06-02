package ru.jeleyka.testing.task1;

public class Task1 {
    public static double arctg(double x) {
        return arctg(x, 1_000_000);
    }

    public static double arctg(double x, int mem) {
        if (x == Double.POSITIVE_INFINITY) return Math.PI / 2;
        if (x == Double.NEGATIVE_INFINITY) return -Math.PI / 2;
        double result = 0;
        for (int n = 0; n < mem; n++) {
            double term = Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / (2 * n + 1);
            result += term;
        }
        return result;
    }

}
