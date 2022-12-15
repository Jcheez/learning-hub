package leetcode.java;

import java.util.TreeSet;

class MedianFinder {

    public TreeSet<Double> map;
    public int numElements;
    public double median;

    public MedianFinder() {
        this.map = new TreeSet<>();
        this.numElements = 0;
        this.median = 0;
    }
    
    public void addNum(int num) {
        if (this.numElements == 0) {
            this.median = num;
            this.map.add((double) num);
        } else {
            map.add((double) num);
            if (numElements % 2 == 0) {
                if (this.median > num) {
                    double secondNum = map.lower(this.median);
                    this.median = (this.median + secondNum) / 2;
                } else {
                    double secondNum = map.higher(this.median);
                    this.median = (this.median + secondNum) / 2;
                }
            } else {
                if (this.median > num) {
                    this.median = map.lower(this.median);
                } else {
                    this.median = map.higher(this.median);
                }
            }
        }
        this.numElements += 1;
    }
    
    public double findMedian() {
        return Math.round(this.median*10) / 10.0;
    }
}
