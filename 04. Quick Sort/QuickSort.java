import java.util.Random;
import java.util.concurrent.TimeUnit;

class QuickSort {

    public void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    public int partition(int[] A, int l, int h) {

        int pivot = A[h];
        int i = l - 1;
        for (int j = l; j <= h - 1; j++) {
            if (A[j] <= pivot) {

                i = i + 1;
                swap(A, i, j);

            }

        }
        swap(A, i + 1, h);

        return (i + 1);
    }

    public void quickSort(int A[], int l, int h) {
        if (l < h) {
            int q = partition(A, l, h);
            quickSort(A, l, q - 1);
            quickSort(A, q + 1, h);

        }

    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] A = { 10, 7, 8, 9, 1, 5, 6, 7, 8, 9, 18, 3, 10, 11 };
        int a[], n;

        System.out.print("Before Sorting :");
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);

        }
        System.out.println("");
        qs.quickSort(A, 0, A.length - 1);
        System.out.print("\nAfter Sorting : ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
        System.out.println("");

        Random rn = new Random();
        int step = 2000;
        double duration;
        /* times for n = 0, 10, ..., 100, 200, ..., 5000 */
        System.out.println("\n\nN\tRepetitions\tTime(in ns)\n");
        for (n = 5000; n < 50000; n += step) {
            a = new int[n + 1];
            QuickSort qSort = new QuickSort();
            /* get time for size n */
            long repetitions = 0;
            long start = System.nanoTime();
            do {
                repetitions++;
                for (int i = 0; i < n; ++i)
                    a[i] = rn.nextInt(n);
                qSort.quickSort(a, 0, n - 1);
            } while (System.nanoTime() - start < 1000000000);
            /* repeat until enough time has elapsed */
            duration = ((double) (System.nanoTime() - start)) / 1000000000;
            duration /= repetitions;
            System.out.println(n + "\t" + repetitions + "\t\t" + String.format("%.5f", duration) + " ns");
        }

    }
}