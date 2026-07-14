class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.stream(nums).distinct().sorted().toArray();
        int m = arr.length;
        int maxCount = 0;

        for (int i = 0; i < m; i++) {
            int target = arr[i] + n - 1;
            int j = upperBound(arr, target) - 1;
            maxCount = Math.max(maxCount, j - i + 1);
        }
        return n - maxCount;
    }

    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}