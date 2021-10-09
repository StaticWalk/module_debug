package com.xxy.module_debug.leetcode.editor.cn;



/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号
 * 的奇偶性，而不是节点的值的奇偶性。请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂
 * 度应为 O(nodes)，nodes 为节点总数。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 */

public class _1113 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        oddEvenList(node1);
        System.err.println();

    }

    static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode l1 = odd;
        ListNode l2 = even;
        int index = 1;
        ListNode current = head;
        while (current != null){
            if (index % 2 != 0 ){
                l1.next = current;
                l1 = l1.next;
            }else {
                l2.next = current;
                l2 = l2.next;
            }
            current = current.next;
            index += 1;
        }
        l2.next = current;
        l1.next = even.next;

        return odd.next;
    }



    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
