package datastructure;

/**
 * @title: Tree
 * @description: 树
 */
public class Tree {
	/**
	 * 树的表示方法：双亲表示法、孩子表示法、孩子兄弟表示法
	 *     双亲表示法：  data  parent
	 *     孩子表示法：  data  child1  child2  ... childn
	 *     孩子兄弟表示法：data  firstchild  rightbrother
	 *
	 * 特殊的树：
	 *     二叉树
	 *     多路查找树：每一个结点的孩子数可以多于两个，且每一个结点处可以存储多个元素。2-3树、2-3-4树、B树和B+树。
	 *         2-3树：每一个结点都具有两个孩子（我们称它为2结点）或三个孩子（我们称它为3结点）。
	 *               一个2结点包含一个元素和两个孩子（或没有孩子），且与二叉排序树类似，左子树包含的元素小子该元素，右子树包含的元素大于该元素。不过，与二叉排序树不同的是，这个2结点要么没有孩子，要有就有两个，不能只有一个孩子。
	 *               一个3结点包含一小一大两个元素和三个孩子（或没有孩子），一个3结点要么没有孩子，要么具有3个孩子。如果某个3结点有孩子的话，左子树包含小于较小元素的元素，右子树包含大于较大元素的元素，中间子树包含介于两元素之间的元素。
	 *               2-3树中所有的叶子都在同一层次上。
	 *               见2-3树.png
	 *         2-3-4树：在2-3树基础上加了4结点。一个4结点包含小中大三个元素和四个孩子（或没有孩子），一个4结点要么没有孩子，要么具有 4个孩子。如果某个4结点有孩子的话，左子树包含小于最小元素的元素；第二子树包含大于最小元素，小于第二元素的元素;第三子树包含大于第二元素，小于最大元素的元素；右子树包含大于最大元素的元素。
	 *         B树：是一种多路平衡查找树，2-3树、2-3-4树是B树的特例。
	 *         B+树：是应文件系统所需而出的一种B树的变形树。叶子结点中包含根节点中的元素，并且有指向后续叶子结点的指针。
	 *
	 * 树、森林、二叉树的转化：
	 * 树转化为二叉树：
	 *
	 * 森林转化为二叉树：
	 *
	 * 二叉树转化为树：
	 *
	 * 二叉树转化为森林：
	 *
	 *
	 * 树的遍历：
	 *     先根遍历：
	 *     后根遍历：
	 * 森林的遍历：
	 *     前序遍历：
	 *     后序遍历：
	 */
}
