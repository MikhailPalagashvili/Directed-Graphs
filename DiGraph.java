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

    public int getEdges() {
        return this.adj.size();
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

    public static void main(String[] args) {
        final int vertices = 13;
        DiGraph graph = new DiGraph(vertices);
        System.out.println(graph.getVertices());
        System.out.println(graph.getEdges());
        graph.addEdge(0,5); graph.addEdge(0,1);
        graph.addEdge(2,0); graph.addEdge(6,0);
        graph.addEdge(5,4); graph.addEdge(3,5);
        graph.addEdge(4,3); graph.addEdge(4,2);
        graph.addEdge(2,3); graph.addEdge(3,2);
        graph.addEdge(11,4); graph.addEdge(6,4);
        graph.addEdge(6,9); graph.addEdge(7,6);
        graph.addEdge(6,8); graph.addEdge(8,6);
        graph.addEdge(7,9); graph.addEdge(9,10);
        graph.addEdge(12,9); graph.addEdge(11,12);
        graph.addEdge(9,11);
        for (int v = 0; v < graph.getVertices(); v++) for (int w : graph.adj(v)) System.out.println(v + " -> " + w);
    }
}
