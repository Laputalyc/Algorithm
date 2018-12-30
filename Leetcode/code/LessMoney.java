package niuke;

import java.util.PriorityQueue;

public class LessMoney {
	/**
	 * �������ٵ��зֽ����ķ���
	 * @param arr ��Ҫ����и���
	 * @return
	 */
	public static int lessMoney(int[] arr) {
		if(arr.length ==0 || arr == null) {
			throw new RuntimeException("���зֽ�����Ч��");
		}
		//basic case
		if(arr.length == 1) {
			return arr[0];
		}
		int result = 0;
		//1.������������뵽��С����
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0; i<arr.length; i++) {
			queue.add(arr[i]);
		}
		//2.���������룬ѭ������������Ϊ��С����ֻʣһ��Ԫ��
		while(queue.size() > 1) {
			/*
			 * ÿ��ȡ������С��Ԫ�أ���ͺ�Ż�
			 */
			int temp = queue.poll() + queue.poll();
			result += temp;
			queue.add(temp);
		}
		return result;
	}
	public static void main(String[] args) {
		//test
		int[] arr1 = {20, 10, 30};
		System.out.println(lessMoney(arr1));
		int[] arr2 = {10, 30, 21, 45, 14};
		System.out.println(lessMoney(arr2));
	}
}
