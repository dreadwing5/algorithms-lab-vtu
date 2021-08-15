import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {

    static class Triplet {
        public int x, y, w;

        // Triplet to represent the edge
        public Triplet(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;

        }

    }

    static class Graph {
        ArrayList<Triplet> edgeList;
        int V;

        public Graph(int V) {
            this.V = V;
            edgeList = new ArrayList<Triplet>(V); // Create an edgelist of size V
        }

        void addEdge(int x, int y, int w) {
            Triplet t = new Triplet(x, y, w);
            edgeList.add(t); // add the edge to the edgelist

        }

        public int[] bellman_ford(int src) {
            int[] dist = new int[V];

            Arrays.fill(dist, Integer.MAX_VALUE); // Initialize the distances to infinity

            dist[src] = 0; // Distance of source vertex from itself is 0

            // relax all edges v-1 times
            for (int i = 0; i < V - 1; i++) {
                for (Triplet t : edgeList) {
                    int x = t.x;
                    int y = t.y;
                    int w = t.w;

                    // dist[x]!=Integer.MAX_VALUE -> check for infinity and then check for
                    // relaxation to avoid infinity overflow

                    if (dist[x] != Integer.MAX_VALUE && dist[x] + w < dist[y]) {
                        dist[y] = dist[x] + w; // relax
                    }
                }
            }

            // negative wt cycle
            for (Triplet t : edgeList) {
                int x = t.x;
                int y = t.y;
                int w = t.w;
                if (dist[x] != Integer.MAX_VALUE && dist[x] + w < dist[y]) {
                    System.out.println("Negative weight cycle exists");
                    System.exit(0);
                }

            }
            return dist;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int vertices = scn.nextInt();
        System.out.println("Enter the number of edges");
        int edges = scn.nextInt();
        Graph g = new Graph(vertices);

        System.out.println("Enter the edges (node1,node2, weight) : ");
        for (int i = 0; i < edges; i++) {
            int x = scn.nextInt(), y = scn.nextInt(), w = scn.nextInt();

            g.addEdge(x - 1, y - 1, w); // node1, node2, weight
        }
        System.out.println("Enter source node : ");
        int src = scn.nextInt();
        int[] dist = g.bellman_ford(src - 1);

        System.out.println("The shortest distance of each node from source vertex : ");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Node " + (i + 1) + " is at dist " + dist[i]);
        }
        scn.close();

    }

}
