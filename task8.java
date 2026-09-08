package pst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class task8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter N (number of junctions) and M (number of roads): ");
		if (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			// Nested collections for graph representation (Adjacency List)
			List<List<Integer>> adjList = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				adjList.add(new ArrayList<>());
			}

			System.out.println("Enter the " + m + " connected junction pairs (u v):");
			for (int i = 0; i < m; i++) {
				int u = scanner.nextInt();
				int v = scanner.nextInt();
				// Assuming roads are bidirectional
				adjList.get(u).add(v);
				adjList.get(v).add(u);
			}

			System.out.print("Enter source and destination junctions: ");
			int source = scanner.nextInt();
			int destination = scanner.nextInt();

			// BFS to find if a route exists
			boolean routeExists = false;
			boolean[] visited = new boolean[n + 1];
			Queue<Integer> queue = new LinkedList<>();

			queue.add(source);
			visited[source] = true;

			while (!queue.isEmpty()) {
				int current = queue.poll();

				if (current == destination) {
					routeExists = true;
					break;
				}

				for (int neighbor : adjList.get(current)) {
					if (!visited[neighbor]) {
						visited[neighbor] = true;
						queue.add(neighbor);
					}
				}
			}

			System.out.println("\nRoute Exists:");
			if (routeExists) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

		scanner.close();
	}
}