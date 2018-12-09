
#Algorithm

##13.罗马数字转整数(2018/11/13)
* 思路：用switch进行判断，在有分歧的分支进行判断即可。
	* 字符串没有索引，s[i]是不存在的，解决办法是s.charAt(i),注意这是字符类型。
	* 当需要判断后一个元素是否有关联的时候需要首先判断是否越界。例如，(i+1)<s.length() &&s.charAt(i+1) == 'V'
##14.最长公共前缀(2018/11/14)
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
##20.有效的括号(2018/11/15)
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
##21.合并两个有序链表(2018/11/16)
* 思路：和数组的归排序相同,一个merge的过程，但我是用额外的一个链表来存储结果的，应该可以在原有的链表上进行操作这样可以节省空间复杂度。这题可以再做思考。  
	* 我设置了一个temp变量来做操作，并用result记录第一个结点的。
	* 首先单独比较第一次把第一个结点确定下来，这样后面好操作。
	* 最后三种特殊情况输入都为null则输出也为null，其中一个为null则直接输出另外一个。  
![singleListNode](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/singleListNode.PNG)  
![mergeTwoLists](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/mergeTwoLists.PNG)
![mergeTwoListsResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/mergeTwoListsResult.PNG)
##26.删除排序数组中的重复项(2018/11/17)
* 思路：设置两个指针，p1始终指示[0,p1]范围内排好序无重复的数组,p2始终指向待比较的数组元素。因为传入的是已排好序的数组，所以nums[p2]>=nums[p1]。分两种情况：若nums[p2] == nums[p1],那么p2++,如果nums[p2] > nums[p1] (所需要的数组元素)，swap(nums,++p1, p2++)。  
![removeDuplicates](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/removeDuplicates.PNG)  
![removeDuplicatesResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/removeDuplicatesResult.PNG)
##27.移除元素(2018/11/18)
* 思路：同26，首先要明确一点对数组执行删除元素的操作只能是逻辑上的删除，不可能是物理上的删除，因为数据一旦确定长度就不会发生改变，所以删除的本质实际上是就是交换位置和限定长度，这通常都是要设置两个指针，而且一前一后，前一个指针最为返回的长度，后一个指针作为待比较的数组元素。  
![removeElements](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/removeElements.PNG)  
![removeElementsResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/removeElementsResult.PNG)
##28.实现strStr()(2018/11/18)
![strStr](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/strStr.PNG)  
![strStrResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/strStrResult.PNG)
##2.两数相加(2018/11/19)
* 思路：逆序并没有什么思维上的难度，向左进位变为向右进位就行了，这题大体思路上很直接，主要在于细节的处理以及界限的判定。
	* 注意空指针异常，和21题做一个对比，为什么21没有专门为结点指示next结点没有出现空指针异常，而这题就出现了呢？
	* 什么情况下需要下一个结点：1.其中任何一个或两个链表的下一个结点不为空。2.有进位。
	* 设置一个进位符是点睛之笔。  
![addTwoNumbers](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/addTwoNumbers.PNG)  
![addTwoNumbersResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/addTwoNumbersResult.PNG)
##35.搜索插入位置(2018/11/19)
* 思路：设置一个索引i=0.如果nums[i]<target,则i++.如果nums[target]>=target,则return i.最后返回nums.length;
![searchInsert](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/searchInsert.PNG)  
![searchInsertResult](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/searchInsertResult.PNG)
##3.无重复字符的最长字串(2018/11/20)
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
###优化的滑动窗口(2018/11/20)
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
###扩展：假设字符集为 ASCII 128
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
##5.最长回文字串(2018/11/22)
思路：是一个模式匹配
##7.整数反转(2018/11/24)
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
##判断一个链表是否是回文结构(2018\11\24)
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
##将单向链表按某值划分为左边小、中间相等、右边大的形式。(2018/11/25)
* 【题目】给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。除这个要求外，对调整后的节点顺序没有更多的要求。 例如：链表9->0->4->5->1，pivot=3。 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做要求。
	* 思路1(笔试)：一个荷兰国旗问题，将链表结点的值放入数组中（结点类型的数组），在数组中partition后，再用链表串起来即可。时间复杂度为O(n),空间复杂度为O(n)。
		* 注意partition的终止过程是while(pre < more).
	* 思路2(面试)：上诉方法（即荷兰国旗不具备稳定性），而且需要额外的空间复杂度。首先函数需要两个参数：待partition链表的头结点，用以分割的数num。需要三个引用变量都是结点类型less、eq、more。第一次对链表进行遍历的时候分别找到第一个小于、等于、大于num的结点并赋值给less、eq、more。同时为这三个区域分别准备一个end引用，没加入一个节点后end就指向这个刚移入的end。最后把这三个区域连接起来。时间复杂度为O(n),空间复杂度为O(1)。
		* 怎样把最后的三个链表连接起来可真是绕死我了。这里推荐左神的code。
##复制含有随机指针结点的链表(2018/11/26)
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
##两个单链表相交的一系列问题(2018/11/26)
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
##实现二叉树的先序、中序、后序遍历，包括递归方式和非递归方式(2018/11/27)
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
##在二叉树中找到一个结点的后继结点(2018/11/29)
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
##二叉树的序列化和反序列化(2018/11/29)
怎么将一棵树变成一个字符串，通过这个字符串就能重构出这棵树。 
 
* 先序遍历的方式序列化
![preOrderTraverse_serialize](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/preOrderTraverse_serialize.png)
* #代表null  
同理中序、后续的序列化和反序列化原理同上。
* 按层序列化
![layer_serialize](https://raw.githubusercontent.com/Laputalyc/Algorithm/master/Leetcode/layer_serialize.png)
##判断一棵树是否是平衡二叉树(2018/11/30)
* 什么叫做平衡人二叉树：每个结点的左子树和右子树的高度差不超过1。  
**在处理二叉树的问题的时候递归函数很好用**
* 首先怎样判断一个头结点构成的数是否是平衡二叉树
	* 1）左子树是一颗平衡二叉树。
	* 2）右子树是一颗平衡二叉树。
	* 3）左子树的高度和右子树的高度差不超过1。  
根据以上的分析判断一个结点构成的树是否是平衡二叉树最后需要返回两个值，一个Boolean类型的是否是平衡二叉树，另一个返回值是整数类型的树的高度。
##判断一棵树是否是搜索二叉树(Binary Search Tree)(2018/11/30)
* 什么叫做搜索二叉树：对于任何一个节点，左子树上结点的值都比它小，右子树上所有结点的值都比它大。空数是搜索二叉树。
* 怎样判断一颗二叉树是否是搜索二叉树？一棵树的中序遍历是依次升序的就说明是搜索二叉树。
	* 非递归版本很容易想到。
	* 递归版本【@ author 李昱辰】可以这样来考虑：要判断一棵树是否是搜索二叉树它得满足三个条件1.左子树是搜索二叉树。2.右子树是搜索二叉树。3.当前结点的值要大于左子树头结点的值，要小于右子树**最左结点的值**。
		* 特别左右子树为null的情况，任何一边为null都表示这一边满足要求3。
##判断一棵树是完全二叉树(complete binary tree)(2018/11/30)
* 1.如果一个结点有右孩子但没有左孩子，则一定不是完全二叉树。
* 2.如果一个结点的孩子不全，则它按层遍历后面遇到的结点必须都是叶节点才能是完全二叉树。 
* 3.空树不是完全二叉树。  
##已知一颗完全二叉树，求其结点的个数(2018/12/4)  
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












