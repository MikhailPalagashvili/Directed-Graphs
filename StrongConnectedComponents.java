public class StrongConnectedComponents {
    private boolean[] marked;
    private int[] id;
    private int count;

    public StrongConnectedComponents(DiGraph graph) {
        this.marked = new boolean[graph.getVertices()];
        this.id = new int[graph.getVertices()];
        count = 0;
        TopologicalSort dfs = new TopologicalSort(graph.reverse());
        for (int v : dfs.reversePost()) {
            if (!marked[v]) {
                dfs(graph, v);
                count++;
            }

        }
    }

    private void dfs(DiGraph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)) {
            if (!marked[w])
                dfs(graph, w);
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }
}
