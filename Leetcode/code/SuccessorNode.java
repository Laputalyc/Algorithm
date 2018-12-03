package niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Node {
	int val;
	Node left;
	Node right;
	Node parent;
	public Node(int val) {
		this.val = val;
	}
}
public class SuccessorNode {
	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		/*System.out.println(test.val + " next: " + getSuccessorNode(test).val);
		test = head.left.left.right;
		System.out.println(test.val + " next: " + getSuccessorNode(test).val);
		test = head.left;
		System.out.println(test.val + " next: " + getSuccessorNode(test).val);
		test = head.left.right;
		System.out.println(test.val + " next: " + getSuccessorNode(test).val);
		test = head.left.right.right;
		System.out.println(test.val + " next: " + getSuccessorNode(test).val);
		test = head;
		System.out.println(test.val + " next: " + getSuccessorNode(test).val);
		test = head.right.left.left;
		System.out.println(test.val + " next: " + getSuccessorNode(test).val);
		test = head.right.left;
		System.out.println(test.val + " next: " + getSuccessorNode(test).val);
		test = head.right;
		System.out.println(test.val + " next: " + getSuccessorNode(test).val);
		test = head.right.right; // 10's next is null
		System.out.println(test.val + " next: " + getSuccessorNode(test));*/
		System.out.println("----------------------------");
		System.out.println(test.val + " next: " + getSuccessorNode2(test).val);
		test = head.left.left.right;
		System.out.println(test.val + " next: " + getSuccessorNode2(test).val);
		test = head.left;
		System.out.println(test.val + " next: " + getSuccessorNode2(test).val);
		test = head.left.right;
		System.out.println(test.val + " next: " + getSuccessorNode2(test).val);
		test = head.left.right.right;
		System.out.println(test.val + " next: " + getSuccessorNode2(test).val);
		test = head;
		System.out.println(test.val + " next: " + getSuccessorNode2(test).val);
		test = head.right.left.left;
		System.out.println(test.val + " next: " + getSuccessorNode2(test).val);
		test = head.right.left;
		System.out.println(test.val + " next: " + getSuccessorNode2(test).val);
		test = head.right;
		System.out.println(test.val + " next: " + getSuccessorNode2(test).val);
		test = head.right.right; // 10's next is null
		System.out.println(test.val + " next: " + getSuccessorNode2(test));
	}
	//方法1：通过parent指针找到头结点，然后进行中序遍历，再通过得到的序列进行后继结点的寻找。
	public static Node getSuccessorNode(Node node) {
		if(node == null) {
			throw new RuntimeException("不是一个有效的结点！");
		}
		Node  cur = node;
		while(cur.parent != null) {
			cur = cur.parent;
		}
 		//此时得到的cur结点即为树的头结点
		//对该树进行中序遍历:中序遍历的逻辑：当前结点为空则弹栈输出，指针往右走；当前结点不为空，则压栈，指针往左走。
		Stack<Node> stack = new Stack<Node>();
		List<Node> list = new ArrayList<Node>();
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				list.add(cur);
				cur = cur.right;
			}
		}
		int index = list.indexOf(node);
		return (index+1)<list.size()?list.get(index+1):null;
	}
	//方法2：利用后继结点和当前结点的规律来进行寻找
	/*
	 * 逻辑过程为当前结点有右孩子时，那么它的后继结点为它的右子树的最左结点；如果没有右孩子，那么它的后继结点是找到它作为左孩子的父结点。
	 */
	public static Node getSuccessorNode2(Node node) {
		if(node == null) {
			throw new RuntimeException("不是一个有效的结点！");
		}
		if(node.right != null) {
			return getLeftMost(node.right);
		} else {//当它的右子树为空时
			while(node.parent != null && node.parent.left != node) {
				node = node.parent;
			}
			return node.parent;
			/*while(node.parent != null) {
				if(node.parent.left == node) {
					return node.parent;
				} else {
					node = node.parent;
				}
			}
			return null;*/
		}
	}
	public static Node getLeftMost(Node node) {
		while(node.left != null) {//最后return node
			node = node.left;
		}
		return node;
	}
}
