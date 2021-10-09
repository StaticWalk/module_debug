package com.xxy.module_debug.leetcode.editor.cn; 
 //给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。 
//
// 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。 
//
// 示例 1: 
//
// 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
// Related Topics 堆 
// 👍 170 👎 0

import java.util.*;

public class FindKPairsWithSmallestSums{

    public static void main(String[] args) {
         Solution solution = new FindKPairsWithSmallestSums().new Solution();
         solution.kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.get(0)+o1.get(1)-o2.get(1)-o2.get(1));

        List<List<Integer>> result = new ArrayList<>();

//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                List<Integer> temp = new ArrayList();
//                temp.add(nums1[i]);
//                temp.add(nums2[j]);
//                if (pq.size() < k) {
//                    pq.offer(temp);
//                } else {//如果堆顶元素 > 新数，则删除堆顶，加入新数入堆
//                    List<Integer> x = pq.peek();
//                    if (x.get(0) + x.get(1) >= temp.get(0)+temp.get(1)){
//                        pq.poll();
//                        pq.offer(temp);
//                    }
//                }
//            }
//        }


        for (int i = 0; i < k&&!pq.isEmpty(); i++) {
            result.add(pq.poll());
        }
        return result;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}