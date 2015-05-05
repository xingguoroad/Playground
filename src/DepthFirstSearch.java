
public class DepthFirstSearch {
	private Graph g;
	private boolean[] marked;
	private int count;    // number of vertices connected to s;
	
	
	public DepthFirstSearch(Graph G, int s) {
		this.g = G;
		this.count = 0;
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int s) {
		count++;
		if (!marked[s]) {
			marked[s] = true;
		}
		
		for (int w : G.adj(s)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	public boolean marked(int v) {
		return marked[v];
	}
	
	public int count() {
		return count;
	}
}
