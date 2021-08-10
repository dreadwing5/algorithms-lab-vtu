import java.util.*;

@SuppressWarnings("unchecked")

public class Prims {

    // Triplet to store the minimum spanning tree

    static class Triplet {
        public int node1, node2, weight;

        public Triplet(int n1, int n2, int w) {
            node1 = n1;
            node2 = n2;
            weight = w;

        }

    }

    static class Graph {
        ArrayList<Triplet>[] list; // list of vertices
        int vertices;

        public Graph(int vertices) {
            this.vertices = vertices;
            list = new ArrayList[vertices];

            for (int i = 0; i < list.length; i++) {

                list[i] = new ArrayList<Triplet>(); // create a list for each vertex
            }
        }

        void addEdge(int node1, int node2, int weight) {
            list[node1].add(new Triplet(node1, node2, weight));
            list[node2].add(new Triplet(node2, node1, weight));
        }

        int prim_mst() {

            Queue<Triplet> Q = new PriorityQueue<>(new Comparator<Triplet>() {
                @Override
                public int compare(Triplet o1, Triplet o2) {
                    return o1.weight - o2.weight;
                }

            });

            boolean[] vis = new boolean[vertices];
            int ans = 0;
            ArrayList<Triplet> mst = new ArrayList<>(); // store the minimum spanning tree

            int flag = 0; // flag to avoid printing the 0,0,0 edge

            // begin
            Q.add(new Triplet(0, 0, 0)); // node1, node2, weight

            while (!Q.isEmpty()) {
                // pick out the edge with min weight
                Triplet best = Q.poll();

                int to = best.node2;
                int weight = best.weight;

                if (vis[to]) {
                    // discard the edge, and continue
                    continue;
                }

                // otherwise take the current edge
                ans += weight;
                vis[to] = true;

                if (flag == 1)
                    mst.add(best);

                // add the new edges in the queue
                for (Triplet x : list[to]) {
                    if (!vis[x.node2]) {
                        Q.add(new Triplet(x.node1, x.node2, x.weight));
                    }
                    flag = 1;
                }

            }

            // print the minimum spanning tree
            System.out.println("\nThe Minimum Spanning tree is : ");
            for (Triplet triplet : mst) {
                System.out.println("( " + (triplet.node1 + 1) + "," + (triplet.node2 + 1) + " ) = " + triplet.weight);

            }

            // return the total weight of the MST

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

        System.out.println("\n\nThe minimum cost of spanning tree is " + g.prim_mst());
        scn.close();

    }
}