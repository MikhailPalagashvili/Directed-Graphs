import java.util.Stack;

public class TopologicalSort {
    private boolean[] marked;
    private Stack <Integer> reversePostOrder;

    public TopologicalSort(DiGraph graph) {
        this.reversePostOrder = new Stack <>();
        this.marked = new boolean[graph.getVertices()];
        for (int vertex = 0; vertex < graph.getVertices(); vertex++) {
            if (!marked[vertex]) dfs(graph,vertex);
        }

    }

    private void dfs(DiGraph graph, int vertex) {
        this.marked[vertex] = true;
        for (int w : graph.adj(vertex)) if (!marked[w]) dfs(graph,w);
        this.reversePostOrder.push(vertex);

    }

    public TopologicalSort(EdgeWeightedDiGraph graph) {
        this.reversePostOrder = new Stack <>();
        this.marked = new boolean[graph.getVertices()];
        for (int vertex = 0; vertex < graph.getVertices(); vertex++) {
            if (!marked[vertex])
                dfs(graph,vertex);
        }

    }

    private void dfs(EdgeWeightedDiGraph graph, int vertex) {
        this.marked[vertex] = true;
        for (DirectedEdge e : graph.adj(vertex)) if (!marked[e.to()]) dfs(graph,e.to());
        this.reversePostOrder.push(vertex);
    }
    public Iterable<Integer> reversePost() {
        return this.reversePostOrder;
    }

    public static void main(String[] args) {
        final int vertices = 7;
        DiGraph graph = new DiGraph(vertices);
        System.out.println(graph.getVertices());
        System.out.println(graph.getEdges());
        System.out.println("**********");
        graph.addEdge(0,1); graph.addEdge(0,5);
        graph.addEdge(0,2); graph.addEdge(1,4);
        graph.addEdge(3,2); graph.addEdge(3,5);
        graph.addEdge(3,4); graph.addEdge(3,6);
        graph.addEdge(5,2); graph.addEdge(6,0);
        graph.addEdge(6,4);
        TopologicalSort topologicalSort = new TopologicalSort(graph);
        for (int v : topologicalSort.reversePostOrder) System.out.println(v);
    }
}
