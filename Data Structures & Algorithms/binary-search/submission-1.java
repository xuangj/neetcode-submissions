class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int mid = nums.length / 2;

        if (nums.length == 0) {
            return index;
        }

        if (nums[mid] > target) {
            int[] subNums = Arrays.copyOfRange(nums, 0, mid);
            index = search(subNums, target);
        } else if (nums[mid] < target) {
            int[] subNums = Arrays.copyOfRange(nums, mid + 1, nums.length);
            int result = search(subNums,target);
            if (result == -1) {
                return -1;
            }
            return result + mid + 1;
        } else if (nums[mid] == target) {
            index = mid;
        }

        return index;
    }
}
