package com.xxy.module_debug.leetcode.editor.cn; 
 //输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 221 👎 0

public class LianXuZiShuZuDeZuiDaHeLcof{

    public static void main(String[] args) {
         Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int num : nums){
            if (cur <= 0){
                cur = num;
            }else {
                cur += num;
            }
            max = Math.max(max,cur);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}