package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    Comparator<Integer> Descending = (o1, o2) -> {
        if (o1 > o2)
            return 1;
        else if (o1 == o2)
            return 0;
        else
            return -1;
    };
    Comparator<Integer> Ascending = (o1, o2) -> {
        if (o1 > o2)
            return -1;
        else if (o1 == o2)
            return 0;
        else
            return 1;
    };
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(10, Descending);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Ascending);

    // Adds a number into the data structure.
    void addNum(int num) {
        if (this.maxHeap.isEmpty()) {
            this.maxHeap.add(num);
            return;
        }
        if (num < maxHeap.peek())
            this.maxHeap.add(num);
        else
            this.minHeap.add(num);
        this.balanceHeaps();
    }

    void balanceHeaps() {
        while (Math.abs(this.maxHeap.size() - this.minHeap.size()) > 1) {
            if (this.maxHeap.size() > this.minHeap.size()) {
                int temp = this.maxHeap.poll();
                this.minHeap.add(temp);
            } else {
                int temp = this.minHeap.poll();
                this.maxHeap.add(temp);
            }
        }
    }

    // Returns the median of current data stream
    double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

}
