class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.stream(nums).distinct().sorted().toArray();
        int m = arr.length;
        int maxCount = 0;
        int right = 0;

        for (int left = 0; left < m; left++) {
            while (right < m && arr[right] - arr[left] < n) {
                right++;
            }
            maxCount = Math.max(maxCount, right - left);
        }
        return n - maxCount;
    }
}