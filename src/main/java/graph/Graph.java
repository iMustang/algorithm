package graph;

/**
 * 图
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653197523&idx=2&sn=893c01a31446d3c479c312836ae83819&chksm=8c99e609bbee6f1fb0df2fb60edb8fba5166b49ef200ab8fb3af4ff144b3f96b283a34ff776c&mpshare=1&scene=23&srcid=0623XzbD603Fppiwiv95HHGc%23rd
 */
public class Graph {
	/**
	 * 图的存储方式：
	 * 1. 邻接矩阵
	 * 	表达图中顶点的关联关系，矩阵左上到右下的对角线元素都为0
	 * 	无向图的矩阵是对称矩阵
	 * 	缺点：浪费空间，如果图中有1000个顶点，只有少量顶点间有关联关系（稀松图），需要建立1000*1000的矩阵
	 * 2. 邻接表、逆邻接表，类似于哈希表。邻接表的链表中存储该顶点能一步到达的顶点，逆邻接表的链表中存储能一步到达该顶点的顶点。
	 * 3. 十字链表，结合邻接表、逆邻接表
	 * 4. 邻接多重表
	 */
}
