package leetcode.java;

import java.util.Arrays;
import java.util.PriorityQueue;

// Time complexity: O(N + klogN)
// Space complexity: O(N)

class point implements Comparable<point> {
    public int x;
    public int y;
    public double distanceToOrigin;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
        this.distanceToOrigin = Math.sqrt((double) x*x + (double) y*y);
    }

    public int compareTo(point p) {
        if (p.distanceToOrigin > this.distanceToOrigin) {
            return -1;
        } else if (p.distanceToOrigin < this.distanceToOrigin) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        point[] refinedPoints = new point[points.length];
        int[][] res = new int[k][2];
        for (int i=0; i<points.length; i++) {
            refinedPoints[i] = new point(points[i][0], points[i][1]);
        }

        PriorityQueue<point> pq = new PriorityQueue<>(Arrays.asList(refinedPoints));

        for (int i=0; i<k; i++) {
            point polled = pq.poll();
            res[i][0] = polled.x;
            res[i][1] = polled.y;
        }
        return points;
    }
}