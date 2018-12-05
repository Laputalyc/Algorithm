package niuke;
/**
 * 求一颗二叉树的结点数量
 * @author liyuchen
 *
 */
public class CBTNodeNumber {
	public static void main(String[] args) {
		BiNode head = new BiNode(1);
		head.left = new BiNode(2);
		head.rigth = new BiNode(3);
		head.left.left = new BiNode(4);
		head.left.rigth = new BiNode(5);
		head.rigth.left = new BiNode(6);
		System.out.println(getCBTNodeNum(head));
	}
	public static int getCBTNodeNum(BiNode head) {
		//首先求一颗完全二叉树左子树的最左结点的高度
		if(head == null) {
			return 0;
		}
		int nodes = -1;
		int h1 = getLeftMore(head.left);//左子树的高度
		//在获取右子树的高度
		int h2 = getLeftMore(head.rigth);
		if(h2 == h1) {//说明左子树是一颗满二叉树
			nodes = (int) Math.pow(2, h1);
			return nodes + getCBTNodeNum(head.rigth);
		} else {//右子树是一颗满二叉树
			nodes = (int) Math.pow(2, h2);
			return nodes + getCBTNodeNum(head.left);
		}
	}
	/*
	 * 求一颗树的最左结点并返回高度
	 */
	public static int getLeftMore(BiNode head) {
		if(head == null) {
			return 0;
		}
		int i = 0;
		while(head != null) {
			i++;
			head = head.left;
		}
		return i;
	}
}
