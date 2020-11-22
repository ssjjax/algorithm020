学习笔记

tips：
对一个问题没有思路、懵逼时：
思路一 先暴力法
思路二 列举最基本的几个情况。找 最近 重复子问题 （如爬楼梯问题）

优化思路：空间换时间；升唯


链表：
有时可加辅助的哑结点求解

链表的常见语句含义：（以206 反转链表为例）
  ListNode nextTemp = curr.next; // 就是一个赋值语句。保存一下对应的节点
  curr.next = prev; 		         // 表示指向，左指向右（即curr指向prev这个节点）
  prev = curr;		               // 表示向后者看齐（即 二者都表示curr这个位置）
  curr = nextTemp;		           // 同上
  
  涉及到链表的操作，多在纸上把过程先画出来，再写程序。
 

常用API：
  System.arraycopy(A[] , index , B[] ,index , length);
  Arrays.sort(A[]);
  数组转list：
  Arrays.asList(nums[i], nums[j], nums[k]);
  返回一个空list：
  Collections.emptylist()
  
  LinkedHashSet:
  可维护先后顺序，又可去重
  
  
  （ 这个md的文件应该怎么编辑 为啥是乱的 - _ -||)
  （感觉有的暴力法也有点价值，多解法的题每个解法都要练吗 -_-）
