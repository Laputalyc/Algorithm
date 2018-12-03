package niuke;
/**
 * 判断一棵树是否是平衡二叉树
 * @author liyuchen
 *
 */

class TreeBean {
	boolean isB;//作为递归的返回isB代表是否是一颗平衡二叉树
	int  length;//length代表该平衡二叉树的高度
	public TreeBean(boolean isB, int length) {
		this.isB = isB;
		this.length = length;
	}
	public TreeBean(boolean isB) {
		this.isB = isB;
	}
}
public class IsBalanceTree {
	public static void main(String[] args) {
		//test
		BiNode head = new BiNode(1);
		head.left = new BiNode(2);
		//head.rigth = new BiNode(3);
		head.left.rigth = new BiNode(4);
		//head.rigth.left = new BiNode(5);
		System.out.println(isBalanceTree(head));
	}
	//判断一棵树是否是平衡二叉树是一个递归过程
	public static TreeBean process(BiNode head) {
		//递归函数的basic case
		if(head == null) {
			return new TreeBean(true, 0);//如果结点为空则代表是一个高度为0的平衡二叉树
		}
		//在分别判断左右子树是否是一颗平衡二叉树
		TreeBean left = process(head.left);
		if(!left.isB) {
			return new TreeBean(false);
		}
		TreeBean right = process(head.rigth);
		if(!right.isB) {
			return new TreeBean(false);
		}
		if(Math.abs(left.length-right.length) > 1) {
			return new TreeBean(false);
		}
		return new TreeBean(true, Math.max(left.length, right.length) + 1);
	}
	//判断是否是一颗平衡二叉树的母函数
	public static boolean isBalanceTree(BiNode head) {
		return process(head).isB;
	}
}
