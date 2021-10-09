package com.xxy.module_debug.leetcode.editor.cn; 
 //给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 422 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi{

    public static void main(String[] args) {
         Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

// * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<TreeNode> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        temp.add(root);
        while (!temp.isEmpty()){
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nextList = new ArrayList<>();
            while (!temp.isEmpty()){
                list.add(temp.get(0).val);
                if (temp.get(0).left != null) nextList.add(temp.get(0).left);
                if (temp.get(0).right != null)  nextList.add(temp.get(0).right);
                temp.remove(0);
            }
            result.add(list);
            temp = nextList;
        }
        Collections.reverse(result);
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}