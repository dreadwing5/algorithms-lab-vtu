import java.util.Random;

class MergeSort {
    // Merges two subarrays of arr[].
    // First subarrays is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = { 5, 4, 3, 2, 1, 0 };
        int a[], n;

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);

        Random rn = new Random();
        int step = 2000;
        double duration;
        /* times for n = 0, 10, ..., 100, 200, ..., 5000 */
        System.out.println("\n\nN\tRepetitions\tTime(in ns)\n");
        for (n = 5000; n < 50000; n += step) {
            a = new int[n + 1];
            MergeSort mSort = new MergeSort();
            /* get time for size n */
            long repetitions = 0;
            long start = System.nanoTime();
            do {
                repetitions++;
                for (int i = 0; i < n; ++i)
                    a[i] = rn.nextInt(n);
                mSort.mergeSort(a, 0, n - 1);
            } while (System.nanoTime() - start < 1000000000);
            duration = ((double) (System.nanoTime() - start)) / 1000000000;
            duration /= repetitions;
            System.out.println(n + "\t" + repetitions + "\t\t" + String.format("%.5f", duration) + " ns");
        }
    }
}
