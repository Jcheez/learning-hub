package leetcode.java;

// Time complexity: O(logN)
// Space complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (nums[pivot] == target) {
            return pivot;
        }

        int leftSearch = bsearch(0, pivot-1, nums, target);
        return leftSearch == -1 ? bsearch(pivot+1, nums.length-1, nums, target) : leftSearch;
    }

    public int bsearch(int left, int right, int[] nums, int target) {
        
        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        if (nums.length == 1) {
            return 0;
        }

        while (right >= left) {
            int mid = (left + right) / 2;
            
            if (nums[mid] < nums[mid-1 == -1 ? right : mid-1]) {
                return mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }
}