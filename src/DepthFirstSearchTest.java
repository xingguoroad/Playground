
public class DepthFirstSearchTest {
	public static void main(String[] args) {
		Graph G = new Graph("/home/warren/Playground/tinyCG.txt");
		DepthFirstSearch dfs = new DepthFirstSearch(G, 9);
		for (int v = 0; v < G.V(); ++v) {
			if (dfs.marked(v)) {
				System.out.print(v + " ");
			}
		}
		System.out.println();
		if (dfs.count() == G.V()) {
			System.out.println("connected");
		} else {
			System.out.println("not connected");
		}
	}
}
