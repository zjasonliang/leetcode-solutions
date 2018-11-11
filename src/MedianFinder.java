import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    private void checkBalance() {
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }
    }

    public void addNum(int num) {
        if (minHeap.size() == 0) {
            minHeap.add(num);
        } else if (num < minHeap.peek()) {
            maxHeap.add(num);
            checkBalance();
        } else {
            minHeap.add(num);
            checkBalance();
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        } else if (minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    }

    public static void main(String [] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());
    }
}

// ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//         [[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]