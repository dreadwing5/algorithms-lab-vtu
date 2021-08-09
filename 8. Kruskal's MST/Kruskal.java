import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Kruskal {

    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int N) {
            parent = new int[N];
            rank = new int[N];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }

        int find(int v) { // find root
            if (parent[v] == -1)
                return v;
            return parent[v] = find(parent[v]); // Path optimization
        }

        // merge two components based on their rank
        void union(int x, int y) {
            int s1 = find(x), s2 = find(y);
            if (s1 != s2) {
                if (rank[s1] < rank[s2]) {
                    parent[s1] = s2;
                    rank[s2] += rank[s1];
                } else {
                    parent[s2] = s1;
                    rank[s1] += rank[s2];
                }
            }
        }
    }

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

        // Main Logic
        int kruskal_mst() {

            Collections.sort(edgeList, (o1, o2) -> {
                return o1.w - o2.w; // sort the edgeList based on weight
            });

            int ans = 0;

            ArrayList<Triplet> mst = new ArrayList<>(); // store the minimum spanning tree

            DSU dsu = new DSU(V); // create a disjoint set of size V

            for (Triplet t : edgeList) {

                int x = dsu.find(t.x); // find the root of x
                int y = dsu.find(t.y); // find the root of y

                // if the roots are different, then add the edge to the MST, i.e they are not
                // forming cycle

                if (x != y) {
                    dsu.union(x, y); // merge the two components
                    ans += t.w; // add the weight of the edge to the ans
                    mst.add(t); // add the edge to the mst
                }

            }

            // print the minimum spanning tree
            System.out.println("\nThe Minimum Spanning tree is : ");
            for (Triplet t : mst) {
                System.out.println("( " + (t.x + 1) + "," + (t.y + 1) + " ) = " + t.w);

            }

            return ans;

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

        System.out.println("\n\nThe minimum cost of spanning tree is " + g.kruskal_mst());
        scn.close();
    }
}
