package niuke;

public class KMP {
	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(kmp(str, match));
	}
	/**
	 * 查找str2在str1中是否存在，如果不存在则返回-1，如果存在则返回str2在str1中开始的索引值。
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int kmp(String str1, String str2) {
		//首先得到next数组
		int[] next = getNext(str2);
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int i=0, j=0;
		while(i<chs1.length&&j<chs2.length) {
			if(chs1[i]==chs2[j]) {
				i++;
				j++;
			} else if(next[j]==-1) {
				i++;
			} else {
				j = next[j];
			}
		}
		return j==str2.length()?i-j:-1;
	}
	/**
	 * 求解next数组
	 * @param str
	 * @return
	 */
	public static int[] getNext(String str) {
		if(str==null || str.length()==0) {
			throw new RuntimeException("待查找的字串无效！");
		}
		char[] chs = str.toCharArray();
		int[] next = new int[str.length()];
		next[0] = -1;
		next[1] = 0;
		int i = 2, jump = 0;//jump为当前和i进行比较的字符
		while(i < str.length()) {
			if(chs[i-1] == chs[jump]) {
				next[i++] = ++jump;
			} else if(jump > 0) {
				jump = next[jump];
			} else {
				next[i++] = 0;
			}
		}
		return next;
	}
}
