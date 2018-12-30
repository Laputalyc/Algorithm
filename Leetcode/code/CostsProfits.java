package niuke;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * ����һ����Ŀ���ͣ������Ѻ�����������Ա���
 */
class Project {
	int cost;
	int profit;
	public Project(int cost, int profit) {
		this.cost = cost;
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "Project [cost=" + cost + ", profit=" + profit + "]";
	}
}
/*
 * ����Ŀ���ջ��ѵ���С���ź���
 */
class Minheap implements Comparator<Project> {
	@Override
	public int compare(Project o1, Project o2) {
		// TODO Auto-generated method stub
		return o1.cost - o2.cost;
	}
	
}
/*
 * ����Ŀ��������������ź���
 */
class Maxheap implements Comparator<Project> {
	@Override
	public int compare(Project o1, Project o2) {
		// TODO Auto-generated method stub
		return o2.profit - o1.profit;
	}
	
}
public class CostsProfits {
	public static void main(String[] args) {
		int[] costs = {10, 12, 14, 17, 25, 50};
		int[] profits = {2, 3, 4, 5, 6, 7};
		int m = 13;
		int k = 4;
		System.out.println(costsProfits(costs, profits, m, k));
	}
	/**
	 * 
	 * @param costs ��Ŀ����
	 * @param profits ��Ŀ����
	 * @param m ��Ŀ�����ʽ�
	 * @param k ��Ŀ�����ִ�д���
	 * @return �����ܵ��ʽ�
	 */
	public static int costsProfits(int[] costs, int[] profits, int m, int k) {
		PriorityQueue<Project> minQueue = new PriorityQueue<Project>(new Minheap());
		PriorityQueue<Project> maxQueue = new PriorityQueue<Project>(new Maxheap());
		//��������Ŀ���ջ����ų���С��
		for(int i=0; i<costs.length; i++) {
			minQueue.add(new Project(costs[i], profits[i]));
		}
		while( k != 0) {
		//�ѿ�����������Ŀȡ���������ų�����
			while(!minQueue.isEmpty()) {
				Project temp = minQueue.peek();
				if(temp.cost <= m) {
					maxQueue.add(minQueue.poll());
				} else {
					break;
				}
			}
			//�������Ѿ���ʼ��
			m += maxQueue.poll().profit;
			k--;
			if(maxQueue.isEmpty() && m < minQueue.peek().cost) {
				break;
			}
		}
		return m;
	}
}
