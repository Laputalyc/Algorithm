package niuke;
/*
 * 岛问题：一个矩阵中上下左右连成一片的1叫做一个岛
 */
public class Islands {
	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
		        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
		        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
		        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
		        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(islands(m1));
		System.out.println(islands(m2));
	}
	public static int islands(int[][] matrix) {
		int numbers = 0, width = matrix[0].length, length = matrix.length;
		for(int i=0; i < length; i++) {
			for(int j=0; j < width; j++) {
				if(matrix[i][j] == 1) {
					infect(matrix, i, j);
					numbers++;
				}
			}
		}
		return numbers;
	}
	/*
	 * 感染函数
	 */
	public static void infect(int[][] matrix, int i, int j) {
		if(i >= matrix.length || i<0 || j<0 || j >= matrix[0].length || matrix[i][j] != 1) {
			return;
		}
		matrix[i][j] = 2;
		//递归
		infect(matrix, i, j-1);
		infect(matrix, i-1, j);
		infect(matrix, i, j+1);
		infect(matrix, i+1, j);
	}
}
