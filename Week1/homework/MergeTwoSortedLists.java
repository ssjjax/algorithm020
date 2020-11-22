/**
 * @author Suisijia
 * @create 2020-11-22 15:58
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建一个辅助的哑节点
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        while (l1 != null && l2 != null)  {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }


    // （默认给的链表节点类）
     class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
