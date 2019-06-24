package graph;

import java.util.LinkedList;

/**
 * @Title: DFS
 * 深度优先遍历
 * Depth First Search
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653197523&idx=1&sn=4edecca7392534177eef521511ff740b&chksm=8c99e609bbee6f1fdb736f1bc45da5f6b6765ce190db68eac5a65ca22cc2694dc151f8db828f&mpshare=1&scene=23&srcid=0624ZAHG1ernG6Y7ZefYunNZ%23rd
 */
public class DFS {
	/**
	 * 二叉树的先序、中序、后序遍历本质上是深度优先遍历
	 * <p>
	 * 实现深度优先遍历的关键在于回溯
	 * 实现回溯可以利用栈的后入先出，或者递归（递归本质上是基于方法调用栈实现）
	 */

	static void dfs(Graph graph, int start, boolean[] visited) {
		System.out.println(graph.getVertex()[start].getData());
		visited[start] = true;
		for (int index : graph.getAdj()[start]) {
			if (!visited[index]) {
				dfs(graph, index, visited);
			}
		}
	}

	public static void main(String[] args) {

	}

	/**
	 * 图的邻接表形式
	 */
	class Graph {
		private int size;
		private Vertex[] vertex;
		private LinkedList<Integer>[] adj;

		Graph(int size) {
			this.size = size;
			vertex = new Vertex[size];
			adj = new LinkedList[size];
			for (int i = 0; i < size; i++) {
				vertex[i] = new Vertex(i);
				adj[i] = new LinkedList<>();
			}
		}

		public Vertex[] getVertex() {
			return vertex;
		}

		public LinkedList<Integer>[] getAdj() {
			return adj;
		}
	}

	/**
	 * 图的顶点
	 */
	class Vertex {
		private int data;

		Vertex(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}
	}
}
