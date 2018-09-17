class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return 0;
    }

    public int E() {
        return 0;
    }

    public void addEdge(int v, int w) {

    }

    public Iterable<Integer> adj(int v) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

public class C411 {

}