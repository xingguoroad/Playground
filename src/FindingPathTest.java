public class FindingPathTest {
	public static void main(String[] args) {
		Graph G = new Graph("/home/warren/Playground/tinyCG.txt");
		System.out.println(G.toString());

		
		FindingPath fp = new FindingPath(G, 9);

		for (int j = 0; j < G.V(); j++) {
			if (fp.pathTo(j) != null) {
				for (int i : fp.pathTo(j)) {
					if (i == 9) System.out.print("- 9");
					else System.out.print(" - " + i);
				}
				System.out.println();
			} else {
				
				System.out.println("Not connected!");
			}
		}
	}
}
