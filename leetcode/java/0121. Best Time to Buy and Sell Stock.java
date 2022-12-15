package leetcode.java;

// Time complexity: O(N)
// Space complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        
        int lowest = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price > lowest) {
                maxProfit = maxProfit > price - lowest ? maxProfit : price - lowest;
            } else {
                lowest = price;
            }
        }
        return maxProfit;
    }
}