package com.xxy.module_debug.leetcode.editor.cn; 
 //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1398 👎 0

public class MergeTwoSortedLists{

    public static void main(String[] args) {
         Solution solution = new MergeTwoSortedLists().new Solution();
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(2);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(4);
         ListNode l5 = new ListNode(5);
         l1.next = l3;
         l3.next = l5;
         l2.next = l4;

        ListNode x = solution.mergeTwoLists(l1,l2);

        System.err.println();



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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode r1 = result;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                r1.next = l1;
                l1 = l1.next;
            }else {
                r1.next = l2;
                l2 = l2.next;
            }

            r1 = r1.next;
        }
        if (l1 == null){
            r1.next = l2;
        }
        if (l2 == null){
            r1.next = l1;
        }

        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)




}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}