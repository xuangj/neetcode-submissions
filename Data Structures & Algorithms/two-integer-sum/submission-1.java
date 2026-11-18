class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        if ((nums.length == 2) && ((nums[0] + nums[1]) == target)) {
            return new int[] {0, 1};
        }

        Map<Integer, Integer> differences = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (differences.containsKey(nums[i])) {
                indices[0] = differences.get(nums[i]);
                indices[1] = i;
            } else {
                differences.put(diff, i);
            }
        }


        return indices;
    }
}
