package com.xxy.module_debug.leetcode.editor.cn; 
 //从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打toArray。
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 66 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CongShangDaoXiaDaYinErChaShuLcof{

    public static void main(String[] args) {
         Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

class Solution {
    public int[] levelOrder(TreeNode root) {

        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}