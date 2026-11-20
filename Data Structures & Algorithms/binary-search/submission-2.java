class Solution {
    public int search(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // discard left half to look in right half
                left = mid + 1;
            } else {
                // discard right half to look in left half
                right = mid - 1;
            }
        }
        return -1;
    }
}
