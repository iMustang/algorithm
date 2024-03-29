package topic;

/**
 * AnnulateLinkedList
 * 单向链表，链表中可能出现环，判断链表是否有环
 */
public class AnnulateLinkedList {
	/**
	 * 解法一：遍历链表中的节点，按节点值存放在HashSet中，如果新加入节点时，发现HashSet中存放有相同的节点，说明链表有环
	 * 时间复杂度O(N)，空间复杂度O(N)
	 */

	/**
	 * 解法二：见单向有环链表.png
	 * 如果是环形赛道，跑的快的运动员总是能追上跑的慢的运动员。两个运动员相交说明赛道是环形的。
	 *
	 * 可以建立两个指针A，B，分别指向链表头节点，遍历时，A的步长为1，B的步长为2，在某一个时刻如果A、B指向相同的节点说明链表有环。
	 *
	 * 时间复杂度O(N)，空间复杂度O(1)
	 */

	/**
	 * 引申：
	 * 1. 判断两个单向链表是否相交，如果相交，求出交点。
	 *
	 *
	 * 2. 在一个有环单链表中，找出链表的入环点。
	 */
}
