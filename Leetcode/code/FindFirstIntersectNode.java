package niuke;

import java.util.HashSet;


public class FindFirstIntersectNode {
	public static void main(String[] args) {
				// 1->2->3->4->5->6->7->null
				ListNode head1 = new ListNode(1);
				head1.next = new ListNode(2);
				head1.next.next = new ListNode(3);
				head1.next.next.next = new ListNode(4);
				head1.next.next.next.next = new ListNode(5);
				head1.next.next.next.next.next = new ListNode(6);
				head1.next.next.next.next.next.next = new ListNode(7);

				// 0->9->8->6->7->null
				ListNode head2 = new ListNode(0);
				head2.next = new ListNode(9);
				head2.next.next = new ListNode(8);
				head2.next.next.next = head1.next.next.next.next.next; // 8->6
				System.out.println(findFirstIntersectNode(head1, head2).val);

				// 1->2->3->4->5->6->7->4...
				head1 = new ListNode(1);
				head1.next = new ListNode(2);
				head1.next.next = new ListNode(3);
				head1.next.next.next = new ListNode(4);
				head1.next.next.next.next = new ListNode(5);
				head1.next.next.next.next.next = new ListNode(6);
				head1.next.next.next.next.next.next = new ListNode(7);
				head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

				// 0->9->8->2...
				head2 = new ListNode(0);
				head2.next = new ListNode(9);
				head2.next.next = new ListNode(8);
				head2.next.next.next = head1.next; // 8->2
				System.out.println(findFirstIntersectNode(head1, head2).val);

				// 0->9->8->6->4->5->6..
				head2 = new ListNode(0);
				head2.next = new ListNode(9);
				head2.next.next = new ListNode(8);
				head2.next.next.next = head1.next.next.next.next.next; // 8->6
				System.out.println(findFirstIntersectNode(head1, head2).val);
	}
	/**
	 * 判断一个链表是不是有环如果有环则返回第一个入环的结点，如果没有环则返回null
	 * @param head 待判断链表的头结点
	 * @return
	 */
	public static ListNode isRing(ListNode head) {
		//用一个哈希表存储每个结点，循环，直到null则没有环，否则，与表中的结点比较出现第一个相同的就为入环结点
		if(head == null) {
			throw new RuntimeException("您输入的不是一个有效的链表！");
		}
		HashSet<ListNode> set = new HashSet<ListNode>();
		while(head != null) {
			if(set.contains(head)) {
				return head;
			} else {
				set.add(head);
			}
			head = head.next;
		}
		return null;
	}
	//得到链表的长度
	public static int getLength(ListNode head, ListNode end) {
		int i = 0;
		if(head == null) {
			return i;
		} else {
			while(head != end) {
				i++;
				head = head.next;
			}
			return i;
		}
	}
	//得到链表的最后一个结点
	public static ListNode getEnd(ListNode head) {
		if(head == null) {
			throw new RuntimeException("该链表不是一个有效的链表！");
		}
		while(head.next != null) {
			head = head.next;
		}
		return head;
	}
	//两个单链表相交点
	public static ListNode noRingIntersectNode(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2, boolean flag) {
		if(flag) {
			if(getEnd(head1) == getEnd(head2)) {
				int len1 = getLength(head1, null);
				int len2 = getLength(head2, null);
				int step = Math.abs(len1-len2);
				if(len1 >= len2) {
					for(int i=0; i<step; i++) {
						head1 = head1.next;
					}
				} else {
					for(int i=0; i<step; i++) {
						head2 = head2.next;
					}
				}
				while(/*head1 != null && */head1 != head2) {
					head1 = head1.next;
					head2 = head2.next;
				}
				return head1;
			}
			return null;
		} else {
			int len1 = getLength(head1, loop1);
			int len2 = getLength(head2, loop2);
			int step = Math.abs(len1-len2);
			if(len1 >= len2) {
				for(int i=0; i<step; i++) {
					head1 = head1.next;
				}
			} else {
				for(int i=0; i<step; i++) {
					head2 = head2.next;
				}
			}
			while(/*head1 != null && */head1 != head2) {
				head1 = head1.next;
				head2 = head2.next;
			}
			return head1;
		}
	}
	//判断两个链表是否相交
	public static ListNode findFirstIntersectNode(ListNode head1, ListNode head2) {
		ListNode temp = head1;
		ListNode loop1 = isRing(head1);
		ListNode loop2 = isRing(head2);
		if(loop1==null&&loop2==null) {//两个无环链表相交的情况
			return noRingIntersectNode(head1, head2,null,null ,true);
		} else if(loop1!=null && loop2!=null) {//两个有环链表的情况
			if(loop1 == loop2) {//等效为单链表的情形
				//计算长度，getLength函数要重构一下
				return noRingIntersectNode(head1, head2,loop1, loop2, false);
			} else {
				HashSet<ListNode> set = new HashSet<ListNode>();
				while(temp != null) {
					if(set.contains(temp)) {
						break;
					}
					set.add(temp);
					temp = temp.next;
				}
				if(set.contains(loop2)) {//成环非入环点不同
					return loop1;
				} else {
					return null;
				}
			}
		} else {//有环链表和无环链表不可能相交
			return null;
		}
	}
}
