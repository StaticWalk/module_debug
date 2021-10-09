package com.xxy.module_debug.leetcode.editor.cn;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 */
public class _1116 {

    public static void main(String[] args) {


//        int[][] x =  {{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
        int[][] x = {{7,0},{4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        reconstructQueue(x);

        System.err.println();


    }

    //todo swap

    static void insert(int[][] people,int now,int target){

        int[] temp = people[now];
        for (int i = now ; i > target; i--) {
            people[i] = people[i-1];
        }
        people[target] = temp;

    }


    static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people,((o1, o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0]));

        for (int i = 1; i < people.length; i++) {
          insert(people,i,people[i][1]);
        }

        return people;
    }

}
