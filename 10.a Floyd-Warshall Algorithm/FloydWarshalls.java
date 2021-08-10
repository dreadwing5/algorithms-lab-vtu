import java.util.Scanner;

public class FloydWarshalls {

    final static int INF = 10000;

    static int[][] floyd_warshall(int[][] graph) {

        int[][] dist = graph; // copy graph into dist

        int V = graph.length; // get number of vertices in graph

        // Phases, in kth phase we included vertices (1,2,...k) as intermediate vertices
        for (int k = 0; k < V; k++) {
            // Iterate over entire 2D Matrix
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    // if vertex k is included, and can we minimize the dist ?
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }

            }
        }
        return dist;
    }

    public static void main(String[] args) {

        // int[][] graph = { { 0, INF, -2, INF }, { 4, 0, 3, INF }, { INF, INF, 0, 2 },
        // { INF, -1, INF, 0 } }; //Test Data
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int V = scn.nextInt();

        System.out.println("Enter the cost matrix : ");

        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scn.nextInt();
            }
        }

        int[][] result = floyd_warshall(graph);

        System.out.println("\nThe All pair shortest paths matrix is : ");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scn.close();

    }

}
