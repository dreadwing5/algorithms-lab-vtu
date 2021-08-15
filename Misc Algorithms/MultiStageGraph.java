class MultiStageGraph {

    public static void main(String[] args) {

        // Create a graph
        int stages = 4;
        int n = 8;
        int[] cost = new int[9];
        int[] d = new int[9];
        int[] path = new int[5];

        // Initialize the adjacency matrix
        int[][] c = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 2, 1, 3, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 2, 3, 0, 0 },
                { 0, 0, 0, 0, 0, 6, 7, 0, 0 }, { 0, 0, 0, 0, 0, 6, 8, 9, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 6 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 4 }, { 0, 0, 0, 0, 0, 0, 0, 0, 5 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

        cost[n] = 0;

        // Iterate through all the vertices

        for (int i = n - 1; i >= 1; i--) {
            int min = Integer.MAX_VALUE;
            for (int k = i + 1; k <= n; k++) {
                // if an edge exists from i to k then check if it is the minimum
                if (c[i][k] != 0 && c[i][k] + cost[k] < min) {
                    min = c[i][k] + cost[k];
                    d[i] = k; // minimum path

                }

            }
            cost[i] = min;
        }

        // Fill the path array
        path[1] = 1; // source vertex
        path[stages] = n; // destination vertex
        for (int i = 2; i < stages; i++) {
            path[i] = d[path[i - 1]];

        }

        // Print the path
        System.out.println("The Shortest Path from 1 to 8 is :  ");
        for (int i = 1; i <= stages; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();

    }
}
