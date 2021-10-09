package com.xxy.module_debug.leetcode.editor.cn; 
 //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 822 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals{

    public static void main(String[] args) {
         Solution solution = new MergeIntervals().new Solution();
//         int[][] intervals = new int[][]{{1,6},{1,6},{8,10},{15,18}};
         int[][] intervals = new int[][]{{2,6},{1,3},{8,10},{15,18}};
         int[][] x =  solution.merge(intervals);
        System.err.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        int[] target = null;
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[i];
            if(target == null){
                target = temp;
            }else {
                 if (target[0] == temp[0] && target[1] <= temp[1]){
                     target = temp;
                }else if (target[1] > temp[0] && target[1] <= temp[1]){
                     target = new int[]{target[0],temp[1]};
                 }else if (target[1] < temp[0]){
                    result.add(target);
                    target = temp;
                }else {
                    target = new int[]{target[0],Math.max(temp[1],target[1])};
                }
            }
            if (i == intervals.length-1 && target != null){
                result.add(target);
            }
        }
        return result.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}