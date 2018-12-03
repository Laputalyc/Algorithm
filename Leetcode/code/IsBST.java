package niuke;

import java.util.Stack;

/**
 * 判断一棵树是否是搜索二叉树
 * @author liyuchen
 *
 */
public class IsBST {
	public static void main(String[] args) {
		//test
		BiNode head = new BiNode(4);
		head.left = new BiNode(2);
		head.rigth = new BiNode(7);
		head.left.left = new BiNode(1);
		head.left.rigth = new BiNode(3);
		head.rigth.left = new BiNode(6);
		head.rigth.rigth = new BiNode(5);
		System.out.println(isBST(head));
		System.out.println(isBST2(head));
	}
	//递归版本的判断是否是搜索二叉树
	public static boolean isBST2(BiNode head) {
		if(head == null) {
			return true;
		}
		boolean left = isBST2(head.left);
		//左子树的头结点要小于当前结点的值
		if(!left) {
			return false;
		}
		boolean right = isBST2(head.rigth);
		if(!right) {
			return false;
		}
		left = head.left==null?true:head.val>head.left.val;
		right = head.rigth==null?true:head.val<getLetfMost(head.rigth).val;
		return left&&right;
	}
	//找打一颗树的最左结点
	public static BiNode getLetfMost(BiNode node) {
		if(node == null) {
			return null;
		}
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	//一棵树采用中序遍历值为升序的二叉树是搜索二叉树
	public static boolean isBST(BiNode head) {
		int compare = Integer.MIN_VALUE;
		//采用非递归方法对一棵树进行中序遍历
		Stack<BiNode> stack = new Stack<BiNode>();
		while(head!=null || !stack.isEmpty()) {
			if(head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				if(head.val <= compare) {
					return false;
				}
				compare = head.val;
				head = head.rigth;
			}
			
		}
		return true;
	}
}
