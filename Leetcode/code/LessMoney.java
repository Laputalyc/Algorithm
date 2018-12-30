package niuke;

import java.util.PriorityQueue;

public class LessMoney {
	/**
	 * 划分最少的切分金条的方法
	 * @param arr 所要求的切割结果
	 * @return
	 */
	public static int lessMoney(int[] arr) {
		if(arr.length ==0 || arr == null) {
			throw new RuntimeException("待切分金条无效！");
		}
		//basic case
		if(arr.length == 1) {
			return arr[0];
		}
		int result = 0;
		//1.将所给数组放入到最小堆中
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0; i<arr.length; i++) {
			queue.add(arr[i]);
		}
		//2.哈夫曼编码，循环结束的条件为最小堆内只剩一个元素
		while(queue.size() > 1) {
			/*
			 * 每次取两个最小的元素，求和后放回
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
