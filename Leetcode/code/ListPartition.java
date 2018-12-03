package niuke;

import java.util.ArrayList;
import java.util.List;

public class ListPartition {
	public static void main(String[] args) {
		ListNode head = new ListNode(9);
		head.next = new ListNode(0);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(1);
		ListNode res = listPartition(head, 3);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	/**
	 * 将其转化为和荷兰国旗问题求解
	 * @param head 待partition链表的头结点
	 * @param num 用以分割的数
	 */
	public static ListNode listPartition(ListNode head, int num) {
		List<ListNode> list = new ArrayList<ListNode>();
		//把结点添加到集合中去
		while(head != null) {
			list.add(head);
			head = head.next;
		}
		int i = -1, j = list.size(), pre = 0;
		while(pre < j) {//注意终止条件
			if(list.get(pre).val < num) {
				swap(list, ++i, pre++);
			} else if(list.get(pre).val > num) {
				swap(list, --j, pre);
			} else {
				pre++;
			}
		}
		for(int k = 0; k<list.size()-1; k++) {
			list.get(k).next = list.get(k+1);
		}
		list.get(list.size()-1).next = null;//记得把最后一个结点指向null
		return list.get(0);
	}
	public static ListNode listPartiton2(ListNode head, int num) {
		ListNode lH = null,lT = null, eH = null, eT = null, mH = null, mT = null;
		ListNode next = null;
		while(head != null) {
			next = head.next;
			head.next = null;
			if(head.val < num) {
				if(lH == null) {
					lH = head;
					lT = head;
				} else {
					lT.next = head;
					lT = head;
				}
			} else if(head.val == num) {
				if(eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if(mH == null) {
					mH = head;
					mT = head;
				} else {
					mT.next = head;
					mT = head;
				}
			}
			head = head.next;
		}
		//首先将less和equal连接起来
		if(lH != null) {
			lT.next = eH;
			eT = eT==null?lT:eT;
		}
		if(eT != null) {
			eT.next = mH;
		}
		return lH!=null?lH:eH!=null?eH:mH;
	}
/*	*//**
	 * 额外空间复杂度为O(1)
	 * @param head
	 * @param num
	 * @return
	 *//*
	public static ListNode listPartiton2(ListNode head, int num) {
		ListNode less = null, eq = null, more = null;
		ListNode lessEnd = null, eqEnd = null, moreEnd = null;
		ListNode headCopy = head;
		while(headCopy != null) {
			if(headCopy.val < num && less == null) {
				less = headCopy;
				lessEnd = less.next;
			}
			if(headCopy.val == num && eq == null) {
				eq = headCopy;
				eqEnd = eq.next;
			}
			if(headCopy.val > num && more == null){
				more = headCopy;
				moreEnd = more.next;
			}
			headCopy = headCopy.next;
		}
		ListNode temp = null;
		while(head != null) {
			if(head.val < num && head != less) {
				lessEnd = head;
				lessEnd = lessEnd.next;
			}
			if(head.val == num && head != eq) {
				eqEnd = head;
				eqEnd = eqEnd.next;
			}
			if(head.val > num && head != more) {
				moreEnd = head;
				moreEnd = moreEnd.next;
			}
			head = head.next;
		}
		ListNode res = null;
		//连接less和equal:最后的连接把人搞晕了！！！
		return null;//Abort 参考左神的方法。
		
	}*/
	public static void swap(List<ListNode> list, int i, int j) {
		/*
		 * 这是典型错误交换
		 * int temp = list.get(i);
		 * list.get(i).val = list.get(j).val;
		 * list.get(j).val = temp.val;
		 */
		int temp = list.get(i).val;   //这里一定要交换数值
		list.get(i).val = list.get(j).val;
		list.get(j).val = temp;
	}
}
