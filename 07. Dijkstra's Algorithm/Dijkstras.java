import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

@SuppressWarnings("unchecked")
public class Dijkstras {

    static class Pair {
        int node, wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    static class Graph {
        int V;
        ArrayList<Pair>[] adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<Pair>(); // adjacency list
            }

        }

        void addEdge(int u, int v, int wt, boolean undir) {

            adj[u].add(new Pair(v, wt));
            if (undir)
                adj[v].add(new Pair(u, wt)); // Bidirectional

        }

        void dijkstra(int src) {

            int[] dist = new int[V]; // dist[i] = shortest distance from src to i
            Arrays.fill(dist, Integer.MAX_VALUE);

            // Init
            dist[src] = 0;
            SortedSet<Pair> s = new TreeSet<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o2.wt - o1.wt;
                }
            }); // Set of vertices in increasing order of distance from src

            s.add(new Pair(src, 0)); // Add src to the set
            while (!s.isEmpty()) {
                Pair curr = s.first();
                int node = curr.node;
                int distTillNow = curr.wt;

                s.remove(curr); // Remove from set

                // Iterate over the neighbors of the current node
                for (Pair nbrPair : adj[node]) {
                    int nbrNode = nbrPair.node;
                    int nbrWt = nbrPair.wt;
                    if (dist[nbrNode] > distTillNow + nbrWt) {

                        // remove if nbr already exists in the set
                        if (s.contains(nbrPair)) {
                            s.remove(nbrPair);
                        }

                        // update the distance
                        dist[nbrNode] = distTillNow + nbrWt;
                        s.add(new Pair(nbrNode, dist[nbrNode]));
                    }
                }

            }

            // print the distances from src
            System.out.println("\nShortest distance  from " + src + " to all other vertices");
            for (int i = 0; i < V; i++) {
                System.out.println("Node " + i + ": Distance : " + dist[i]);
            }

            // return dist[dst]; // return distance from src to dst

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

            g.addEdge(x, y, w, true); // node1, node2, weight
        }
        System.out.println("Enter the source node");
        int src = scn.nextInt();
        g.dijkstra(src);
        scn.close();
    }
}
