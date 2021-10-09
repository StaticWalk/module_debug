package com.xxy.module_debug.parallel;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        int sumCount = 283996;
        int preCount = 8640;
        int topK = 865;
        long target = 1000000000;
        String fileName = "/home/stevfa/IdeaProjects/" + Integer.toString(sumCount) + "txt";
        String resultName = "/home/stevfa/IdeaProjects/" + Integer.toString(sumCount) + "_resulttxt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String lineStr = null;
        long start = System.currentTimeMillis();
        TopKFinder md = new TopKFinder(topK);
        double maxMid2 = 0;
        int sp = 0;
        List<Integer> now = new LinkedList<>();

        for(int i = 0;i<preCount; ++i)
        {
            lineStr = br.readLine();
            int a = Integer.parseInt(lineStr);
            md.addNum(a);
            now.add(a);
        }
        maxMid2 =md.findTopK();
        int i = 0;
        while((lineStr =br.readLine())!=null) {
            md.removeNum(((LinkedList<Integer>) now).getFirst());
            now.remove(0);
            i++;
            int a = Integer.parseInt(lineStr);
            md.addNumBalance(a);
            now.add(a);
            double curMid2 = md.findTopK();
            if (curMid2 > maxMid2) {
                sp = i;
                maxMid2 = curMid2;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("heap cost "+(end -start)/1000+"maxMid :"+maxMid2 +" sp:"+sp);
    }


    private static class TopKFinder {
        int count;
        int topK;
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public TopKFinder(int k) {
            topK = k;
            maxHeap = new PriorityQueue<>((x, y) -> y - x);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (minHeap.size() < topK) {
                minHeap.offer(num);
            } else {
                if (num >= minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                } else {
                    maxHeap.offer(num);
                }
            }

        }

        public void addNumBalance(int num) {
            if (minHeap.size() < topK) {
                if (num >= minHeap.peek()) {
                    minHeap.offer(num);
                } else {
                    maxHeap.offer(num);
                    minHeap.offer(maxHeap.poll());
                }
            } else {
                if (num <= maxHeap.peek()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                    maxHeap.offer(minHeap.poll());
                }
            }

        }

        public double findTopK() {
            return minHeap.peek();
        }

        public void removeNum(int num) {
            if (num <= maxHeap.peek()) {
                maxHeap.remove(num);
            } else {
                minHeap.remove(num);
            }
        }
    }


    public static int findSubBiggerThan(List<Integer> raw, long x)
    {
        long start = System.currentTimeMillis();
        List<Long> dp = new ArrayList<>();
        long a = 0;
        int sp = 0;
        int ep = 0;
        dp.add(a);
        for (int i = 0; i < raw.size(); ++i)
        {
            a = a + raw.get(i);
            dp.add(a);
        }


        int i = 0;
        int j = 1;
        int min = raw.size();
        while(true)
        {
            while(dp.get(j)-dp.get(i) < x && j < raw.size())
            {
                j++;
            }

            if (j == raw.size() && dp.get(j)-dp.get(i) < x)
            {
                break;
            }

            if (dp.get(j)-dp.get(i) >= x)
            {
                if (j - i < min)
                {
                    min = j - i;
                    sp = i;
                    ep = j-1;
                }
            }

            while(i<j && dp.get(j)-dp.get(i) > x)
            {
                i++;
                if (dp.get(j)-dp.get(i) >= x)
                {
                    if (j - i < min)
                    {
                        min = j - i;
                        sp = i;
                        ep = j-1;
                    }
                }
            }
        }

        long end = System.currentTimeMillis();
        List<Integer> sub = raw.subList(sp, ep +1);
        long sum = 0;
        for (int r =0; r< sub.size() ; ++r)
        {
            sum = sum + sub.get(r);
        }

        System.out.println("findSubBiggerThan cost " + (end -start)/1000 + " min: " + min + " sp: " + sp + " ep: " + ep);
        return min;
    }

}