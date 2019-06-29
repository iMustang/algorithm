package datastructure;

import java.util.LinkedList;
import java.util.List;

/**
 * BinaryTree（二叉树）
 * 下面是将二叉树的顺序存储结构，转换为链表存储（二叉链表）
 * <p>
 * 二叉树：
 * 已知先序遍历序列、中序遍历序列，可以唯一确定一棵二叉树
 * 已知后续遍历序列、中序遍历序列，可以唯一确定一棵二叉树
 * 已知先序遍历序列、后序遍历序列，不能唯一确定一棵二叉树
 */
public class BinaryTree {
	private List<Node> nodeList;

	private static class Node {
		Node leftChild;
		Node rightChild;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	private Node getRoot() {
		return this.nodeList.get(0);
	}

	private void createBinaryTree(int[] array) {
		this.nodeList = new LinkedList<>();
		// 将数组中的元素转换为Node节点
		for (int value : array) {
			nodeList.add(new Node(value));
		}
		// 将节点构造成二叉树，参考二叉树构建过程.png查看2*n+1、2*n+2
		// 设置父节点的左右孩子，最后一个父节点需要单独处理，因为可能没有右孩子
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 设置左孩子
			nodeList.get(parentIndex).leftChild = nodeList.get(2 * parentIndex + 1);
			// 设置右孩子
			nodeList.get(parentIndex).rightChild = nodeList.get(2 * parentIndex + 2);
		}
		// 单独处理最后一个父节点
		int lastParentIndex = array.length / 2 - 1;
		// 设置左孩子
		nodeList.get(lastParentIndex).leftChild = nodeList.get(2 * lastParentIndex + 1);
		// 设置右孩子，如果数组长度为奇数才建立右孩子
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).rightChild = nodeList.get(2 * lastParentIndex + 2);
		}
	}

	/**
	 * 先序遍历（前序遍历），先访问根结点，然后遍历左子树，最后遍历右子树
	 */
	private void preOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
	}

	/**
	 * 中序遍历，先遍历左子树，然后访问根结点，最后遍历右子树
	 */
	private void inOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		inOrderTraverse(node.leftChild);
		System.out.print(node.data + " ");
		inOrderTraverse(node.rightChild);
	}

	/**
	 * 后序遍历，先遍历左子树，然后遍历右子树，最后访问根结点
	 */
	private void postOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		System.out.print(node.data + " ");
	}

	/**
	 * 层序遍历二叉树，使用队列
	 */
	private void sequenceTraverse(BinaryTree binaryTree) {
		LinkedList<Node> queue = new LinkedList<>();
		Node root = binaryTree.getRoot();
		queue.offer(root);
		while (queue.size() != 0) {
			Node node = queue.poll();
			System.out.print(node.data + " ");
			if (node.leftChild != null) {
				queue.offer(node.leftChild);
			}
			if (node.rightChild != null) {
				queue.offer(node.rightChild);
			}
		}

	}

	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree(arr);
		// 获取根节点
		Node root = binaryTree.getRoot();

		System.out.println("先序遍历二叉树：");
		binaryTree.preOrderTraverse(root);
		System.out.println();

		System.out.println("中序遍历二叉树：");
		binaryTree.inOrderTraverse(root);
		System.out.println();

		System.out.println("后序遍历二叉树：");
		binaryTree.postOrderTraverse(root);
		System.out.println();

		System.out.println("层序遍历二叉树：");
		binaryTree.sequenceTraverse(binaryTree);
	}
}
