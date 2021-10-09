package com.xxy.module_debug.leetcode.editor.cn; 
 //反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1524 👎 0

public class ReverseLinkedList{

    public static void main(String[] args) {
         Solution solution = new ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
//        ListNode p1 = head;
//        ListNode result = null;
//
//        while (p1 != null){
//            result = new ListNode(p1.val, result) ;
//            result.next = result;
//
//            p1 = p1.next;
//        }
//        return result;

        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode next = head.next;

        while (head != null){
            head.next = pre;
            pre = head;
            head = next;
            if (head != null){
                next = head.next;
            }
        }

        return pre;

    }


}//leetcode submit region end(Prohibit modification and deletion)

}