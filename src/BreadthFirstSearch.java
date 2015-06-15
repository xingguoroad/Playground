import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
	private Graph g;
	private boolean[] marked;
	private int count; // number of vertices connected to s;
	private int[] edgeTo;
	private final int s;    // source

	public BreadthFirstSearch(Graph G, int s) {
		this.g = G;
		this.count = 0;
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);
	}

	public void bfs(Graph G, int s) {
		marked[s] = true;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(s);
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;
					queue.add(w);
				}
			}
			
		}
		
	}
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
		path.push(x);
		path.push(s);
		return path;

	}
	
	public static void main(String[] args) {
		Graph G = new Graph("/home/warren/Playground/tinyCG.txt");
		BreadthFirstSearch bfs = new BreadthFirstSearch(G, 0);
		
		for (int j = 0; j < G.V(); j++) {
			if (bfs.pathTo(j) != null) {
				for (int i : bfs.pathTo(j)) {
					System.out.print(i + " - ");
				}
				System.out.println();
			} else {
				
				System.out.println(j + " Not connected to 0!");
			}
		}
	}

}
