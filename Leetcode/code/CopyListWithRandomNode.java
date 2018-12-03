package niuke;

import java.util.HashMap;


class ListNodeRandom {
	int val;
	ListNodeRandom next;
	ListNodeRandom random;
	public ListNodeRandom(int val) {
		this.val = val;
	}
}
public class CopyListWithRandomNode {
	public static void main(String[] args) {
		ListNodeRandom head = new ListNodeRandom(1);
		head.next = new ListNodeRandom(2);
		head.next.next = new ListNodeRandom(3);
		head.next.next.next = new ListNodeRandom(4);
		head.next.next.next.next = new ListNodeRandom(5);
		head.next.next.next.next.next = new ListNodeRandom(6);

		head.random = head.next.next.next.next.next; // 1 -> 6
		head.next.random = head.next.next.next.next.next; // 2 -> 6
		head.next.next.random = head.next.next.next.next; // 3 -> 5
		head.next.next.next.random = head.next.next; // 4 -> 3
		head.next.next.next.next.random = null; // 5 -> null
		head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4
		printRandLinkedList(head);
		System.out.println("---copyListWithRandomNode1---");
		printRandLinkedList(copyListWithRandomNode(head));
		System.out.println("---copyListWithRandomNode2---");
		printRandLinkedList(copyListWithRandomNode2(head));
	}
	public static ListNodeRandom copyListWithRandomNode(ListNodeRandom head) {
		HashMap<ListNodeRandom, ListNodeRandom> map = new HashMap<>();
		ListNodeRandom head1 = head;
		//第一次循环拷贝所有结点
		while(head1 != null) {
			map.put(head1, head1);
			head1 = head1.next;
		}
		ListNodeRandom res = map.get(head);
		ListNodeRandom res1 = res;
		//第二次循环拷贝指针
		ListNodeRandom next = null, random = null;
		while(head != null) {
			next = head.next;
			random = head.random;
			res1.next = map.get(next);
			res1.random = map.get(random);
			head = next;
			res1 = map.get(head);
		}
		return res;
	}
	public static ListNodeRandom copyListWithRandomNode2(ListNodeRandom head) {
		//第一次遍历把结点和copy结点串接起来
		ListNodeRandom cur = head, temp = null;
		while(cur != null) {
			temp = cur.next;
			cur.next = new ListNodeRandom(cur.val);
			cur.next.next = temp;
			cur = temp;
		}
		//第二次遍历把random指针弄好
		cur = head;
		ListNodeRandom copy = cur.next;
		while(cur != null) {
			//copy.random = cur.random.next;//cur也有random指向null的情况
			copy.random = cur.random==null?null :cur.random.next;
			cur = cur.next.next;
			copy = copy.next == null? null:copy.next.next;
		}
		//把两个链表分开
		cur = head;
		copy = cur.next;
		ListNodeRandom temp2 = null, res = copy;
		while(cur != null) {
			temp = cur.next.next;
			temp2 = copy.next==null?null : copy.next.next;
			cur.next = temp;
			copy.next = temp2;
			cur = temp;
			copy = temp2;
		}
		return res;
	}
	public static void printRandLinkedList(ListNodeRandom head) {
		ListNodeRandom cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.random == null ? "null " : cur.random.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}
}
