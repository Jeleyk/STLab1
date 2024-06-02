package ru.jeleyka.testing.task2;

public class Task2 {
    public static void sort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        int N = array.length;

        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(array, N, i);

        for (int i = N - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && array[l] > array[largest])
            largest = l;

        if (r < N && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, N, largest);
        }
    }
}
// 575 127  387 3 3 3 4 6 6
// 0    1    2
