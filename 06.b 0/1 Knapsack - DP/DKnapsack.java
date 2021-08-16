import java.util.Scanner;

public class DKnapsack {

    int n, m;
    int profit[], weight[], k[][];

    public DKnapsack(int n, int m, int[] profit, int[] weight) {
        this.n = n;
        this.m = m;
        this.profit = profit;
        this.weight = weight;
        this.k = new int[n + 1][m + 1];
    }

    void compute() {
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= m; w++) {

                if (i == 0 || w == 0) {
                    k[i][w] = 0;

                } else if (weight[i] <= w) {
                    // calculate the max profit, if we include the i-th item
                    k[i][w] = Math.max(profit[i] + k[i - 1][w - weight[i]], k[i - 1][w]);
                } else {
                    k[i][w] = k[i - 1][w]; // if we don't include the i-th item
                }

            }

        }
        System.out.println("Optimum Solution : " + k[n][m]);
        traceback();
    }

    // print the object selected
    void traceback() {
        System.out.println("The Objects picked up into knapsack are : ");

        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (k[i][j] != k[i - 1][j]) {
                // Include the i-th item in the result
                System.out.print(i + " ");
                j -= weight[i];
                i--;

            } else
                i--;

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of objects");
        int n = input.nextInt();
        int[] p = new int[n + 1];
        int[] w = new int[n + 1];
        System.out.println("Enter capacity of Knapsack");
        int m = input.nextInt();

        System.out.println("Enter profit for each " + n + " objects");
        for (int i = 1; i <= n; i++)
            p[i] = input.nextInt();

        System.out.println("Enter weight for each " + n + " objects");
        for (int i = 1; i <= n; i++)
            w[i] = input.nextInt();

        DKnapsack dk = new DKnapsack(n, m, p, w);
        dk.compute();
        input.close();

    }
}
