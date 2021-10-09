//package com.xxy.module_debug.leetcode.editor.cn;
//
//public class KuaiPai {
//
//
//    public static void main(String[] args) {
//
//        int[] x = new int[]{9,4,6,8,3,10,4,6};
//        quickSort(x,0,x.length-1);
//
//        System.err.println(x);
//
//    }
//
//
//    static void quickSort(int[] nums ,int start,int end){
//
//        if (start >= end){
//            return;
//        }
//        int piv = nums[start];
//        int i = start;
//        int j = end;
//
//        while (i<j){
//
//            while (nums[j] >= piv && i < j){
//                j--;
//            }
//            while (nums[i] <= piv && i < j){
//                i++;
//            }
//
//            if (i<j){
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
//            }
//
//
//        }
//        quickSort(nums,start,j-1);
//        quickSort(nums,j+1,end);
//    }
//
//
//}
//[]