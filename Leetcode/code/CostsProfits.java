package niuke;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 构造一个项目类型，由消费和收益两个成员组成
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
 * 把项目按照花费的最小堆排好序
 */
class Minheap implements Comparator<Project> {
	@Override
	public int compare(Project o1, Project o2) {
		// TODO Auto-generated method stub
		return o1.cost - o2.cost;
	}
	
}
/*
 * 把项目按照收益的最大堆排好序
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
	 * @param costs 项目花费
	 * @param profits 项目收益
	 * @param m 项目启动资金
	 * @param k 项目最大串行执行次数
	 * @return 最终总的资金
	 */
	public static int costsProfits(int[] costs, int[] profits, int m, int k) {
		PriorityQueue<Project> minQueue = new PriorityQueue<Project>(new Minheap());
		PriorityQueue<Project> maxQueue = new PriorityQueue<Project>(new Maxheap());
		//把所有项目按照花费排成最小堆
		for(int i=0; i<costs.length; i++) {
			minQueue.add(new Project(costs[i], profits[i]));
		}
		while( k != 0) {
		//把可以启动的项目取出按利润排成最大堆
			while(!minQueue.isEmpty()) {
				Project temp = minQueue.peek();
				if(temp.cost <= m) {
					maxQueue.add(minQueue.poll());
				} else {
					break;
				}
			}
			//两个堆已经初始化
			m += maxQueue.poll().profit;
			k--;
			if(maxQueue.isEmpty() && m < minQueue.peek().cost) {
				break;
			}
		}
		return m;
	}
}
