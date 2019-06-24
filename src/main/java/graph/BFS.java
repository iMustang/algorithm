package graph;

import java.util.LinkedList;

/**
 * @Title: BFS
 * 广度优先遍历
 * Breadth First Search
 */
public class BFS {
	/**
	 * 二叉树的层序遍历本质上是广度优先遍历
	 * <p>
	 * 实现广度优先遍历的关键在于重放
	 * 实现重放可以利用队列的先入先出
	 */
	static void bfs(Graph graph, int start, boolean[] visited, LinkedList<Integer> queue) {
		queue.offer(start);
		while (!queue.isEmpty()) {
			int front = queue.poll();
			if (visited[front]) {
				continue;
			}
			System.out.println(graph.vertex[front].getData());
			visited[front] = true;
			for (int index : graph.getAdj()[front]) {
				queue.offer(index);
			}
		}
	}

	/**
	 * 图的结构见BFS、DFS示例中用的图.png
	 */
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.adj[0].add(1);
		graph.adj[0].add(2);
		graph.adj[0].add(3);

		graph.adj[1].add(0);
		graph.adj[1].add(3);
		graph.adj[1].add(4);

		graph.adj[2].add(0);

		graph.adj[3].add(0);
		graph.adj[3].add(1);
		graph.adj[3].add(4);
		graph.adj[3].add(5);

		graph.adj[4].add(1);
		graph.adj[4].add(3);
		graph.adj[4].add(5);

		graph.adj[5].add(3);
		graph.adj[5].add(4);

		System.out.println("图的广度优先遍历：");
		bfs(graph, 0, new boolean[graph.size], new LinkedList<>());
	}

	/**
	 * 图的邻接表形式
	 */
	static class Graph {
		private int size;
		private DFS.Vertex[] vertex;
		private LinkedList<Integer>[] adj;

		Graph(int size) {
			this.size = size;
			vertex = new DFS.Vertex[size];
			adj = new LinkedList[size];
			for (int i = 0; i < size; i++) {
				vertex[i] = new DFS.Vertex(i);
				adj[i] = new LinkedList<>();
			}
		}

		public DFS.Vertex[] getVertex() {
			return vertex;
		}

		public LinkedList<Integer>[] getAdj() {
			return adj;
		}
	}

	/**
	 * 图的顶点
	 */
	static class Vertex {
		private int data;

		Vertex(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}
	}
}
