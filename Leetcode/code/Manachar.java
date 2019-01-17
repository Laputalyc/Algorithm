package niuke;

import static reference.Manacher.maxLcpsLength;
/*
 * 这个回文半径是指包含当前索引i出的字符，例如：3bcb2，字符c的回文半径为：先处理为特殊字符#3#b#c#b#2#,则字符c的回文半径为4(c#b#)
 */
public class Manachar {
    /**
     * 将给定的字符串处理成加上特殊字符的字符串，这里的特殊字符为"#"
     * @param str 待处理的字符串
     * @return 处理过后的字符串
     */
    public static char[] manacharString(String str) {
        char[] chs = str.toCharArray();
        char[] res = new char[str.length()*2 + 1];
        int index = 0;
        for (int i=0; i<res.length; i++) {
            res[i] = (i&1)==0?'#' : chs[index++];
        }
        return res;
    }

    /**
     * 计算字符串中最长回文串的长度
     * @param str 待处理的字符串
     * @return 返回最长回文串的长度
     */
    public static int manacharLength(String str) {
        if(str==null || str.length()==0) {
            return 0;
        }
        int R = -1;//初始回文右边界为-1
        int C = -1;//初始回文中心为-1
        int[] arr = new int[str.length()];//声明一个回文半径数组
        char[] chs = manacharString(str);//加上特殊字符
        int max = Integer.MIN_VALUE;
        for(int i=0; i<chs.length; i++) {
            arr[i] = R>i?Math.min(arr[2*C-i], R-i):1;//设置初始半径（即保证至少这个半径内的字符是回文字符串）
            //然后继续往下一个字符扩
            while (i+arr[i]<chs.length && i-arr[i]>-1) {
                if(chs[i+arr[i]]==chs[i-arr[i]]) {//情况1、情况4
                    arr[i]++;
                } else {
                    break;//即情况2和情况3，不需要扩了直接跳出循环
                }
            }
            //当扩完之后更新回文右边界和回文中心
            if (i+arr[i]-1 > R) {
                R = i + arr[i]-1;
                C = i;
                max = Math.max(arr[i], max);
            }
        }
        return max-1;
    }

    public static void main(String[] args) {
        String str1 = "3bcb2";
        System.out.println(maxLcpsLength(str1));
    }
}
