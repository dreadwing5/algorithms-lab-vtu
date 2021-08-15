public class MatrixChainMultiplication {

    static int MatrixChainOrder(int p[], int n) {
        int c[][] = new int[n][n]; // cost
        int s[][] = new int[n][n]; // parenthesis matrix

        int i, j, k, d, min, q;

        // d is chain length
        for (d = 1; d < n - 1; d++) {

            for (i = 1; i < n - d; i++) {

                j = i + d; // start of subchain
                min = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    // find minimum cost
                    q = c[i][k] + c[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < min) {
                        min = q;
                        s[i][j] = k;
                    }

                }
                c[i][j] = min;

            }

        }
        System.out.println("Optimal Multiplication Order : ");
        MCM(s, 1, n - 1);
        return c[1][n - 1];
    }

    public static void MCM(int[][] s, int i, int j) {
        if (i == j)
            System.out.print("A_" + i + ".");
        else {
            System.out.print("(");
            MCM(s, i, s[i][j]);
            MCM(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = new int[] { 3, 2, 4, 2, 5 }; // dimension array
        int n = arr.length; // number of elements in array

        System.out.println("\nMinimum number of multiplications is " + MatrixChainOrder(arr, n));
    }

}
