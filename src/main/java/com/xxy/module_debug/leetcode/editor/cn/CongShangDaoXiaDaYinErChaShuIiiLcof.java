package com.xxy.module_debug.leetcode.editor.cn; 
 //请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
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
// 👍 83 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CongShangDaoXiaDaYinErChaShuIiiLcof{

    public static void main(String[] args) {
         Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
//         TreeNode t1 = new TreeNode(3);
//         TreeNode t2 = new TreeNode(9);
//         TreeNode t3 = new TreeNode(20);
//         TreeNode t4 = new TreeNode(15);
//         TreeNode t5 = new TreeNode(7);
//         t1.left = t2;
//         t2.left = null;
//         t2.right = null;
//         t3.left = t4;
//         t3.right = t5;
//         t1.right = t3;
//        List<List<Integer>> x = solution.levelOrder(t1);
//        System.err.println();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

// * Definition for a binary tree node.
  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        temp.add(root);
        int x = -1;
        while (!temp.isEmpty()){
            x++;
            temp = new ArrayList();
            List<Integer> list = new ArrayList<>();
            while (!stack.empty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                if (x%2==0){
                    if (node.left !=null){
                        temp.add(node.left);
                    }
                    if (node.right !=null){
                        temp.add(node.right);
                    }
                }else {
                    if (node.right !=null){
                        temp.add(node.right);
                    }
                    if (node.left !=null){
                        temp.add(node.left);
                    }
                }
            }
            for (TreeNode treeNode : temp) {
                stack.add(treeNode);
            }
            result.add(list);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}