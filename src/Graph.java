import java.io.*;
import java.util.*;

public class Graph {
	private int V;
	private int E;
	private HashMap<Integer, List<Integer>> adj;
	
	// Generate a graph with # of V vertices without any edge
	public Graph(int V) {
		if (V < 0) throw new IllegalArgumentException(
				"Number of vetices must be positive!");
		
		this.V = V;
		this.E = 0;
		adj = new HashMap<Integer, List<Integer>>(V);
	}
	
	
	// Reads the input file and generate a graph
	public Graph(String file) {
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			this.V = Integer.parseInt(bufferedReader.readLine());
			this.E = Integer.parseInt(bufferedReader.readLine());
			this.adj = new HashMap<Integer, List<Integer>>(V);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] vertices = line.split(" ");
				addEdge(new Integer(vertices[0]), new Integer(vertices[1]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addEdge(Integer v, Integer e) {
		List<Integer> t;
		if (adj.get(v) == null || adj.get(v).isEmpty()) {
			t = new ArrayList<Integer>();
			t.add(e);
			adj.put(v,  t);
		} else {
			adj.get(v).add(e);
		}
		
		// Because it's an undirect graph, we need to do same for e
		if (adj.get(e) == null || adj.get(e).isEmpty()) {
			t = new ArrayList<Integer>();
			t.add(v);
			adj.put(e,  t);
		} else {
			adj.get(e).add(v);
		}
	}
	
	public List<Integer> adj(int v) {
		return (adj.get(v) == null) ? new ArrayList<Integer>() : adj.get(v);
	}
	
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		final String NEWLINE = System.getProperty("line.separator");
		s.append(V + "vertices, " + E + "edges " + NEWLINE);
		for (int v = 0; v < V; ++v) {
			s.append(v + ": ");
			for (int w : adj(v)) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}

	
	
}
