package niuke;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否是完全二叉树
 * @author liyuchen
 *
 */
public class IsBCT {
	public static void main(String[] args) {
		BiNode head = new BiNode(1);
		head.left = new BiNode(2);
		head.rigth = new BiNode(3);
		head.left.left = new BiNode(4);
		head.left.rigth = new BiNode(5);
		//head.rigth.left = new BiNode(6);
		head.rigth.rigth = new BiNode(7);
		levelTraverse(head);
		System.out.println(isBCT(head));
	}
	public static boolean isBCT(BiNode head) {
		//按照层遍历的方式，首先树中的一个结点如果只有右子树没有左子树，那么一定不是完全二叉树返回false
		if(head == null) {
			return false;
		}
		boolean flag = false;//这里相当于设置了一个哨兵，一旦发现缺子节点的结点就把flag开启为true，表明以后出现的结点都得是叶子结点
		Queue<BiNode> queue = new LinkedList<BiNode>();
		queue.add(head);
		while(!queue.isEmpty()) {
			head = queue.poll();
			if(flag) {//后续结点非叶子结点则返回false
				if(!(head.left==null&&head.rigth==null)) {
					return false;
				}
			}
			//右结点不为null但左结点为null则返回false
			if(head.rigth!=null && head.left==null) {
				return false;
			}
			//出现结点不全的情况则哨兵开启
			if(!(head.left!=null&&head.rigth!=null)){
				flag = true;
			}
			if(head.left!=null) {
				queue.add(head.left);
			}
			if(head.rigth!=null) {
				queue.add(head.rigth);
			}
		}
		return true;
	}
	public static void levelTraverse(BiNode head) {
		//由先序遍历的非递归算法可以得到启发想到用一个队列来作为辅助
		Queue<BiNode> queue = new LinkedList<BiNode>();
		queue.add(head);
		while(!queue.isEmpty()) {
			head = queue.poll();
			System.out.print(head.val+" ");
			if(head.left != null) {
				queue.add(head.left);
			}
			if(head.rigth != null) {
				queue.add(head.rigth);
			}
		}
	}
}
