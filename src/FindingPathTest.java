public class FindingPathTest {
	public static void main(String[] args) {
		Graph G = new Graph("/home/warren/Playground/tinyCG.txt");
		System.out.println(G.toString());

		FindingPath fp = new FindingPath(G, 0);

		for (int j = 0; j < G.V(); j++) {
			System.out.println("From 0" + " -- " + j);
			System.out.print("\t");
			if (fp.pathTo(j) != null) {
				for (int i : fp.pathTo(j)) {
					System.out.print(i + " ");
				}
				System.out.println();
			} else {
				System.out.println("Not connected!");
			}
		}
	}
}
