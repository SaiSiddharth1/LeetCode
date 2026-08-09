import java.util.*;

class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = nums.length;

        // Build children list
        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        // Calculate depth using BFS
        int[] depth = new int[n];
        depth[0] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int h = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int child : children[node]) {
                depth[child] = depth[node] + 1;
                h = Math.max(h, depth[child]);
                q.offer(child);
            }
        }

        // Calculate weighted sum
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * (h - depth[i] + 1);
        }

        return ans;
    }
}