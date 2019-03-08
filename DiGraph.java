import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DiGraph {
    private int vertices;
    private List<List <Integer>> adj;

    public DiGraph(int vertices) {
        this.vertices = vertices;
        this.adj = new ArrayList<>();
        for (int vertex = 0; vertex < vertices; vertex++)
            this.adj.add(vertex, new LinkedList <>());
    }

    public void addEdge(int v, int w) {
        this.adj.get(v).add(w);
    }

    public Iterable<Integer> adj(int v) {
        return this.adj.get(v);
    }

    public void addVertex() {
        this.adj.add(vertices, new LinkedList <>());
        vertices++;
    }

    public DiGraph reverse() {
        DiGraph reverse = new DiGraph(this.vertices);
        for (int v = 0; v < reverse.getVertices(); v++) {
            for (int w : adj(v))
                reverse.addEdge(w,v);
        }
        return reverse;
    }

    public int getVertices() {
        return this.vertices;
    }
}
