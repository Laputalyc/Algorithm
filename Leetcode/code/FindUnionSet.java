package niuke;

import java.util.HashMap;
import java.util.List;

/**
 * 一个并查集结构：对外提供两个功能
 * 	1.判断给定的两个元素是否来自一个集合
 * 	2.合并两个元素所在的集合
 * @author liyuchen
 *
 */
class setNode {
	
}
public class FindUnionSet {
	HashMap<setNode, setNode> map1;
	HashMap<setNode, Integer> map2;
	//设计的这个并查集结构是一个静态的结构，也就是说在初始化的时候必须将所有结点都给出
	public FindUnionSet(List<setNode> nodes) {
		map1 = new HashMap<>();
		map2 = new HashMap<>();
		for (setNode node : nodes) {//链表可以用foreach进行遍历？
			map1.put(node, node);//让每个结点的父结点都指向自己
			map2.put(node, 1);//初始情况下每个结点的所形成的集合个数都为1
		}
	}
	/**
	 * 根据给定的结点找到代表结点，并对连接方式进行优化
	 * @param node 给定的结点
	 * @return 所在集合的代表结点
	 */
	private setNode getRepresentative(setNode node) {
		if(node == null) {
			throw new RuntimeException("该集合为空！");
		}
		setNode representative = node;
		setNode father = map1.get(representative);
		while(father != representative) {//找到该集合的代表结点representative
			node = father;
			father = map1.get(representative);
		}
		
		father = map1.get(node);
		while(node != father) {//再次遍历进行优化
			map1.put(node, representative);//将当前结点指向代表结点
			node = father;
			father = map1.get(node);
		}
		return representative;
	} 
	/**
	 * 判断两个结点时候来自同一集合
	 * @param node1
	 * @param node2
	 */
	public boolean isSameSet(setNode node1, setNode node2) {
		return getRepresentative(node1)==getRepresentative(node2);
	}
	/**
	 * 合并两个结点所在的集合
	 * @param node1
	 * @param node2
	 */
	public void union(setNode node1, setNode node2) {
		setNode head1 = getRepresentative(node1);
		int size1 = map2.get(head1);
		setNode head2 = getRepresentative(node2);
		int size2 = map2.get(head2);
		if(head1 != head2) {
			if(size1 < size2) {//把结点数少的集合放入节点数多的集合里面
				map1.put(head1, head2);
				map2.put(head2, size1+size2);
			} else {
				map1.put(head2, head1);
				map2.put(head1, size1+size2);
			}
		}
	}
}
