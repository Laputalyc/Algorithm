package niuke;

import java.util.Stack;

/**
 * 判断一个链表是否是回文链表
 * @author liyuchen
 *
 */
class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}
public class IsPalindromeList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		System.out.println(isPalindromeList3(head));
		System.out.println("是否还原：");
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	/**
	 * 设置快慢指针比较一半即可
	 * @param head 待检查链表的头结点
	 * @return true表示为回文链表，false表示不是回文链表
	 */
	public static boolean isPalindromeList2(ListNode head) {
		ListNode quick = head, slow = head;
		while(quick.next!=null && quick.next.next!=null) {
			//快指针一次走两步，慢指针一次走一步
			slow = slow.next;
			quick = quick.next.next;
		}
		//将慢指针以后的结点压栈
		Stack<Integer> stack = new Stack<Integer>();
		//将后一半压栈
		while(slow.next != null) {
			slow = slow.next;
			stack.push(slow.val);
		}
		//将后一半与前一半比较
		//while(stack != null) {//判断栈是否为空
		while(!stack.isEmpty()) {
			if(stack.pop() != head.val) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	/**
	 * 不使用额外的空间实现判断是否为回文链表
	 * @param head 待比较链表的头结点
	 * @return true表示为回文链表，false表示不是回文链表
	 */
	public static boolean isPalindromeList3(ListNode head) {
		ListNode quick = head, slow = head;
		while(quick.next!=null&&quick.next.next!=null) {
			slow = slow.next;
			quick = quick.next.next;
		}
		//将slow指针的后半部分逆序
		quick = slow.next;
		slow.next = null;
		ListNode temp = null;
		while(quick != null) {
			temp = quick.next;
			quick.next = slow;
			slow = quick;
			quick = temp;
		}
		ListNode end = slow;
		ListNode restore = end;
		while(head != null) {
			if(head.val != end.val) {
				return false;
			} else {
				head = head.next;
				end = end.next;
			}
		}
		//将链表还原为原来的样子
		end = restore.next;
		restore.next = null;
		while(end != null) {
			temp = end.next;
			end.next = restore;
			restore = end;
			end = temp;
		}
		return true;
	}
}
