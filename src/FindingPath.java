import java.util.Stack;

public class FindingPath {
	private int[] edgeTo;
	private boolean[] marked;
	private final int s;

	public FindingPath(Graph G, int s) {
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		this.s = s;
		dfs(G, s);
	}

	public void dfs(Graph G, int s) {
		marked[s] = true;
		for (int m : G.adj(s)) {
			if (!marked[m]) {
				edgeTo[m] = s;
				dfs(G, m);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if (marked[v]) {
			Stack<Integer> path = new Stack<Integer>();
			
			for (int i = v; i != s; i = edgeTo[i]) {
				path.push(i);
			}
			path.push(s);
			return path;
		} else {
			return null;
		}
	}
	
}
