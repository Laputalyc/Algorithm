# Algorithm

## 13.罗马数字转整数(2018/11/13)
* 思路：用switch进行判断，在有分歧的分支进行判断即可。
	* 字符串没有索引，s[i]是不存在的，解决办法是s.charAt(i),注意这是字符类型。
	* 当需要判断后一个元素是否有关联的时候需要首先判断是否越界。例如，(i+1)<s.length() &&s.charAt(i+1) == 'V'
## 14.最长公共前缀(2018/11/14)
* 首先用一个额外数组（len）记录输入字符串数组中各字符串的长度，其次求出数组len中的最小值（目的是为了在接下来比较的时候确定比较的最大范围），以及索引值（目的是为了在比较完成都没有不同之后，说明最长公共前缀即为输入字符串数组中长度最短的字符串），依次比较各个字符串中不同索引的字符，不同时，返回从0索引开始的子串。
	* 结合上题要注意数组的长度是一个字段，字符串的长度是一个函数。例如获取数组的长度  
	String[] strs = {"flower", "flight", "flow"};  
	s.length;  
	"flower".length();
	* substring(int beginIndex, int endIndex);
		* 两个s都是小写
		* 包括beginIndex索引，不包括endIndex索引。
	* 考虑一下特殊情况，输入数组为空，以及为null。
	* 考虑一下提高效率：输入字符串的长度为1可以直接输出，就是它本身。  
![longestCommonPrefix](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/longestCommonPrefix.PNG)
![longestCommonPrefixResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/longestCommonPrefixResult.PNG)  
## 20.有效的括号(2018/11/15)
* 思路：用一个哈希表存储括号对，一般情况下如果输入的是正括号就压栈，如果输入的是反括号，首先判断栈是否为空，如果为空则返回false，如果不为空则比较括号是否匹配，在最后，如果栈中全空，那么说明匹配成功了，不为空则失败。
	* HashMap<K, V>()  将K,V的类型加上不然后面会出现类型转换异常，字符的包装类型为Character。Stack也是同理。
	* 一个疑问。在程序第11行，判断一个字符串是否为空，用s == "";运行不同，用s.length() == 0;可以。
		* 关于上述疑问的一个解答：  
		String s = "";  
		String ss = "";
			这个时候s == ss为true。因为它们都是放在内存中的一块地址的，但是如果如下这样  
		String s = new String("");  
		String ss = new String("");这是s == ss就是false  
	而本题传入的s不知道是不是new出来的（有结果看来是new出来的），所以判断是否为空字符串的方法还是s.equals("") 或者 s.length() == 0(推荐这种方法效率高)  
![isValid](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/isValid.PNG)
![isValidResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/isValidResult.PNG)
## 21.合并两个有序链表(2018/11/16)
* 思路：和数组的归排序相同,一个merge的过程，但我是用额外的一个链表来存储结果的，应该可以在原有的链表上进行操作这样可以节省空间复杂度。这题可以再做思考。  
	* 我设置了一个temp变量来做操作，并用result记录第一个结点的。
	* 首先单独比较第一次把第一个结点确定下来，这样后面好操作。
	* 最后三种特殊情况输入都为null则输出也为null，其中一个为null则直接输出另外一个。  
![singleListNode](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/singleListNode.PNG)  
![mergeTwoLists](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/mergeTwoLists.PNG)
![mergeTwoListsResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/mergeTwoListsResult.PNG)
## 26.删除排序数组中的重复项(2018/11/17)
* 思路：设置两个指针，p1始终指示[0,p1]范围内排好序无重复的数组,p2始终指向待比较的数组元素。因为传入的是已排好序的数组，所以nums[p2]>=nums[p1]。分两种情况：若nums[p2] == nums[p1],那么p2++,如果nums[p2] > nums[p1] (所需要的数组元素)，swap(nums,++p1, p2++)。  
![removeDuplicates](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/removeDuplicates.PNG)  
![removeDuplicatesResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/removeDuplicatesResult.PNG)
## 27.移除元素(2018/11/18)
* 思路：同26，首先要明确一点对数组执行删除元素的操作只能是逻辑上的删除，不可能是物理上的删除，因为数据一旦确定长度就不会发生改变，所以删除的本质实际上是就是交换位置和限定长度，这通常都是要设置两个指针，而且一前一后，前一个指针最为返回的长度，后一个指针作为待比较的数组元素。  
![removeElements](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/removeElements.PNG)  
![removeElementsResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/removeElementsResult.PNG)
## 28.实现strStr()(2018/11/18)
![strStr](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/strStr.PNG)  
![strStrResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/strStrResult.PNG)
## 2.两数相加(2018/11/19)
* 思路：逆序并没有什么思维上的难度，向左进位变为向右进位就行了，这题大体思路上很直接，主要在于细节的处理以及界限的判定。
	* 注意空指针异常，和21题做一个对比，为什么21没有专门为结点指示next结点没有出现空指针异常，而这题就出现了呢？
	* 什么情况下需要下一个结点：1.其中任何一个或两个链表的下一个结点不为空。2.有进位。
	* 设置一个进位符是点睛之笔。  
![addTwoNumbers](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/addTwoNumbers.PNG)  
![addTwoNumbersResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/addTwoNumbersResult.PNG)
## 35.搜索插入位置(2018/11/19)
* 思路：设置一个索引i=0.如果nums[i]<target,则i++.如果nums[target]>=target,则return i.最后返回nums.length;
![searchInsert](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/searchInsert.PNG)  
![searchInsertResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/searchInsertResult.PNG)
## 3.无重复字符的最长字串(2018/11/20)
* 思路：用一个数组存储每个索引处的最长子串（最后一个不用比较，因为最后一个始终为1），然后在数组中得到最大值就是最长字串。
	* 使用一个字串中是否包含一个字符？contains()函数只能判断是否包含某个字符串，所以可以play a trick：contains(s.charAt(j)+"");在后面加上一个空字符。
	* 考虑两种情况：一、从某一处索引开始在中途断了怎么办？二、从某一处索引开始，一直到字符串结束都没有出现重复该怎么办？针对情况二，我加了一个标识位flag，这个标识位的主要判断原理是如果当j到了最后一个字符呢？但是没有出现错误，那么这时候的长度就是s.length()-i;
	* 根据标识位给这时候的len[i]赋值，如果是一路顺畅过去的len[i]是没有被赋值的是默认值0。
		* for循环的i++是在什么时候加。每次循环完都会加一次。  
	* **关于for循环j++到底是在什么时候加**(2018/12/1)
		* 正常循环在出了循环的范围后j就已经加了，如果是break导致的循环中断那么j就没有加。
![lengthOfLongestSubstring](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/lengthOfLongestSubstring.PNG)  
![lengthOfLongestSubstringResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/lengthOfLongestSubstringResult.PNG)  
###更优解法：**滑动窗口**(2018/11/20)
>之前暴力法是从第一个字符开始比较如果发现有重复了就回溯到从下一个字符开始比较还有嵌套的contains方法所以时间复杂度为O(n^2)，现在所讨论的滑动窗口不用回溯，假设某状态窗口的大小为[i,j)如果比较第j个字符没有出现重复则窗口向右移一位变为[i,j+1),如果出现了重复则窗口左边向右滑动一位变为[i+1,j)。  

	* 调用java原有内置方法的时间复杂度怎么算？
	* String中的contains方法和Set中的contains方法的时间复杂度是多少？
![lengthOfLongestSubstring_2](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/lengthOfLongestSubstring_2.PNG)  
![lengthOfLongestSubstringResult_2](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/lengthOfLongestSubstringResult_2.PNG) 
  
* set的add方法：添加元素；remove方法:移除元素，**索引会跟着改变**。
* set集合是**无序**的，放入和输出的元素顺序是不一致的。
### 优化的滑动窗口(2018/11/20)
* 思路：普通的滑动窗口存在的问题，最坏情况下需要做2n次操作，即每个字符均被i和j同时访问，这其实可以避免因为在[i,j)范围内中有字符与第j个字符重复了，那么可以进一步思考确定是[i,j)中的第k个字符重复了，那么接下来直接把i变为k+1即可。
	* 窗口的滑动是怎样实现的？
		* **很精髓的一个思维**： i = Math.max(map.get(s.charAt(j)), i);当发现待比较的字符已经存在Map中时（此时有两种情况：确实比较的字符与当前窗口中的某个字符重复，第二种情况是重复的窗口是之前遗留的），所以通过比较i的值，取其中最大的值即可，不用刻意删去。
	* 当键值相同时会进行覆盖，也就是更新。 
	* Map的几个常用方法：
		* containsKey():检查是否含有某个键
		* containsValue():检查是否含有某个值
		* get(K):通过传入键得到相应的值：如果不包含则返回null 

![lengthOfLongestSubstring_3](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/lengthOfLongestSubstring_3.PNG)  
![lengthOfLongestSubstringResult_3](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/lengthOfLongestSubstringResult_3.PNG)
### 扩展：假设字符集为 ASCII 128
> 以前的我们都没有对字符串 s 所使用的字符集进行假设。  
当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。  
常用的表如下所示：  
int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’  
int [128] 用于ASCII码  
int [256] 用于扩展ASCII码  

	public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int n = s.length(), ans = 0;
	        int[] index = new int[128]; // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            i = Math.max(index[s.charAt(j)], i);
	            ans = Math.max(ans, j - i + 1);
	            index[s.charAt(j)] = j + 1;
	        }
	        return ans;
	    }
	}
## 5.最长回文字串(2018/11/22)
思路：是一个模式匹配
## 7.整数反转(2018/11/24)
* 思路：主要在于怎样解决防止溢出的问题，我的思路是操作过程中始终用long进行操作，在最后进行判断是否溢出，如果没有则强转为int类型。
	* **有一个很严重的思路问题**：就是我把整数和负数分开考虑了，其实没有必要-123 = -12*10 + (-3)
	* 其二我是(res+remainder)*10，这样不如这样rev = rev * 10 + pop好，需要多一次判断。
	* 其三我的想法是在操作完成之后再判断是否溢出，其实可以在每次操作之前就判断是否溢出MAX_VALUE = 2147483647,MIN_VALUE = -2147483648;可以每次在进行rev = rev * 10 + pop之前对rev进行判断之后一步操作是否会造成溢出。
		> if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))   
		  	return 0;  
          if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))   	return 0;  

* 最初版本：  
![reverse](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/reverse.PNG)  
![reverseResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/reverseResult.PNG)  
* 改进版本：  
![reverse_2](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/reverse_2.PNG)  
![reverseResult_2](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/reverseResult_2.PNG) 
* Leetcode版本：  
![reverseLeetcode](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/reverseLeetcode.PNG)  
## 判断一个链表是否是回文结构(2018\11\24)
* 【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。 例如： 1->2->1，返回true。1->2->2->1，返回true。15->6->15，返回true。 1->2->3，返回false。
	* 思路1：不考虑额外空间复杂度，一次遍历将链表的值放入栈中，二次遍历将链表和栈中的值进行比较即可。
	* 思路2：设置一个快指针一个慢指针，快指针走完，慢指针刚好走到中点的位置，这时候从慢指针开始把后面的数据压栈，相当于把后面的半段与前面的半段相比，比较的终止条件是栈中为空。
	* 思路3：不使用额外空间复杂度。快指针走两步慢指针走一步，同上。然后把慢指针的有部分逆序。1 -> 2 -> 3 -> 2 -> 1改成 1 -> 2 -> 3 <- 2 <- 1,3的指针指向null。记得最后要给用户改回来。（奇数个走到中点位置，偶数个走到两个中点的前一个位置）。
		* 链表反转的标准代码块  
		
			    n2 = n1.next; // n2 -> right part first node  
    			n1.next = null; // mid.next -> null  
    			Node n3 = null;  
    			while (n2 != null) { // right part convert  
    				n3 = n2.next; // n3 -> save next node  
    				n2.next = n1; // next of right node convert  
    				n1 = n2; // n1 move  
    				n2 = n3; // n2 move  
    			}  
## 将单向链表按某值划分为左边小、中间相等、右边大的形式。(2018/11/25)
* 【题目】给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。除这个要求外，对调整后的节点顺序没有更多的要求。 例如：链表9->0->4->5->1，pivot=3。 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做要求。
	* 思路1(笔试)：一个荷兰国旗问题，将链表结点的值放入数组中（结点类型的数组），在数组中partition后，再用链表串起来即可。时间复杂度为O(n),空间复杂度为O(n)。
		* 注意partition的终止过程是while(pre < more).
	* 思路2(面试)：上诉方法（即荷兰国旗不具备稳定性），而且需要额外的空间复杂度。首先函数需要两个参数：待partition链表的头结点，用以分割的数num。需要三个引用变量都是结点类型less、eq、more。第一次对链表进行遍历的时候分别找到第一个小于、等于、大于num的结点并赋值给less、eq、more。同时为这三个区域分别准备一个end引用，没加入一个节点后end就指向这个刚移入的end。最后把这三个区域连接起来。时间复杂度为O(n),空间复杂度为O(1)。
		* 怎样把最后的三个链表连接起来可真是绕死我了。这里推荐左神的code。
## 复制含有随机指针结点的链表(2018/11/26)
* 【题目】一种特殊的链表节点类描述如下：  

        public class Node { 
    		public int value;
    		public Node next;
    		public Node rand;
     		public Node(int data) {
    	    this.value = data;
     		}
    	}  

* Node类中的value是节点值，next指针和正常单链表中next指针的意义一样，都指向下一个节点rand指针是Node类中新增的指针，这个指针可 能指向链表中的任意一个节点，也可能指向null。 给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。进阶：不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N)内完成原问题要实现的函数。
* 哈希表拓展：containsKey()以及get()方法的时间复杂度为O(1)。
* 思路1：首先一遍遍历用HashMap，存储所有结点及其拷贝结点。然后从头结点开始第二次遍历，遍历的过程中通过next指针找打1的next结点2，从哈希表中找到2的拷贝结点2'，所以1'的next结点为2',同样可得random指针以及其它结点的连接关系。
* 思路2（不用哈希表）：首先一遍遍历形成1 -> 1' -> 2 -> 2' -> 3 -> 3'这种结构。假设现在1的random指针是指向3的，要使1'的random指针指向3'，3' = 1.random.next.如此，可以把random指针解决，接下来的事情就是怎样把两个链表的next指针分开。
## 两个单链表相交的一系列问题(2018/11/26)
* 【题目】 在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点 head1和head2这两个链表可能相交，也可能不相交。请实现一个函数， 如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null 即可。 要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外空间复杂度请达到O(1)。
	* 考虑几个问题：
		* 怎样判断一个链表有环还是无环？（若有环则返回第一个入环的结点，若无环则返回null）
			* 有环可以是一个整环，或者是从某一结点开始的环。
				* 【思路1】：用一个HashSet,判断当前结点是否存在于HashSet中，若存在则返回该结点，该结点就是第一个入环的结点，如果不存在则把该结点加入到HashSet中，继续对下一个结点进行类似的操作。
				* 【思路2】：那不用HashSet怎么做呢？设置快、慢指针，快指针一次走两步，慢指针一次走一步。如果快指针走到null了则无环；否则，两个指针一定相遇，当相遇时，快指针回到头结点处，然后都每次各走一步，它们第一次相遇的点即为入环点。
		* 怎样找到两个无环单链表的第一个相交结点？
			* 【思路1】先遍历第一个链表，把结点放入HashSet中，然后遍历第二个链表，第一个在HashSet中存在的结点即为相交的结点，若一直没有公共结点则不相交。
			* 【思路2】同理不用HashSet怎么办呢？分别遍历两个链表的到长度和最后一个结点。最后一个结点不相同一定不相交，若相同，则比较长度，若长度不相同，则长度长的先走多出的步数，然后两个指针一起走直至相交的第一个结点。
		* 怎样找到两个有环单链表相交的第一个结点？
			* 有环和无环不可能相交。
			* 两个有环的链表有三种拓补结构（head1、head2、loop1、loop2（入环结点））：  
			* 
![findFirstIntersectNode](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/findFirstIntersectNode.png)

				* 1.各自成环不相交
				* 2.先相交再成环
					* 判断条件loop1 == loop2，判断哪个是相交结点同无环链表的相交。
				* 3.在环里相交
					* loop1 ！= loop2为情况1或3，这时进而判断，loop1往下走，如果走了一圈回来还没找到loop2则为情况1，否则为情况3。
## 实现二叉树的先序、中序、后序遍历，包括递归方式和非递归方式(2018/11/27)
* 不管哪种遍历每个节点都会访问三次，如果把打印节点的时机放在第一次访问该结点的时候就是先序遍历，放在第二次访问该结点的时候就是中序遍历，放在第三次访问该结点的时候就是后续遍历。
	* 注意中序遍历和后续遍历是输出的项
![inOrderTraverse](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/inOrderTraverse.PNG)  
![visitOrder](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/visitOrder.png)
* 非递归版本的先序遍历
	* 利用一个栈，先把**头**结点压栈，每次进入循环的时候先把栈顶的结点弹出来，并输出（头结点）再压头结点的**右**结点，再压头结点的**左**结点，这样就模拟了中左右的顺序。
		* 为什么考虑用栈来代替递归呢？
			* 递归的本质就是函数的压栈与弹栈。
			* 遍历二叉树的过程中始终存在一个需要回去的需求，栈结构天然就具备者这种特性。
* 非递归版本的中序遍历
	* 整个逻辑：当前结点为空则从栈里弹出一个结点并打印，然后结点右移。如果当前结点不为空，则压栈，当前结点往左走。
	* 思考一下循环的终止条件是什么。
* 非递归版本的后序遍历
	* 后序遍历的顺序是：左右中。我们知道先序遍历的顺序是中左右，这个很好实现，同样的要实现中右左的访问顺序也很好实现，我们的思路就是在实现了中右左的顺序后不打印，先把它压入另一个栈中再一次弹出，这样就实现了左右中的打印顺序。
![inOrderTraverse2](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/inOrderTraverse2.PNG)  
## 在二叉树中找到一个结点的后继结点(2018/11/29)
> 现在有一种新的二叉树结点如下：  

        public class Node { 
	    	public int value; 
	    	public Node left;
	    	public Node right; 
	    	public Node parent;
	    	public Node(int data) { 
	    		this.value = data; 
	    	}
    	}
该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假设有一棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向 自己的父节点，头节点的parent指向null。只给一个在二叉树中的某个节点 node，请实现返回node的后继节点的函数。在二叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
* 思路1：通过parent指针找到头结点，然后进行中序遍历，找到后继结点。
* 思路2：
	* 如果一个结点有右孩子，那么它的后继结点一定是它的右子树上最左的结点。（因为中序遍历的顺序是左中右，那么一个结点被访问后，接下来肯定要访问它的右子树，而由左中右的顺序，接下来访问的肯定是它的最左结点）。
	* 如果一个结点A没有右孩子，那么它的后继结点B是，A是B的左子树的最后一个结点。
		* 具体实现是，如果A没有右孩子，通过A的parent指针找到它的父结点B，如果A是B的左孩子则停止，B就是A的后继结点，否则继续找B的父结点，且令A = B,同理可得；如果向上找为null了，说明不存在后继结点。
* 那么前驱怎么找呢？
	* 如果有左子树，则找左子树上最右的结点，如果没有左子树，则向上找直到当前结点是父节点的右孩子。
## 二叉树的序列化和反序列化(2018/11/29)
怎么将一棵树变成一个字符串，通过这个字符串就能重构出这棵树。 
 
* 先序遍历的方式序列化
![preOrderTraverse_serialize](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/preOrderTraverse_serialize.png)
* #代表null  
同理中序、后续的序列化和反序列化原理同上。
* 按层序列化
![layer_serialize](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/layer_serialize.png)
## 判断一棵树是否是平衡二叉树(2018/11/30)
* 什么叫做平衡人二叉树：每个结点的左子树和右子树的高度差不超过1。  
**在处理二叉树的问题的时候递归函数很好用**
* 首先怎样判断一个头结点构成的数是否是平衡二叉树
	* 1）左子树是一颗平衡二叉树。
	* 2）右子树是一颗平衡二叉树。
	* 3）左子树的高度和右子树的高度差不超过1。  
根据以上的分析判断一个结点构成的树是否是平衡二叉树最后需要返回两个值，一个Boolean类型的是否是平衡二叉树，另一个返回值是整数类型的树的高度。
## 判断一棵树是否是搜索二叉树(Binary Search Tree)(2018/11/30)
* 什么叫做搜索二叉树：对于任何一个节点，左子树上结点的值都比它小，右子树上所有结点的值都比它大。空数是搜索二叉树。
* 怎样判断一颗二叉树是否是搜索二叉树？一棵树的中序遍历是依次升序的就说明是搜索二叉树。
	* 非递归版本很容易想到。
	* 递归版本【@ author 李昱辰】可以这样来考虑：要判断一棵树是否是搜索二叉树它得满足三个条件1.左子树是搜索二叉树。2.右子树是搜索二叉树。3.当前结点的值要大于左子树头结点的值，要小于右子树**最左结点的值**。
		* 特别左右子树为null的情况，任何一边为null都表示这一边满足要求3。
## 判断一棵树是完全二叉树(complete binary tree)(2018/11/30)
* 1.如果一个结点有右孩子但没有左孩子，则一定不是完全二叉树。
* 2.如果一个结点的孩子不全，则它按层遍历后面遇到的结点必须都是叶节点才能是完全二叉树。 
* 3.空树不是完全二叉树。  
## 已知一颗完全二叉树，求其结点的个数(2018/12/4)  
要求时间复杂度**低于**O(n),N为这棵树结点的个数。 

* 对二叉树进行遍历的时间复杂度均为O(n)。
* 思路：我们知道一颗满二叉树的结点数量为2^l-1(其中l为树的高度)，由这个思路出发，我们可以加快求解结点数量的进程。首先得到一棵树左子树的最左结点，通过这个结点可以得到树的高度h1。其次访问一棵树的右子树的最左的结点，得到右子树的高度h2。
	* 1.如果h2 = h1,说明左子树是一颗满二叉树，这时左子树加头结点的数量为2^(h1-1)-1+1=2^(h1-1),这时右子树又是一颗完全二叉树，对它进行递归。
	* 2.如果h2 < h1,说明右子树是一颗完全二叉树，只不过高度为h2 = h1 -1,那么右子树加结点的数量为2^(h2-1)。同样现在左子树是一颗二叉树，进行递归即可。

## 认识哈希函数和哈希表

* 哈希函数的性质
	* 哈希函数的输入域是无限的。
	* 哈希函数的输出域是有限的。
	* 输入是同一个，那么输出也是同一个。
	* 这样就有一个多对少的问题，所以输入不同也可能对应相同的输出。（哈希碰撞）
	* 哈希函数的离散性：输入均匀分散到输出。
* 哈希表的经典结构  
首先初始一个空间比如大小为17的一个空间  
	* put(key,value):首先根据key算出一个hashcode，然后用这个hashcode%17，把这条记录放在算出的那一行（比如10）。这样肯定会有重复，如果另外一个key经前面一系列计算后也是第10行，那么如果key值相同则进行覆盖，如果不相同，则在后面接一个结点，构成链表。类似于顺序存储和链式存储相结合。待到一定程度，比如每个顺序存储地址之后都链接了5个结点，觉得再这样下去效率会有所影响，这时候就要扩容了。我现在想把顺序存储的地址改为104，这时候再计算的时候就要mod104了，那么以前的记录就要失效了，这时候要把之前的拿出来重新进行计算存储。那扩容代价不用计算吗？怎么才能做到存取的时间复杂度都是O(1)?
## 设计RandomPool结构  
【题目】设计一种结构，在该结构中有如下三个功能：insert(key)：将某个key加入到该结构，做到不重复加入。delete(key)：将原本在结构中的某个key移除。 getRandom()：等概率随机返回结构中的任何一个key。  
【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)  

* 思路：准备一张哈希表肯定不行，它只能做到大致均匀分布，做不到严格的等概率（由哈希函数的离散性可知），因此准备两张哈希表，比如现在要插入一个字符串"abc",那么就在第一个哈希表中存入"abc" = 0,在第二个哈希表中存入0 = "abc",同时设置一个size变量记录存入的总记录，利用Math.random()*size来获取随机的index，在map2中取出对应的字符串，这样就做到了getRandom();但是考虑一下如果进行remove操作后，相当于这一系列连续的存储地址中出现了一个“洞”，如果下次再随机到这里该怎么办呢？所以每次delete()的时候，先remove掉原来位置的记录，再把最后一条记录补到这个“洞”上来这样就好了。

## 布隆过滤器(2018/12/10)
* 还是url黑名单问题：采用经典的结构该怎么解决这个问题。用一个HashSet存储黑名单上的url，别的不谈至少需要100亿*64(假设每个url由64bit组成) = 745G的存储空间（内存）。更进一步，可以用哈希函数分流到多台机器上进行分布式处理。
* 布隆过滤器：是一个bit类型的map。准备一个数组，索引为[0,m-1]，它的每个位置都存储的是1bit,即0或1。怎么实现呢？一个整型int是4个字节，总共是32bit,所以如果申请一个int[] arr = new int[1000]可以表示32*1000个bit位。假设我们现在要把第index = 30000个位置的bit置为1该怎么做呢？首先确定它是来自哪一个整数位intIndex = index/32;再获取他是来自该整数位的哪一个bit位 bitIndex = index % 32; 然后置1: **arr[intIndex] = arr[intIndex] | (1 << bitIndex)**;现在考虑一个黑名单问题：假设一个浏览器有100亿个URL在黑名单里面，那么怎么才能确定用户输入的URL是否是黑名单里面的URL呢？准备一个范围为[0,m-1] **bit** 类型的数组，设计k个哈希函数，每个URL经过哈希函数计算后，描黑k个bit位。这样一来当用户输入一个URL之后，经过同样的k个哈希函数计算后，如同那k个位置都被描黑则，说明是黑名单URL，但凡有一个位置没有被描黑，则说明不是黑名单中的url。可以通过调整数组的大小和哈希函数的k来调整失误率。数组大小越大，失误率越低。  
* m的大小可通过公式计算出来：m = - (n*lnp/(ln2)^2).其中n为样本量，p为预期失误率。
* k的大小也可以通过公式计算出来：k = ln2 * (m/n)
* 最终的失误率：(1-e^(-n*k/m))^k

## 一致性哈希(2018/12/10)

* 经典的服务器是一个怎样的抗压结构？例如有无差的前端接收请求，经过哈希函数后均匀分布到后端进行处理，这就是一个传统的服务器抗压结构。当要加机器或者减机器的时候就出现和哈希表扩容一样的问题了，原来数据的归属全都得变。这里就引出一致性哈希的概念：它既可以使数据迁移的代价极低，又可以做到负载均衡。  

传统的服务器抗压结构：  
![traditionalServerClient](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/traditionalServerClient.png)

* 假设哈希函数的返回值范围是0~2^64，把这个范围想象成一个环(2^64下一个位置是0)。假设现在有三台机器，这三台机器肯定有唯一确定的办法，假设现在用IP地址进行区分，把他们的IP地址经过哈希函数运算后对应到环上去。这样三台机器在环上的位置就确定了。现在怎样存储数据呢？例如“zuo = 31”,把zuo经过哈希函数计算后（**这时候不用%了**）对应到环上的一个位置，然后顺时针找到离它最近的机器交由它处理。该怎么实现呢？把三台机器的哈希值排好序放入一个数组中，在每个前端服务器都放入这个数组，每当一个请求过来之后经过哈希函数计算后得到的值找到>=该值的机器即可(二分法)。
* 这样该怎么加一台机器呢？只需把m2-m4中在m3的数据迁移到m4中去。减一台同理，代价很低。      
![dataMigration](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/dataMigration.png)  

* 现在这个结构存在的问题是？当这个机器较少时怎么能保证环被均分？(机器数量足够多的时候有哈希函数的性质可保证均分)还有假设采用技术使最开始的机器保持均分，那么假如一台机器后怎么保持均分呢？ 
* **虚拟结点技术可以解决上述两个问题。** 假设有三台真实机器：M-1,M-2,M-3。现在不让M-1的IP去在环上确定位置，而是给M-1分配1000个虚拟结点：M-1-1,M-1-2,……M-1-1000，同理M-2,M-3也是。然后准备一张路由表(可以从真实的物理机器去查它有哪些虚拟结点，也可以通过虚拟结点去查它属于哪台物理机器)，用虚拟结点去抢占这个环，这样在大样本的情况下就充分离散了。

## 认识并查集结构(2018/12/14)  
* 用途：  
	* 查两个元素是否属于一个集合。(isSameSet)
	* 两个元素各自所在的集合合并在一起。(union)
* 基本结构：假设现在有5个数(1、2、3、4、5)，第一步让每个数各自成一个集合，即1所在的集合只有1。在每个集合中代表结点的指针是指向自己的，每次要做指针的合并都是将其它元素的指针指向待连接的结点。  
	* 在查找代表结点的过程中有一个优化：例如结点结构5->4->3->2->1,6->1,我现在要查找结点4的代表结点，那么在查找之后就会变为5->4->1,3->1,2->1,6->1,这种结构。

## 岛问题
一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛？  
举例：  
0 0 1 0 1 0  
1 1 1 0 1 0  
1 0 0 1 0 0  
0 0 0 0 0 0  
这个矩阵中有三个岛。  

* 思路1：遍历矩阵中的每个点：如果是1则用感染函数对它该点进行感染，将它上下左右所有位置的1变为2(这是一个递归过程)，每次感染结束后岛的数量加1，在遍历的过程中如果遇到2和0则跳过，直到遍历结束。  

* 思路2：分治的思路。将一个矩阵拆分成几个矩阵来看。这时候只需要获取每个小矩阵中岛的数量以及边界信息(这里边界信息记录，每个岛是由哪个感染源感染的)，在合并的时候，如果两个1相连，则查看它们是否来自一个集合，如果不是则岛的数量减1并且将这两个感染源放入一个集合中。如果是0和1或者0和0相连则不用管，直接进行下面的比较。(并查集的用法)

## 前缀树
* 前缀树的字符信息为什么不放在结点中，而放在边上？其实放在结点中也可以，但不好处理，你新添加一个字符串之后，要判断之前是否添加过需要遍历每个结点才能知道。将信息放在边上也是一个小技巧，它的代码有些巧妙。还有注意就是头结点在每个方法中需要用变量接收，不然会出现错误。  
[前缀树](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/code/CBTNodeNumber.java)

## 贪心策略
* 【题目】假设有一个字符串类型的数组，现在要将所有的字符串都拼接起来，这样会用多种拼接结果，现在要找拼接出来字典序最小的结果。
* 【贪心选择】我们首先考虑一个贪心选择：两个字符串str1和str2，如果str的字典序小于str2的字典序，则在拼接的时候将str1放在str2的前面。这个贪心选择对吗？显然不对，考虑这样一个例子：str1 = "b",str2 = "ba",按照上述贪心选择，拼接的字符串应该是"bba",但显然"bab"的字典序更小。所以这种贪心选择不可取。正确的贪心选择是怎样的呢？提出如下贪心选择：如果str1.str2的字典序小于等于str2.str1的字典序，那么str1放在前面，否则str2放在前面。
* 【证明】要说明上述所选的贪心选择是可行的，也就是说按照上述规则排序的结果是唯一的，那么就得证该贪心选择具有传递性。如上已经证得了该贪心选择是对的那么如何说明通过该贪心选择得到的字符串拼接是最小的？先证任意两个字符交换得到的字典序一定比之大。

## 53.最大子序和
* 题目：[最大子序和](https://leetcode-cn.com/problems/maximum-subarray/description/)  
* 思路：我最初的思路是用滑动窗口来求解。但对于这题来说没有必要，因为滑动窗口得到的是一个范围，但是本题没有必要去得到这个范围，只需要得到这个值即可。  

		public int maxSubArray(int[] nums) {
			int max = nums[0],temp = nums[0];
			for(int i=1; i<nums.length; i++) {
				if(temp > 0) {
					temp = temp+nums[i];
				} else {
					temp = nums[i];
				}
				if(temp > max) {
					max = temp;
				}
			}
			return max;
		}

## 58.最后一个单词的长度

## 66.加一
* 题目：[加一](https://leetcode-cn.com/problems/plus-one/description/)
* 思路：和之前的有一道链表题相似，我还在考虑设置进位符。其实这个题的思路可以更精简一些。  

	    public int[] plusOne(int[] digits) {
    		int end = digits.length;
			for(int i=end-1; i>=0; i--) {
				if(digits[i]<9) {
					digits[i]++;
					return digits;
				}
				digits[i] = 0;
			}
			int[] a = new int[end+1];
			a[0] = 1;
			return a;
    	}  

* 很精炼的思路。

## 切金条
* 【题目】一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的 金条，不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块金 条，怎么分最省铜板？例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长度60的金条分成10和50，花费60 再把长度50的金条分成20和30，花费50 一共花费110铜板。但是如果， 先把长度60的金条分成30和30，花费60 再把长度30金条分成10和20，花费30 一共花费90铜板。输入一个数组，返回分割的最小代价。
* 思路：其实是一个哈夫曼编码。利用小根堆，每次弹出两个最小的进行合并，把合并而成的数再放回堆里去，直到堆里只剩一个数的时候，所有合并过程中的数相加即为分割代价最小。

## 项目收益
* 现在有两个数组，一个代价数组cost，一个利润数组profit，假设现在有一笔启动资金w，一次只能做一个项目。还有一个参数k，代表整个过程只能做k个项目，做完之后就不能再做了。qui最终获得的钱是多少。
* 思路：根据cost和profit数组，生成一个个项目类型的结点，这个结点包含两个东西，一个就是cost一个就是profit。建立一个小根堆，这个小根堆是按照谁的花费低谁来到头部的这样一个小根堆。这时候看初始资金，从小根堆中弹出所有cost小于w的项目，然后这些项目按照profit组成大根堆。大根堆头部的项目一定是所有能做的项目中收益最高的。获得收益后，再次重复上述过程，知道循环结束。这个不一定是做k次才循环结束，也可能是启动资金不够做其它项目了。  

## 67.二进制求和
* 【题目】[二进制求和](https://leetcode-cn.com/problems/add-binary/description/)  
* 注意点：
	* 怎么把char类型的'1'转化为int类型的1，'1' - '0'，然后用一个int类型的变量去接收。
	* 按照数的运算规则，charAt得是倒着取索引的。
	* 判断是否进位并不是temp1+temp2+flag == 2，而是temp1+temp2+flag >= 2。
	* StringBuilder类有一个reverse()函数可以直接对字符串进行反转。
* 思路：其实这题还是一个数学方法。困难的地方在于字符串、字符、整型这些类型之间的倒腾。所以推荐如下方法。  

		public String addBinary(String a, String b) {
			int i = a.length()-1;
			int j = a.length()-1;//倒着取索引
			int carry = 0;//进位符
			while(i>=0 || j>=0) {
				int sum = carry;
				if(i>=0) sum += a.charAt(i--) - '0';
				if(j>=0) sum += b.charAt(j--) - '0';
				sb.append(sum % 2);
				carry = sum / 2;//这样考虑进位很巧妙
			}
			if(carry != 0) sb.append(carry);
			return sb.reverse().toString();
		}

## 69.x的平方根
* 【题目】[x的平方根](https://leetcode-cn.com/problems/sqrtx/description/)
* 思路1：牛顿迭代法
* 思路2：二分法  
[x的平方根](https://blog.csdn.net/xusiwei1236/article/details/25657611)

## 会议室宣讲次数
* 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数组，里面 是一个个具体的项目)，你来安排宣讲的日程，要求会议室进行 的宣讲的场次最多。返回这个最多的宣讲场次。
* 【贪心选择】按照哪个项目早开始选择哪个项目显然不行，因为假设一个项目从6:00开始，但是一开开了一整天，那不就一天就举行了一个项目吗。按照哪个会议持续的时间短也得不到正确的解，因为显然这个贪心选择显然也不成立。

## 递归和动态规划
* 暴力递归：
	* 把问题转化为规模缩小了的同类问题的子问题
	* 有明确的不需要继续进行递归的条件（base case）
	* 有当得到了子问题的结果之后的决策过程
	* 不记录每一个子问题的解
* 求n!的结果
* 汉诺塔问题
* 打印字符串的所有子序列
* 打印字符串的全排列

* 一个二维数组，二维数组中的每个数都是正数，要求从左上角走到右下角，每一步只能向右或者向下。沿途经过的数字要累加起来。返回最小的路径和。
* 【暴力递归】存在的问题：会做大量重复的工作。比如在f(0,0)这一步要算f(0,1)和f(1,0)，其中f(0,1)要算f(1,1)和f(0,2),f(1,0)要算f(1,1)和f(2,0)，这样f(1,1)就重复算了两次。其实可以在第一次算f(1,1)的时候就存储起来，等到下次要用的时候直接查出它的值即可。
* 什么样的暴力递归可以转化为动态规划：要满足无后效性和有重复项。什么叫做无后效性？就是之前所做的选择不影响后续的过程，例如不管你以哪种方式到达[1,1],从点[1,1]到达右下角的最短路径都是固定的。有例如八皇后问题，就不满足后无效性，因为之前你做的决策会影响到后续过程。
* 对于这题来说，只要i,j确定返回值就确定了，所以可以以i的变化范围为行，以j的变化范围为列组成的一个二维表里面可以填上每种状态的返回值。我们所需要的结果就是[0,0]位置的值，但[0,0]位置的值又是依赖于其他位置的，我们首先找到不依赖与其他位置的状态(base case)。在表中填上，然后找到任意一个状态的依赖关系，依次求出表中其它位置的值，直至我们所要的状态，在本题中为[0,0]。
* 又例：给一个数组arr和一个整数aim。如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者false。

## 88.合并两个有序的数组
* [合并两个有序的数组](https://leetcode-cn.com/problems/merge-sorted-array/)
* 【最初思路】:还是正着比较，如果num1中的数值小，则继续往后移动，知道在nums1中发现比nums2中更大的元素，则nums2中的元素插入到nums1中对应的元素之前，相应的之后的元素要后移。
* 【思路2】：根据数据结构来看，倒着比较倒着排更好一些。首先初始指针i,j分别指向nums1和nums2的最后一个有效元素所在的位置，指针k指向nums1的最后一个位置。nums1和nums2中谁大谁往最后放。

		public void merge(int[] nums1, int m, int[] nums2, int n) {
			int i = m-1, j = n-1, k = n+m-1;
			while(i>=0 && j>=0) {
				if(nums1[i] > nums2[j]) {
					nums1[k--] = nums1[i--];
				} else {
					nums1[k--] = nums2[j--];
				}
			}
			while(j >=0 ) {
				nums1[k--] = nums2[j--];
			}
		}

## 107.二叉树的层次遍历(2)
* 题目：[二叉树的层次遍历(2)](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)
* 思路：怎样判断哪些元素在同一层？每次在队列里面装的就是同一层的元素。然后怎样实现逆序输出呢？list有一个add(int index, E element)方法，每次把得到的结果放在0索引的位置，这样就可以实现逆序呢。  

		class Solution {
		    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		        if(root == null) {
		            return new ArrayList();
		        } 
		        Queue<TreeNode> queue = new LinkedList<TreeNode>();
		        List<List<Integer>> res = new ArrayList();
		        queue.add(root);
		        while(!queue.isEmpty()) {
		            List<Integer> list = new ArrayList();
		            int size = queue.size();
		            for(int i=0; i<size; i++) {
		                root = queue.poll();
		                list.add(root.val);
		                if(root.left != null) {
		                    queue.add(root.left);
		                }
		                if(root.right != null) {
		                    queue.add(root.right);
		                }
		            }
		            res.add(0, list);
		        }
		        return res;
		    }
		}

## 119. 杨辉三角 II
* 【题目】[杨辉三角 II](https://leetcode-cn.com/problems/pascals-triangle-ii/)
* 思路：杨辉三角若从第0行开始计数，则第n行的第k(k从0索引开始)个数的值为C(n,k)，并且有一个递推公式：**C(n,k)=C(n-1,k-1)+C(n-1,k)**，因此可以用一个迭代的方法，但是注意**要从后往前计算**。
	* 【**注意**】ArrayList的add(int Index, E element)方法不是覆盖，会把当前位置的元素往后挤，set(int Index, E element)才是覆盖。

			class Solution {
			    public List<Integer> getRow(int rowIndex) {
			        List<Integer> res = new ArrayList();
			        for(int i=0; i<=rowIndex; i++) {
			            for(int j=i-1; j>0; j--) {//从后往前计算
			                res.set(j, res.get(j-1)+res.get(j));
			            }
			            res.add(1);
			        }
			        return res;
			    }
			}
## 122.买股票的最佳时机
* 【题目】[买股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

## KMP算法
* 解决的问题：解决包含问题
* 思路1：暴力方法。假设str1=aaaaaab,str2=aaab。依次从str1的索引开始比较是否和str2相同，时间复杂度为O(n*m)，默认N是大于等于M的。
* 在学习KMP算法之前先了解一个预备知识。假设有一个字符串str=abcabcd，我现在要求d的之前字符串的最长前缀和最长后缀相等的字符串。（**最长前缀不包含最后一个字符，最长后缀不包含第一个字符，且最长后缀是从后往前数**），此时的d->3。  
考虑整个过程假设模式串str2=ababac，求出每个字串对应相等的最长前缀和最长后缀。并用一个next数组存储起来  
**next=[-1,0,0,1,2,3]，其中-1和0是人为规定**  
str1从i位置开始和str2从0位置开始之前一直相等，一直到X和Y出现匹配失败，**那么现在str2该移动到什么位置，并且从什么位置开始比较呢？**移动到如图的j位置，并且X和Z开始比较。  
![KMP](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/KMP01.PNG)  
**为什么j之前的位置不可能存在可以和str2完全匹配的字串？**  
![KMP](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/KMP02.PNG)   
假设k位置开始可以完全匹配上str2，那么推出矛盾，即Y的前缀和后缀的最长匹配长度出现了矛盾。  
**next数组怎么求？**  
0位置对应-1,1位置对应0。数学归纳法，假设i位置之前的next值都已经求好了，i-1位置的next值为a。现在要求i位置的next值：如果i位置的值和i-1的前缀的后一个值（c）相等，则i的next值为a+1,否则再对c的前缀做同上处理，如果相等则+1,知道无法操作则返回0。  
![KMP](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/KMP03.PNG)   

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
## 125.验证回文串 
[验证回文串](https://leetcode-cn.com/problems/valid-palindrome/)   

* 思路：题目要求只考虑数字和字母，可以用ASCII码表来进行筛选，在ASCII码表中**大写字母的范围为65~90；小写字母的范围为97~122；数字的范围为48~57**，起手可以先将字符串中的大写字母转化为小写字母便于后续情况的考虑，toLowerCase();然后设置两个指针，分别从前后开始对比，**如果不是考虑范围内的标识符，则按顺移动，直至比较完成**
	* **当一个字符串全为非考虑范围内的标识符时，注意防止索引越界，通过先加再判断是否越界**
	
			i++;
		    if(i>=chs.length) return true;
	* 不用再循环体内刻意考虑i>j
	`//if(i > j) return false;//这样考虑不对，其实不用加这样一句,加return true是对的`
	```if((nowi>='a'&&nowi<='z')||(nowi>='0'&&nowi<='9'))这样也是可以的```

			class Solution {
			    public boolean isPalindrome(String s) {
			        if(s == null) return true;
			        String str = s.toLowerCase();
			        char[] chs = str.toCharArray();//空字符，标点都在内
			        int i = 0, j = chs.length-1;
			        while(i<=j) {
			            while(!((chs[i]>=97&&chs[i]<=122)||(chs[i]>=48&&chs[i]<=57))) {
			                i++;
			                if(i>=chs.length) return true;
			            }
			            while(!((chs[j]>=97&&chs[j]<=122)||(chs[j]>=48&&chs[j]<=57))) {
			                j--;
			                if(j < 0) return true;
			            }
			            //if(i > j) return false;//这样考虑不对，其实不用加这样一句
			            if(chs[i] != chs[j]) {
			                return false;
			            } else {
			                i++;
			                j--;
			            }
			        }
			        return true;
			    }
			}
## 136.只出现一次的数字
[只出现一次的数字](https://leetcode-cn.com/problems/single-number/)  

* 思路0：使用一个容器，遍历整个数组，容器中不含有某个数字时则添加该数字，如果容器中含有该数字则移除该数字，按照题意，容器中剩下的那个就是我们所需要的。
	* 关于这个容器最开始的想法是使用hashset（因为查找和添加O(1)的时间复杂度），但是set这个容器没有get方法，所以最后拿不出来我们想要的结果。
	* 所以决定用list容器，它具有很多巧妙的方法：
		* boolean add(E e) 
          将指定的元素添加到此列表的尾部。 
		* void add(int index, E element) 
          将指定的元素插入此列表中的指定位置。 
		* boolean contains(Object o) 
          如果此列表中包含指定的元素，则返回 true。 
		* E get(int index) 
          返回此列表中指定位置上的元素。 
		*  E remove(int index) 
          移除此列表中指定位置上的元素。  
		* boolean remove(Object o) 
          移除此列表中首次出现的指定元素（如果存在）。 
		* E set(int index, E element) 
          用指定的元素替代此列表中指定位置上的元素。 

				class Solution {
				    public int singleNumber(int[] nums) {
				       List<Integer> list = new ArrayList();
				        for(int i=0; i<nums.length; i++) {
				            if(!list.contains(nums[i])) {
				                list.add(nums[i]);
				            } else {
				                list.remove((Integer)nums[i]);//因为有两个remove方法，所以如果不装箱则它会默认使用的是参数为索引的那个方法。
				            }
				        }
				        return list.get(0);
				    }
				}
	* 思路1：**相同的数字进行异或操作结果为0**

			class Solution {
		    public int singleNumber(int[] nums) {
		        int result = 0;
		        for(int i = 0; i < nums.length; i++){
		            result ^= nums[i];
		        }
		        return result;
		   	 	}
			}
## 155.最小栈  
[最小栈](https://leetcode-cn.com/problems/min-stack/)

* 思路0：使用栈来进行常规的pop、push、peek操作，使用优先队列（最小堆）来保留最小值。
* 思路1：只使用一个栈来完成所有操作。**巧妙之处在于当发现待push的值比当前最小值更小的时候，push两次，先将之前的最小值push进去，再将当前的最小值push进去；pop的时候，如果发现pop出来的是最小值，则再pop一次**  

	    public void push(int x) {
	        if(x <= min){          
	            stack.push(min);
	            min=x;
	        }
	        stack.push(x);
	        
	    }
	    
	    public void pop() {
	         // if pop operation could result in the changing of the current minimum value, 
	        // pop twice and change the current minimum value to the last minimum value.
	        if(stack.pop() == min) min=stack.pop();
	    }
## 167.两数之和II-输入有序数组
* [两数之和](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

		class Solution {
		    public int[] twoSum(int[] numbers, int target) {
				if (numbers.length == 0) {
					return null;
				}
				int L = 0;
				int R = numbers.length - 1;
				while (L < R) {
					if (numbers[L] + numbers[R] == target) {
						return new int[] { L + 1, R + 1 };
					} else if (numbers[L] + numbers[R] < target) {
						L++;
					} else {
						R--;
					}
				}
				return new int[] { L + 1, R + 1 };
			}
		}
## 169.求众数  
[求众数](https://leetcode-cn.com/problems/majority-element/)  

* 思路0：这是一个做这种类型题的一般思路，采用一个HashMap，key存储不同的元素，value存储对应元素出现的次数，最终找到出现次数最大的即可。

	    public int majorityElement(int[] nums) {
	        HashMap<Integer, Integer> map = new HashMap();
	        int max = 0;
	        int res = nums[0];
	        for(int i=0; i<nums.length; i++) {
	            if(!map.containsKey(nums[i])) {
	                map.put(nums[i], 1);
	            } else {
	                int temp = map.get(nums[i]) + 1;
	                map.put(nums[i], temp);
	                if(temp > max) {
	                    max = temp;
	                    res = nums[i];
	                } 
	            }
	        }
	        return res;
	    }
* 思路1：思路0是针对这种类型题的通用解法，但对于这题来说它有自己的特点可以更巧妙的处理。**众数是指在数组中出现次数大于⌊ n/2 ⌋的元素，所有可以对该数组进行排序，索引n/2处的元素即为众数**  

	    public int majorityElement(int[] nums) {
	        Arrays.sort(nums);
	        return nums[nums.length/2];
	    }
* 思路2：针对本题的特点就更巧妙了。**众数所有元素中出现次数大于一半的数，所以具体如下代码，所以最后使得count>0的元素就是众数**

	    public int majorityElement(int[] nums) {
	         int temp=nums[0];
	    	int count=1;
	        for(int i=1;i<nums.length;i++){
	        	if(nums[i]==temp){
	        		count++;
	        	}else{
	        		count--;
	        		if(count==0){
	        			temp=nums[i];
	                                count=1;
	        		}
	        	}
	        }
	        return temp;
	    }
## 171.Excel表列序号
* [Excel表列序号](https://leetcode-cn.com/problems/excel-sheet-column-number/)  
* 解法：**设置了一个base变量，有动态规划的思想，避免了重复计算**

	    public int titleToNumber(String s) {
	        int length = s.length();
	        int result = 0;
	        int base = 1;
	        for (int i = length - 1; i >= 0; i--) {
	            int num = s.charAt(i)-'@';
	            result += num * base;
	            base = base *26;
	        }
	        return result;
	    }
## Manachar算法
### 1.什么是Manchar算法
> Manachar算法主要是处理字符串中关于回文串的问题的，它可以在 O（n） 的时间处理出以字符串中每一个字符为中心的回文串半径，由于将原字符串处理成两倍长度的新串，在每两个字符之间加入一个特定的特殊字符，因此原本长度为偶数的回文串就成了以中间特殊字符为中心的奇数长度的回文串了。
Manacher算法提供了一种巧妙的办法，将长度为奇数的回文串和长度为偶数的回文串一起考虑，具体做法是，在原字符串的每个相邻两个字符中间插入一个分隔符，同时在首尾也要添加一个分隔符，分隔符的要求是不在原串中出现，一般情况下可以用#号。
### 2.暴力法解决问题  
选择一个字符为中心往两边扩展，但这样存在一个问题。当回文串是奇数的情况下没有什么影响，但是当回文串是偶数的情况下，例如1224，按照之前的思路就解决不了这个问题。针对这个问题，采取的解决方法是**在字符串的开头、结尾、以及每个字符串的间隔添加特殊字符（例如#），再按照上述的方法计算最长回文串，把得到的结果除以2即可。**例如考虑11311这样一个字符串，首先对它进行处理得到**#1#1#3#1#1#，**得到最长回文串数组（**#也参与计算**）：1，3,5,3,1,11,1,3,5,3,1。把其中的结果11/2=5即为结果。
### 3.Manachar算法解决问题
#### 3.1 概念介绍
* **回文直径、回文半径、回文半径数组：**回文半径即以某一个字符开始扩，扩到某一边界的长度。直径即为两倍。回文半径数组即为用一个数组存储每个字符回文半径的值。
* **回文右边界：**在依次扩展半径的过程中，半径所到达的最右的位置。
* **回文右边界的中心：**与回文右边界相伴。例如："012131210",首先进过处理后字符串变为"#0#1#2#1#3#1#2#1#0#",回文右边界的中心为9，回文右边界为18。（9、18均为索引，从0开始计数）
#### 3.2算法过程  
* **情况1.**假设当前索引为i处的字符正在扩展半径，如果i不在回文右边界里面，直接暴力扩；
* 若i在回文右边界里面
	* **情况2.**找到i关于回文中心的对称点i'，如果i'的回文直径在（L,R）的范围内，那么此时i的回文半径等于i'的回文半径。
	![Manachar01.PNG](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/Manachar01.PNG)
	* **情况3.**区别于情况2，以i'为中心扩展的范围超出了(L,R)。此时i的回文半径为i到R。  
	![Manachar02.PNG](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/Manachar02.PNG)
	* **情况4.**最后一种情况，i'的回文半径刚好和L重合。在i到R这一段范围内不用再比较了，一定是回文的。但R之后的字符串需要继续比较。  
	![Manachar03.PNG](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/Manachar03.PNG)
#### 3.3算法复杂度分析
 对于情况2和情况3，都可以直接得出答案，所以时间复杂度为O(1)。对于情况1和情况4，它们会造成R往右扩，但这两个过程的最坏情况就是时间复杂度为O(n)。所以Manachar算法的时间复杂度是线性的。
#### 3.4应用举例
* 现有一个字符串，在该字符串后添加最短的字符串使之成为回文串。例如：给定字符串"abcb"，则符合题目要求的字符串为"a"。
	* 思路：即要找包含最后一个字符的最长回文串。剩余部分的逆序即为所添加的字符串。
### 算法实现
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
## BFPRT算法
### 1.什么是BFPRT算法
> 在一大堆数中求其前k大或前k小的问题，简称TOP-K问题。而目前解决TOP-K问题最有效的算法即是BFPRT算法，其又称为中位数的中位数算法。
### 2.先导算法
在介绍先导算法之前，当然也存在暴力解决方法，即把整个数组排好序，然后在排好序的数组中取第k个值即可（**为避免混淆，规定k是从索引1开始的**）。现在考虑一种更优的解法，即采用**荷兰国旗**问题的思路来求解，首先将整个数组按照某个**给定的值(target)**进行partition，分成小于、等于、大于三部分。记录分隔这三部分的索引，例如1000个数按照小于、等于、大于分隔为1~500,501~600,601~1000；这个样如果说要求第800小的数，那么就在大于区域重复上述操作，直至得出结果。这个算法的长期期望为O(n)。
### 3.BFPRT算法
BFPRT算法的思路和上述的荷兰国旗问题的思路一致，唯一不同的地方在于BFPRT算法的**target**不是随机选定的，这样就使得BFPRT算法的时间复杂度是严格的O(n)，而不是依概率长期期望到达O(n)。
#### 3.1 如何选定target？
* 1.**首先逻辑分组，相邻5个数为一组；**（为什么是5个数为一组呢？因为发明这个算法的是5个人，BFPRT即为他们五个人的姓名首字母，所以这个算法也可以叫做5个好朋友算法，手动狗头）
* 2.**然后每个小组之间排序，跨组之间不保证有序；**。
	* 时间复杂度：5个数排序时间复杂度为O(1),总共有n/5个组，所以这个过程的时间复杂度为O(n)。
* 3.**把每个组的中位数拿出来重新组成一个数组new_arr（偶数个数随机选择上中位数或者下中位数），**新的数组长度是n/5的。
* 4.**找到new_arr的中位数，即递归调用bfprt算法：bfprt(new_arr, new_arr.length/2),当得到新数组的长度小于等于5时，返回的值即为所求的target值；**
* 5.**根据所得的target值进行partition。**
#### 3.2 为什么要这样选择target值？
这样选择的target在partition之后的最坏情况是多少？在所有中位数组成的新数组中新选的中位数为temp，那么在这n/5个数中有n/10个数比temp大，在这n/10个数中至少又有2个数分别比这n/10个数大，所以**至少**有3n/10个数比所求的temp大，依次类推，对于最后求出来的target也至少有3n/10个数比target大，**所以要处理的最坏情况的数据量为7n/10**,所以选取target的过程整个的时间复杂度为T(N)=T(N/5)+T(7N/10),计算出来时间复杂度为O(n)。