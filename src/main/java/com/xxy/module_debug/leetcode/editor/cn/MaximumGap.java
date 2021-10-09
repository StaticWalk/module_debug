package com.xxy.module_debug.leetcode.editor.cn; 
 //给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。 
//
// 如果数组元素个数小于 2，则返回 0。 
//
// 示例 1: 
//
// 输入: [3,6,9,1]
//输出: 3
//解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。 
//
// 示例 2: 
//
// 输入: [10]
//输出: 0
//解释: 数组元素个数小于 2，因此返回 0。 
//
// 说明: 
//
// 
// 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。 
// 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。 
// 
// Related Topics 排序 
// 👍 275 👎 0

public class MaximumGap{

    public static void main(String[] args) {

        int[] x = new int[]{1,1,1,1};
//        int[] x = new int[]{3,6,9,1};
        Solution solution = new MaximumGap().new Solution();
        int result = solution.maximumGap(x);
        System.err.println();
    }
        //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public int maximumGap(int[] nums) {

            if (nums.length<2){
                return 0;
            }
            int max = 0;

            quickSort(nums,0,nums.length-1);

            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max,nums[i]-nums[i-1]);
            }
            return max;
        }

        void quickSort(int[] a,int L,int R){
            int i = L;
            int j = R;
            int pivot = a[(L+R)/2];
            while (i<=j){
                while (a[i] < pivot){
                    i++;
                }
                while (a[j] > pivot){
                    j--;
                }
                if (i<=j){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                    j--;
                }
            }
            if (i<R){
                quickSort(a,i,R);
            }
            if (j>L){
                quickSort(a,L,j);
            }
        }







//            if (nums.length<2){
//                return 0;
//            }
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MIN_VALUE;
//            for (int num : nums) {
//                max = Math.max(max, num);
//                min = Math.min(min, num);
//            }
//            int length = 0;
//            int duration = 0;
//
//            byte[] ints = new byte[max+1-min];
//            for (int num : nums) {
//                ints[num-min] = 1;
//            }
//            if (max-min==0){
//                return 0;
//            }
//
//            for (int i = 0; i <= max-min ; i++) {
//                if (ints[i] == 1){
//                    length = Math.max(length,duration+1);
//                    duration = 0;
//                    continue;
//                }
//                duration ++;
//            }
//            return length;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}