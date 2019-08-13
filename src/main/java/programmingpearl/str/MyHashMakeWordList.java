package programmingpearl.str;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

/**
 * MyHashMakeWordList
 * description: 自定义哈希实现，统计文章单词次数
 */
public class MyHashMakeWordList {

	private static final Integer NHASH = 10;

	private static final Integer MULT = 31;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(MakeWordList.class.getResourceAsStream("/makeFileList.txt"));

		Node[] nodes = new Node[NHASH];

		while (scanner.hasNext()) {
			String key = scanner.next();
			int pos = hash(key);
			Node node = nodes[pos];
			while (node != null) {
				if (node.getValue().equals(key)) {
					node.setCount(node.getCount() + 1);
					break;
				}
				node = node.getNext();
			}
			if (node == null) {
				Node original = nodes[pos];
				Node newNode = new Node(key);
				nodes[pos] = newNode;
				newNode.setNext(original);
			}
		}

		// 读取
		for (Node tmp : nodes) {
			while (tmp != null) {
				System.out.println(tmp.getValue() + " : " + tmp.getCount());
				tmp = tmp.getNext();
			}
		}
	}

	static int hash(String input) {
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			sum = sum * MULT + input.charAt(i);
		}
		return sum % NHASH;
	}
}

@Getter
@Setter
class Node {
	private String value;
	private Integer count = 1;
	private Node next;

	public Node(String value) {
		this.value = value;
	}
}